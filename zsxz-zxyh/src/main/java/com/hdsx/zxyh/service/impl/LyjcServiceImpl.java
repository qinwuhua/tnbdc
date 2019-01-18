package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Lyjc;
import com.hdsx.zxyh.entity.Lyjcmx;
import com.hdsx.zxyh.mapper.LyjcMapper;
import com.hdsx.zxyh.service.LyjcService;
import com.hdsx.zxyh.utils.UuidUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class LyjcServiceImpl implements LyjcService {

    @Resource
    private LyjcMapper lyjcMapper;

    @Override
    public List<Lyjc> getLyjc(String htbh, String gldw, int pageNum, int pageSize) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("htbh", htbh);
        param.put("gldw", gldw);
        PageHelper.startPage(pageNum, pageSize);
        return lyjcMapper.getLyjc(param);
    }

    @Override
    public int addLyjc(Lyjc lyjc) {
        if (lyjc.getId() == null || lyjc.getId() == ""){
            lyjc.setId(UuidUtil.getUUID());
        }
        // 增加履约检查明细表
        if (lyjc.getList().size()>0){
            for (Lyjcmx lyjcmx:lyjc.getList()) {
                lyjcmx.setMxid(UuidUtil.getUUID());
                lyjcmx.setLyjcid(lyjc.getId());
            }
            lyjcMapper.addLyjcMx(lyjc.getList());
        }
        // 增加专项履约检查表
        return lyjcMapper.addLyjc(lyjc);
    }

    @Override
    public int deleteLyjc(String[] ids) {
        // 先删除子表
        lyjcMapper.deleteLyjcMx(ids);
        // 先删除主表
        return lyjcMapper.deleteLyjc(ids);
    }

    @Override
    public int updateLyjc(Lyjc lyjc) {
        // 删除明细表
        lyjcMapper.deleteLyjcMx(new String[]{lyjc.getId()});
        // 增加明细表
        if (lyjc.getList().size()>0){
            for (Lyjcmx lyjcmx:lyjc.getList()) {
                lyjcmx.setMxid(UuidUtil.getUUID());
                lyjcmx.setLyjcid(lyjc.getId());
            }
            lyjcMapper.addLyjcMx(lyjc.getList());
        }
        // 更新主表
        return lyjcMapper.updateLyjc(lyjc);
    }
}
