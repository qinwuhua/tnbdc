package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;

import com.hdsx.zxyh.entity.Jczb;
import com.hdsx.zxyh.entity.Jczbmxb;
import com.hdsx.zxyh.entity.Lyjc;
import com.hdsx.zxyh.entity.Lyjcmxb;
import com.hdsx.zxyh.mapper.LyjcMapper;
import com.hdsx.zxyh.service.LyjcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class LyjcServiceImpl implements LyjcService {

    @Resource
    private LyjcMapper lyjcMapper;

    @Override
    public List<Lyjc> getLyjcAll(HashMap<String,String> paramMap, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Lyjc> list = lyjcMapper.getLyjcAll(paramMap);
        return list;
    }

    @Override
    public int addLyjc(Lyjc lyjc) {
        if (lyjc.getLyjcmxb() != null && lyjc.getLyjcmxb().size() > 0){
            lyjcMapper.addLyjcmxb(lyjc.getLyjcmxb());
        }
        return lyjcMapper.addLyjc(lyjc);
    }

    @Override
    public int deleteLyjc(String[] ids) {
        lyjcMapper.deleteLyjcmxbByMid(ids);
        return lyjcMapper.deleteLyjcById(ids);
    }

    @Override
    public int updateLyjc(Lyjc lyjc) {
        lyjcMapper.deleteLyjcmxbByMid(new String[]{lyjc.getId()});
        if (lyjc.getLyjcmxb() != null && lyjc.getLyjcmxb().size() > 0){
            lyjcMapper.addLyjcmxb(lyjc.getLyjcmxb());
        }
        return lyjcMapper.updateLyjc(lyjc);
    }

    @Override
    public List<Lyjcmxb> getLyjcbmxByMid(String id) {
        return lyjcMapper.getLyjcbmxByMid(id);
    }

    @Override
    public List<Jczb> getJczbAll(HashMap<String, String> paramMap, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Jczb> list = lyjcMapper.getJczbAll(paramMap);
        return list;
    }

    @Override
    public int addJczb(Jczb jczb) {
        if (jczb.getJczbmxb() != null && jczb.getJczbmxb().size() > 0){
            lyjcMapper.addJczbmxb(jczb.getJczbmxb());
        }
        return lyjcMapper.addJczb(jczb);
    }


    @Override
    public int deleteJczb(String[] ids) {
        lyjcMapper.deleteJczbmxbByMid(ids);
        return lyjcMapper.deleteJczbByIds(ids);
    }

    @Override
    public int updateJczb(Jczb jczb) {
        lyjcMapper.deleteJczbmxbByMid(new String[]{jczb.getId()});
        if (jczb.getJczbmxb() != null && jczb.getJczbmxb().size() > 0){
            lyjcMapper.addJczbmxb(jczb.getJczbmxb());
        }
        return lyjcMapper.updateJczb(jczb);
    }

    @Override
    public List<Jczbmxb> getJczbmxById(String id) {
        return lyjcMapper.getJczbmxById(id);
    }

    @Override
    public int deleteLyjcmxbByIds(String[] ids) {
        return lyjcMapper.deleteLyjcmxbByIds(ids);
    }

    @Override
    public int deleteJczbmxByIds(String[] ids) {
        return lyjcMapper.deleteJczbmxByIds(ids);
    }
}
