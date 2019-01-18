package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Jczbqkb;
import com.hdsx.zxyh.entity.Jczbqkbmx;
import com.hdsx.zxyh.mapper.JczbqkbMapper;
import com.hdsx.zxyh.service.JczbqkbService;
import com.hdsx.zxyh.utils.UuidUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class JczbqkbServiceImpl implements JczbqkbService {

    @Resource
    private JczbqkbMapper jczbqkbMapper;

    @Override
    public List<Jczbqkb> getJczbqkb(String htbh, String gldw, int pageNum, int pageSize) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("htbh", htbh);
        param.put("gldw", gldw);
        PageHelper.startPage(pageNum, pageSize);
        return jczbqkbMapper.getJczbqkb(param);
    }

    @Override
    public int addJczbqkb(Jczbqkb jczbqkb) {
        if (jczbqkb.getId() == null || jczbqkb.getId() == ""){
            jczbqkb.setId(UuidUtil.getUUID());
        }
        // 增加进场准备情况表明细
        if (jczbqkb.getList().size()>0) {
            for (Jczbqkbmx jczbqkbmx:jczbqkb.getList()) {
                jczbqkbmx.setMxid(UuidUtil.getUUID());
                jczbqkbmx.setJcid(jczbqkb.getId());
            }
            jczbqkbMapper.addJczbqkbMx(jczbqkb.getList());
        }
        // 增加进场准备情况表
        return jczbqkbMapper.addJczbqkb(jczbqkb);
    }

    @Override
    public int deleteJczbqkb(String[] ids) {
        // 先删除子表
        jczbqkbMapper.deleteJczbqkbMx(ids);
        // 删除主表
        return jczbqkbMapper.deleteJczbqkb(ids);
    }

    @Override
    public int updateJczbqkb(Jczbqkb jczbqkb) {
        // 删除子表
        jczbqkbMapper.deleteJczbqkbMx(new String[] {jczbqkb.getId()});
        // 增加子表
        if (jczbqkb.getList().size()>0) {
            for (Jczbqkbmx jczbqkbmx:jczbqkb.getList()) {
                jczbqkbmx.setMxid(UuidUtil.getUUID());
                jczbqkbmx.setJcid(jczbqkb.getId());
            }
            jczbqkbMapper.addJczbqkbMx(jczbqkb.getList());
        }
        // 更新主表
        return jczbqkbMapper.updateJczbqkb(jczbqkb);
    }
}
