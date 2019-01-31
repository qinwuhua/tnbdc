package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Ydjh;
import com.hdsx.zxyh.entity.Ydjhmx;
import com.hdsx.zxyh.entity.Ydwc;
import com.hdsx.zxyh.entity.Ydwcmx;
import com.hdsx.zxyh.mapper.YdwcMapper;
import com.hdsx.zxyh.service.YdjhService;
import com.hdsx.zxyh.service.YdwcService;
import com.hdsx.zxyh.utils.UuidUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class YdwcServiceImpl implements YdwcService {

    @Resource
    private YdwcMapper ydwcMapper;

    @Override
    public List<Ydjh> getYdwc(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ydwcMapper.getYdwc();
    }

    @Override
    public int addYdwc(Ydwc ydwc) {
        if (StringUtils.isEmpty(ydwc.getId())){
            ydwc.setId(UuidUtil.getUUID());
        }
        // 增加子表
        if (ydwc.getList().size()>0) {
            for (Ydwcmx ydwcmx: ydwc.getList()) {
                ydwcmx.setMxid(UuidUtil.getUUID());
                ydwcmx.setYdid(ydwc.getId());
            }
            ydwcMapper.addYdwcmx(ydwc.getList());
        }
        // 增加主表
        return ydwcMapper.addYdwc(ydwc);
    }

    @Override
    public int deleteYdwc(String[] ids) {
        // 删除子表
        ydwcMapper.deleteYdwcmx(ids);
        // 删除主表
        return ydwcMapper.deleteYdwc(ids);
    }

    @Override
    public int updateYdwc(Ydwc ydwc) {
        //删除子表
        ydwcMapper.deleteYdwcmx(new String[]{ydwc.getId()});
        //增加子表
        if (ydwc.getList().size()>0) {
            for (Ydwcmx ydwcmx : ydwc.getList()) {
                ydwcmx.setMxid(UuidUtil.getUUID());
                ydwcmx.setYdid(ydwc.getId());
            }
        }
        ydwcMapper.addYdwcmx(ydwc.getList());
        //更新主表
        return ydwcMapper.updateYdwc(ydwc);
    }
}
