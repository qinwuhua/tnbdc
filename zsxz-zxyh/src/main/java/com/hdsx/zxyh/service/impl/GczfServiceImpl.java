package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Gczfgcjld;
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
        GczfMapper.delGcjldByDjbh(gczfgcjld.getGcjl_djbh());
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
}
