package com.hdsx.zxyh.service.impl;

import com.hdsx.zxyh.entity.Lyjc;
import com.hdsx.zxyh.entity.Lyjcmx;
import com.hdsx.zxyh.mapper.LyjcMapper;
import com.hdsx.zxyh.service.LyjcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class LyjcServiceImpl implements LyjcService {

    @Resource
    private LyjcMapper lyjcMapper;

    @Override
    public List<Lyjc> getLyjc(String htbh, String gldw) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("htbh", htbh);
        param.put("gldw", gldw);
        return lyjcMapper.getLyjc(param);
    }

    @Override
    public int addLyjc(Lyjc lyjc) {
        if (lyjc.getId() == null || lyjc.getId() == ""){
            lyjc.setId(UUID.randomUUID().toString());
        }
        // 增加中间表
        if (lyjc.getList().size()>0){
            List<HashMap<String, Object>> list = new ArrayList<>();
            for (Lyjcmx lyjcmx : lyjc.getList()) {
                HashMap<String, Object> param = new HashMap<>();
                param.put("id", UUID.randomUUID().toString());
                param.put("lyjcid", lyjc.getId());
                param.put("mxid", lyjcmx.getId());
                list.add(param);
            }
            lyjcMapper.addLyjcMid(list);
        }
        // 增加专项履约检查表
        return lyjcMapper.addLyjc(lyjc);
    }

    @Override
    public int deleteLyjc(String id) {
        // 先删除子表
        lyjcMapper.deleteLyjcMid(id);

        return lyjcMapper.deleteLyjc(id);
    }

    @Override
    public int updateLyjc(Lyjc lyjc) {
        // 删除子表
        lyjcMapper.deleteLyjcMid(lyjc.getId());
        // 增加子表
        if (lyjc.getList().size()>0){
            List<HashMap<String, Object>> list = new ArrayList<>();
            for (Lyjcmx lyjcmx:lyjc.getList()) {
                HashMap<String, Object> param = new HashMap<>();
                param.put("id", UUID.randomUUID().toString());
                param.put("lyjcid", lyjc.getId());
                param.put("mxid", lyjcmx.getId());
                list.add(param);
            }
            lyjcMapper.addLyjcMid(list);
        }
        // 更新主表
        return lyjcMapper.updateLyjc(lyjc);
    }
}
