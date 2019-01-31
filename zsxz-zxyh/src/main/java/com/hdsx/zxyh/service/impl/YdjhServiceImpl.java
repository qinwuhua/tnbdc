package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Ydjh;
import com.hdsx.zxyh.entity.Ydjhmx;
import com.hdsx.zxyh.mapper.YdjhMapper;
import com.hdsx.zxyh.service.YdjhService;
import com.hdsx.zxyh.utils.UuidUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class YdjhServiceImpl implements YdjhService {

    @Resource
    private YdjhMapper ydjhMapper;

    @Override
    public List<Ydjh> getYdjh(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ydjhMapper.getYdjh();
    }

    @Override
    public int addYdjh(Ydjh ydjh) {
        if (StringUtils.isEmpty(ydjh.getId())){
            ydjh.setId(UuidUtil.getUUID());
        }
        // 增加子表
        if (ydjh.getList().size()>0) {
            for (Ydjhmx ydjhmx: ydjh.getList()) {
                ydjhmx.setMxid(UuidUtil.getUUID());
                ydjhmx.setYdid(ydjh.getId());
            }
            ydjhMapper.addYdjhmx(ydjh.getList());
        }
        // 增加主表
        return ydjhMapper.addYdjh(ydjh);
    }

    @Override
    public int deleteYdjh(String[] ids) {
        // 删除子表
        ydjhMapper.deleteYdjhmx(ids);
        // 删除主表
        return ydjhMapper.deleteYdjh(ids);
    }

    @Override
    public int updateYdjh(Ydjh ydjh) {
        //删除子表
        ydjhMapper.deleteYdjhmx(new String[]{ydjh.getId()});
        //增加子表
        if (ydjh.getList().size()>0) {
            for (Ydjhmx ydjhmx : ydjh.getList()) {
                ydjhmx.setMxid(UuidUtil.getUUID());
                ydjhmx.setYdid(ydjh.getId());
            }
        }
        ydjhMapper.addYdjhmx(ydjh.getList());
        //更新主表
        return ydjhMapper.updateYdjh(ydjh);
    }
}
