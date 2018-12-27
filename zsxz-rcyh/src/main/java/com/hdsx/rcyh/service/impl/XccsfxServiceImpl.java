package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.mapper.XccsfxMapper;
import com.hdsx.rcyh.service.XccsfxService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@Service
@Transactional
public class XccsfxServiceImpl implements XccsfxService {

    @Resource
    private XccsfxMapper xccsfxMapper;


    @Override
    public List<HashMap<String, Object>> selectDay(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = xccsfxMapper.selectDay();
        return list;
    }

    @Override
    public List<HashMap<String, Object>> selectMonth(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = xccsfxMapper.selectMonth();
        return list;
    }

    @Override
    public List<HashMap<String, Object>> selectYear(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = xccsfxMapper.selectYear();
        return list;
    }
}
