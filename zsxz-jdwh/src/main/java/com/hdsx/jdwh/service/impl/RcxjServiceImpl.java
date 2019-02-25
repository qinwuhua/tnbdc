package com.hdsx.jdwh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.jdwh.entity.Rcxj;
import com.hdsx.jdwh.mapper.RcxjMapper;
import com.hdsx.jdwh.service.RcxjService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RcxjServiceImpl implements RcxjService {

    @Resource
    private RcxjMapper rcxjMapper;

    @Override
    public List<Rcxj> getXjType(Map<String, String> param) {
        return rcxjMapper.getXjType(param);
    }

    @Override
    public int addRcxj(Rcxj rcxj) {
        int i=rcxjMapper.addRcxj(rcxj);
        int k=rcxjMapper.addRcxjMx(rcxj);
        return i;

    }

    @Override
    public int editRcxj(Rcxj rcxj) {
        //修改主表
        int i=rcxjMapper.editRcxj(rcxj);
        //删除子表
        int j=rcxjMapper.delRcxjMx(rcxj);
        //添加子表
        int k=rcxjMapper.addRcxjMx(rcxj);
        return i;
    }

    @Override
    public int delRcxjByIds(List<String> l) {
        int i=rcxjMapper.delRcxjByIds(l);
        int j=rcxjMapper.delRcxjMxByIds(l);
        return i;
    }

    @Override
    public Rcxj getRcxjInfoById(String id) {
        return rcxjMapper.getRcxjInfoById(id);
    }

    @Override
    public List<Rcxj> getRcxjList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Rcxj> list = rcxjMapper.getRcxjList(param);
        return  list;
    }


}
