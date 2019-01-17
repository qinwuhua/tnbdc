package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Ybgc;
import com.hdsx.zxyh.entity.Ybgcmx;
import com.hdsx.zxyh.mapper.YbgcMapper;
import com.hdsx.zxyh.service.YbgcService;
import com.hdsx.zxyh.utils.UuidUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class YbgcServiceImpl implements YbgcService {

    @Resource
    private YbgcMapper ybgcMapper;

    @Override
    public List<Ybgc> getYbgc(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ybgcMapper.getYbgc();
    }

    @Override
    public int addYbgc(Ybgc ybgc) {
        if (StringUtils.isEmpty(ybgc.getId())){
            ybgc.setId(UuidUtil.getUUID());
        }
        //增加子表
        for (Ybgcmx ybgcmx : ybgc.getYbgcmxList()) {
            ybgcmx.setId(UuidUtil.getUUID());
            ybgcmx.setYbid(ybgc.getId());
        }
        ybgcMapper.addYbgcmx(ybgc.getYbgcmxList());
        //增加父表
        return ybgcMapper.addYbgc(ybgc);
    }

    @Override
    public int deleteYbgc(String[] ids) {
        //删除子表
        ybgcMapper.deleteYbgcmx(ids);
        //删除主表
        return ybgcMapper.deleteYbgc(ids);
    }

    @Override
    public int updateYbgc(Ybgc ybgc) {
        //删除子表
        ybgcMapper.deleteYbgcmx(new String[] {ybgc.getId()});
        //增加子表
        for (Ybgcmx ybgcmx : ybgc.getYbgcmxList()) {
            ybgcmx.setId(UuidUtil.getUUID());
            ybgcmx.setYbid(ybgc.getId());
        }
        ybgcMapper.addYbgcmx(ybgc.getYbgcmxList());
        //更新主表
        return ybgcMapper.updateYbgc(ybgc);
    }
}
