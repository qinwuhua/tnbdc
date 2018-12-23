package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.Jczb;
import com.hdsx.rcyh.entity.Jczbmxb;
import com.hdsx.rcyh.entity.Lyjc;
import com.hdsx.rcyh.entity.Lyjcmxb;
import com.hdsx.rcyh.mapper.LyjcMapper;
import com.hdsx.rcyh.service.LyjcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class LyjcServiceImpl implements LyjcService {

    @Resource
    LyjcMapper lyjcMapper;

    @Override
    public List<HashMap<String, Object>> getLyjcAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = lyjcMapper.getLyjcAll();
        return list;
    }

    @Override
    public boolean addLyjc(Lyjc lyjc) {
        if (lyjc.getLyjcmxb() != null && lyjc.getLyjcmxb().size() > 0){
            for (Lyjcmxb lyjcmxb : lyjc.getLyjcmxb()){
                String id = "LYJC_" + System.currentTimeMillis();
                lyjcmxb.setId(id);
                lyjcmxb.setMid(lyjc.getId());
                lyjcMapper.addLyjcmxb(lyjcmxb);
            }
        }
        return lyjcMapper.addLyjc(lyjc);
    }

    @Override
    public boolean deleteLyjc(String id) {
        if (lyjcMapper.deleteLyjcmxbById(id)){
            if (lyjcMapper.deleteLyjcById(id)){
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateLyjc(Lyjc lyjc) {
        if (lyjc.getLyjcmxb()!=null && lyjc.getLyjcmxb().size() > 0){
            for (Lyjcmxb lyjcmxb : lyjc.getLyjcmxb()){
                String id = "LYJC_" + System.currentTimeMillis();
                lyjcmxb.setId(id);
                lyjcmxb.setMid(lyjc.getId());
                lyjcMapper.updateLyjcmxb(lyjcmxb);
            }
        }
        return lyjcMapper.updateLyjc(lyjc);
    }

    @Override
    public List<HashMap<String, Object>> getLyjcbmxById(String id) {
        return lyjcMapper.getLyjcbmxById(id);
    }

    @Override
    public List<HashMap<String, Object>> getJczbAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = lyjcMapper.getJczbAll();
        return list;
    }

    @Override
    public boolean addJczb(Jczb jczb) {
        if (jczb.getJczbmxb() != null && jczb.getJczbmxb().size() > 0){
            for (Jczbmxb jczbmxb : jczb.getJczbmxb()){
                String id = "JCZB_" + System.currentTimeMillis();
                jczbmxb.setId(id);
                jczbmxb.setMid(jczb.getId());
                lyjcMapper.addJczbmxb(jczbmxb);
            }
        }
        return lyjcMapper.addJczb(jczb);
    }


    @Override
    public boolean deleteJczb(String id) {
        if (lyjcMapper.deleteJczbmxbById(id)){
            if (lyjcMapper.deleteJczbById(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJczb(Jczb jczb) {
        if (jczb.getJczbmxb()!=null && jczb.getJczbmxb().size() > 0){
            for (Jczbmxb jczbmxb : jczb.getJczbmxb()){
                String id = "JCZB_" + System.currentTimeMillis();
                jczbmxb.setId(id);
                jczbmxb.setMid(jczb.getId());
                lyjcMapper.updateJczbmxb(jczbmxb);
            }
        }
        return lyjcMapper.updateJczb(jczb);
    }

    @Override
    public List<HashMap<String, Object>> getJczbmxById(String id) {
        return lyjcMapper.getJczbmxById(id);
    }

}
