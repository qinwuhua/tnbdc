package com.hdsx.zxyh.service.impl;

import com.hdsx.zxyh.entity.Jczbqkb;
import com.hdsx.zxyh.entity.Lyjcmx;
import com.hdsx.zxyh.mapper.JczbqkbMapper;
import com.hdsx.zxyh.service.JczbqkbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class JczbqkbServiceImpl implements JczbqkbService {

    @Resource
    private JczbqkbMapper jczbqkbMapper;

    @Override
    public List<Jczbqkb> getJczbqkb(String htbh, String gldw) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("htbh", htbh);
        param.put("gldw", gldw);
        return jczbqkbMapper.getJczbqkb(param);
    }

    @Override
    public int addJczbqkb(Jczbqkb jczbqkb) {
        if (jczbqkb.getId() == null || jczbqkb.getId() == ""){
            jczbqkb.setId(UUID.randomUUID().toString());
        }
        // 增加中间表
        if (jczbqkb.getList().size()>0){
            List<HashMap<String, Object>> list = new ArrayList<>();
            for (Lyjcmx lyjcmx : jczbqkb.getList()) {
                HashMap<String, Object> param = new HashMap<>();
                param.put("id", UUID.randomUUID().toString());
                param.put("jczbid", jczbqkb.getId());
                param.put("mxid", lyjcmx.getId());
                list.add(param);
            }
            jczbqkbMapper.addJczbqkbMid(list);
        }
        // 增加专项履约检查表
        return jczbqkbMapper.addJczbqkb(jczbqkb);
    }

    @Override
    public int deleteJczbqkb(String id) {
        // 先删除子表
        jczbqkbMapper.deleteJczbqkbMid(id);
        // 删除主表
        return jczbqkbMapper.deleteJczbqkb(id);
    }

    @Override
    public int updateJczbqkb(Jczbqkb jczbqkb) {
        // 删除子表
        jczbqkbMapper.deleteJczbqkbMid(jczbqkb.getId());
        // 增加子表
        if (jczbqkb.getList().size()>0){
            List<HashMap<String, Object>> list = new ArrayList<>();
            for (Lyjcmx lyjcmx:jczbqkb.getList()) {
                HashMap<String, Object> param = new HashMap<>();
                param.put("id", UUID.randomUUID().toString());
                param.put("jczbid", jczbqkb.getId());
                param.put("mxid", lyjcmx.getId());
                list.add(param);
            }
            jczbqkbMapper.addJczbqkbMid(list);
        }
        // 更新主表
        return jczbqkbMapper.updateJczbqkb(jczbqkb);
    }
}
