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
        lyjcMapper.deleteLyjcmxbById(ids);
        return lyjcMapper.deleteLyjcById(ids);
    }

    @Override
    public int updateLyjc(Lyjc lyjc) {
        if (lyjc.getLyjcmxb()!=null && lyjc.getLyjcmxb().size() > 0){
            for (Lyjcmxb lyjcmxb : lyjc.getLyjcmxb()){
                lyjcmxb.setMid(lyjc.getId());
                lyjcMapper.updateLyjcmxb(lyjcmxb);
            }
        }
        return lyjcMapper.updateLyjc(lyjc);
    }

    @Override
    public List<Lyjcmxb> getLyjcbmxById(String id) {
        return lyjcMapper.getLyjcbmxById(id);
    }

    @Override
    public List<Jczb> getJczbAll(HashMap<String, String> paramMap,int pageNum, int pageSize) {
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
        lyjcMapper.deleteJczbmxbById(ids);
        return lyjcMapper.deleteJczbById(ids);
    }

    @Override
    public int updateJczb(Jczb jczb) {
        if (jczb.getJczbmxb()!=null && jczb.getJczbmxb().size() > 0){
            for (Jczbmxb jczbmxb : jczb.getJczbmxb()){
                jczbmxb.setMid(jczb.getId());
                lyjcMapper.updateJczbmxb(jczbmxb);
            }
        }
        return lyjcMapper.updateJczb(jczb);
    }

    @Override
    public List<Jczbmxb> getJczbmxById(String id) {
        return lyjcMapper.getJczbmxById(id);
    }

    @Override
    public int deleteLyjcmxbByids(String[] ids) {
        return lyjcMapper.deleteLyjcmxbByids(ids);
    }

    @Override
    public int deleteJczbmxByIds(String[] ids) {
        return lyjcMapper.deleteJczbmxByIds(ids);
    }

}
