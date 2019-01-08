package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Gczfgcjld;
import com.hdsx.zxyh.entity.Gczfzqcwzf;
import com.hdsx.zxyh.mapper.GczfMapper;
import com.hdsx.zxyh.service.GczfService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class GczfServiceImpl implements GczfService {

    @Resource
    private GczfMapper gczfMapper;


    @Override
    public List<Gczfgcjld> getGcjldList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Gczfgcjld> list = gczfMapper.getGcjldList(param);
        return list;
    }

    @Override
    public List<Gczfgcjld> getHtXxInfoByBm(Map<String, String> param) {
        return gczfMapper.getHtXxInfoByBm(param);
    }

    @Override
    public int addGcjldForGczf(Gczfgcjld gczfgcjld) {
        gczfMapper.addGcjldMxForGczf(gczfgcjld);
        return gczfMapper.addGcjldForGczf(gczfgcjld);
    }

    @Override
    public int editGcjldForGczf(Gczfgcjld gczfgcjld) {
        //根据单据编号删除子表
        gczfMapper.delGcjldMxByDjbh(gczfgcjld.getGcjl_djbh());
        //插入子表
        gczfMapper.addGcjldMxForGczf(gczfgcjld);
        //修改主表
        return gczfMapper.editGcjldForGczf(gczfgcjld);
    }

    @Override
    public int delGcjldForGczf(List<String> l) {
        gczfMapper.delGcjldMxForGczf(l);
        return gczfMapper.delGcjldForGczf(l);
    }

    @Override
    public int spGcjldForGczf(Map<String, Object> param) {
        return gczfMapper.spGcjldForGczf(param);
    }

    @Override
    public List<Gczfzqcwzf> getHtCwInfoByBm(Map<String, String> param) {
        return gczfMapper.getHtCwInfoByBm(param);
    }

    @Override
    public Gczfgcjld getGcjldInfoByDjbh(Map<String, String> param) {
        return gczfMapper.getGcjldInfoByDjbh(param);
    }

    @Override
    public List<Gczfzqcwzf> getZqcwzfList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Gczfzqcwzf> list = gczfMapper.getZqcwzfList(param);
        return list;
    }

    @Override
    public Gczfzqcwzf getZqcwzfInfoByZfqh(Map<String, String> param) {
        return gczfMapper.getZqcwzfInfoByZfqh(param);
    }

    @Override
    public int addZqcwzfForGczf(Gczfzqcwzf gczfzqcwzf) {
        gczfMapper.addZqcwzfMxForGczf(gczfzqcwzf);
        return gczfMapper.addZqcwzfForGczf(gczfzqcwzf);
    }

    @Override
    public int editZqcwzfForGczf(Gczfzqcwzf gczfzqcwzf) {
        //根据单据编号删除子表
        gczfMapper.delZqcwzfMxByDjbh(gczfzqcwzf.getZqcwzf_zfqh());
        //插入子表
        gczfMapper.addZqcwzfMxForGczf(gczfzqcwzf);
        //修改主表
        return gczfMapper.editZqcwzfForGczf(gczfzqcwzf);
    }

    @Override
    public int delZqcwzfForGczf(List<String> l) {
        gczfMapper.delZqcwzfMxForGczf(l);
        return gczfMapper.delZqcwzfForGczf(l);
    }

    @Override
    public int spZqcwzfForGczf(Map<String, Object> param) {
        return gczfMapper.spZqcwzfForGczf(param);
    }
}
