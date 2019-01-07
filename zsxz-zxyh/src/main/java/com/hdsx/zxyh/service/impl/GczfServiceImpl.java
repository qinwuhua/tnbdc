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
    private GczfMapper GczfMapper;


    @Override
    public List<Gczfgcjld> getGcjldList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Gczfgcjld> list = GczfMapper.getGcjldList(param);
        return list;
    }

    @Override
    public List<Gczfgcjld> getHtXxInfoByBm(Map<String, String> param) {
        return GczfMapper.getHtXxInfoByBm(param);
    }

    @Override
    public int addGcjldForGczf(Gczfgcjld gczfgcjld) {
        GczfMapper.addGcjldMxForGczf(gczfgcjld);
        return GczfMapper.addGcjldForGczf(gczfgcjld);
    }

    @Override
    public int editGcjldForGczf(Gczfgcjld gczfgcjld) {
        //根据单据编号删除子表
        GczfMapper.delGcjldMxByDjbh(gczfgcjld.getGcjl_djbh());
        //插入子表
        GczfMapper.addGcjldMxForGczf(gczfgcjld);
        //修改主表
        return GczfMapper.editGcjldForGczf(gczfgcjld);
    }

    @Override
    public int delGcjldForGczf(List<String> l) {
        GczfMapper.delGcjldMxForGczf(l);
        return GczfMapper.delGcjldForGczf(l);
    }

    @Override
    public int spGcjldForGczf(Map<String, Object> param) {
        return GczfMapper.spGcjldForGczf(param);
    }

    @Override
    public List<Gczfzqcwzf> getHtCwInfoByBm(Map<String, String> param) {
        return GczfMapper.getHtCwInfoByBm(param);
    }

    @Override
    public Gczfgcjld getGcjldInfoByDjbh(Map<String, String> param) {
        return GczfMapper.getGcjldInfoByDjbh(param);
    }

    @Override
    public List<Gczfzqcwzf> getZqcwzfList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Gczfzqcwzf> list = GczfMapper.getZqcwzfList(param);
        return list;
    }

    @Override
    public Gczfzqcwzf getZqcwzfInfoByZfqh(Map<String, String> param) {
        return GczfMapper.getZqcwzfInfoByZfqh(param);
    }

    @Override
    public int addZqcwzfForGczf(Gczfzqcwzf gczfzqcwzf) {
        GczfMapper.addZqcwzfMxForGczf(gczfzqcwzf);
        return GczfMapper.addZqcwzfForGczf(gczfzqcwzf);
    }

    @Override
    public int editZqcwzfForGczf(Gczfzqcwzf gczfzqcwzf) {
        //根据单据编号删除子表
        GczfMapper.delZqcwzfMxByDjbh(gczfzqcwzf.getZqcwzf_zfqh());
        //插入子表
        GczfMapper.addZqcwzfMxForGczf(gczfzqcwzf);
        //修改主表
        return GczfMapper.editZqcwzfForGczf(gczfzqcwzf);
    }

    @Override
    public int delZqcwzfForGczf(List<String> l) {
        GczfMapper.delZqcwzfMxForGczf(l);
        return GczfMapper.delZqcwzfForGczf(l);
    }

    @Override
    public int spZqcwzfForGczf(Map<String, Object> param) {
        return GczfMapper.spZqcwzfForGczf(param);
    }
}
