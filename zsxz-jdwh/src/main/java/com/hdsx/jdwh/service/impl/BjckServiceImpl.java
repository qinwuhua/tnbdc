package com.hdsx.jdwh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.jdwh.entity.Bjck;
import com.hdsx.jdwh.entity.Bjckmx;
import com.hdsx.jdwh.mapper.BjckMapper;
import com.hdsx.jdwh.service.BjckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BjckServiceImpl implements BjckService {

    @Resource
    private BjckMapper bjckMapper;

    @Override
    public List<Map<String, String>> getBjLySqdInfo(Map<String, String> param) {
        return bjckMapper.getBjLySqdInfo(param);
    }

    @Override
    public List<Bjckmx> getBjInfoByLySqd(Map<String, String> param) {
        return bjckMapper.getBjInfoByLySqd(param);
    }

    @Override
    public int addBjck(Bjck bjck) {
        int i=bjckMapper.addBjck(bjck);
        int k=bjckMapper.addBjckMx(bjck);
        return i;
    }

    @Override
    public int editBjck(Bjck bjck) {
        //修改主表
        int i=bjckMapper.editBjck(bjck);
        //删除子表
        int j=bjckMapper.delBjckMx(bjck);
        //添加子表
        int k=bjckMapper.addBjckMx(bjck);
        return i;
    }

    @Override
    public int delBjckBydjbhs(List<String> l) {
        int i=bjckMapper.delBjckBydjbhs(l);
        int j=bjckMapper.delBjckMxBydjbhs(l);
        return i;
    }

    @Override
    public Bjck getBjckInfoByDjbh(String djbh) {
        return bjckMapper.getBjckInfoByDjbh(djbh);
    }

    @Override
    public List<Bjck> getBjckList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Bjck> list = bjckMapper.getBjckList(param);
        return list;
    }

}
