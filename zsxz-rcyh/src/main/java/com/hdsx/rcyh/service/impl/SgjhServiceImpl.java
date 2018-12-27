package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.Sgjh;
import com.hdsx.rcyh.entity.Sgjhsbmx;
import com.hdsx.rcyh.entity.Sgjhwc;
import com.hdsx.rcyh.entity.Sgjhwcmx;
import com.hdsx.rcyh.mapper.SgjhMapper;
import com.hdsx.rcyh.service.SgjhService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class SgjhServiceImpl implements SgjhService {

    @Resource
    private SgjhMapper sgjhMapper;

    @Override
    public List<Sgjh> getSgjhAll(HashMap<String,String>paramMap, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Sgjh> list = sgjhMapper.getSgjhAll(paramMap);
        return list;
    }

    @Override
    public int addSgjh(Sgjh sgjh) {
        if (sgjh.getSgjhsbmx() != null && sgjh.getSgjhsbmx().size() > 0){
            sgjhMapper.addSgjhmx(sgjh.getSgjhsbmx());
        }
        return sgjhMapper.addSgjh(sgjh);
    }

    @Override
    public int upateSgjh(Sgjh sgjh) {
        if (sgjh.getSgjhsbmx() != null && sgjh.getSgjhsbmx().size() > 0){
            for (Sgjhsbmx sgjhsbmx : sgjh.getSgjhsbmx()){
                sgjhsbmx.setMid(sgjh.getId());
                sgjhMapper.updateSgjhmx(sgjhsbmx);
            }
        }
        return sgjhMapper.updateSgjh(sgjh);
    }

    @Override
    public int deleteSgjh(String[] ids){
        sgjhMapper.deleteSgjhmx(ids);
        return sgjhMapper.deleteSgjh(ids);
    }

    @Override
    public List<Sgjhsbmx> getSgjhmxById(String id){
        return sgjhMapper.getSgjhmxById(id);
    }

    @Override
    public List<HashMap<String, Object>> getWcSgjhAll(HashMap<String, String> paramMap, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<HashMap<String, Object>> list = sgjhMapper.getWcSgjhAll(paramMap);
        return list;
    }

    @Override
    public int addWcSgjh(Sgjhwc sgjhwc) {
        if (sgjhwc.getSgjhwcmx() != null && sgjhwc.getSgjhwcmx().size() > 0){
            sgjhMapper.addWcsgjhmx(sgjhwc.getSgjhwcmx());
        }
        return sgjhMapper.addWcSgjh(sgjhwc);
    }

    @Override
    public int upateWcsgjh(Sgjhwc sgjhwc) {
        if (sgjhwc.getSgjhwcmx() != null && sgjhwc.getSgjhwcmx().size() > 0){
            for (Sgjhwcmx sgjhwcmx : sgjhwc.getSgjhwcmx()){
                sgjhwcmx.setMid(sgjhwc.getId());
                sgjhMapper.updateWcSgjhmx(sgjhwcmx);
            }
        }
        return sgjhMapper.upateWcsgjh(sgjhwc);
    }

    @Override
    public int deleteWcSgjh(String[] ids) {
        sgjhMapper.deleteWcSgjhmx(ids);
        return sgjhMapper.deleteWcSgjh(ids);
    }

    @Override
    public List<Sgjhwcmx> getWcSgjhmxById(String id) {
        return sgjhMapper.getWcSgjhmxById(id);
    }

    @Override
    public int deleteWcSgjhmxByIds(String[] ids) {
        return sgjhMapper.deleteWcSgjhmxByIds(ids);
    }

    @Override
    public int deleteSgjhmxByIds(String[] ids) {
        return sgjhMapper.deleteSgjhmxByIds(ids);
    }

}
