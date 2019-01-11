package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Gcyscbr;
import com.hdsx.zxyh.entity.Gcyssqd;
import com.hdsx.zxyh.mapper.GcysCbrylwtMapper;
import com.hdsx.zxyh.mapper.GcysSqdMapper;
import com.hdsx.zxyh.service.GcysCbrylwtService;
import com.hdsx.zxyh.service.GcysSqdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class GcysCbrylwtServiceImpl implements GcysCbrylwtService {

    @Resource
    private GcysCbrylwtMapper gcysCbrylwtMapper;

    @Override
    public List<Gcyscbr> getCbrylwtList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Gcyscbr> list = gcysCbrylwtMapper.getCbrylwtList(param);
        return list;
    }

    @Override
    public Gcyscbr getCbrylwtInfoByDjbh(Map<String, String> param) {
        return gcysCbrylwtMapper.getCbrylwtInfoByDjbh(param);
    }

    @Override
    public int addCbrylwtForGcys(Gcyscbr ccyscbr) {
        gcysCbrylwtMapper.addCbrylwtMxForGcys(ccyscbr);
        return gcysCbrylwtMapper.addCbrylwtForGcys(ccyscbr);
    }

    @Override
    public int editCbrylwtForGcys(Gcyscbr ccyscbr) {
        //根据单据编号删除子表
        gcysCbrylwtMapper.delCbrylwtMxByDjbh(ccyscbr.getDjbh());
        //插入子表
        gcysCbrylwtMapper.addCbrylwtMxForGcys(ccyscbr);
        //修改主表
        return gcysCbrylwtMapper.editCbrylwtForGcys(ccyscbr);
    }

    @Override
    public int delCbrylwtForGcys(List<String> l) {
        gcysCbrylwtMapper.delCbrylwtMxForGcys(l);
        return gcysCbrylwtMapper.delCbrylwtForGcys(l);
    }

    @Override
    public int spCbrylwtForGcys(Map<String, Object> param) {
        return gcysCbrylwtMapper.spCbrylwtForGcys(param);
    }


}
