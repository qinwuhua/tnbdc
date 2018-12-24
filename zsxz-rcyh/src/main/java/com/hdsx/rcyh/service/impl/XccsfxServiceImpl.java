package com.hdsx.rcyh.service.impl;

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
    public List<HashMap<String, Object>> selectDay() {
        System.out.println("sssssss"+xccsfxMapper.selectDay());
        return xccsfxMapper.selectDay();
    }

    @Override
    public List<HashMap<String, Object>> selectMonth() {
        return xccsfxMapper.selectMonth();
    }

    @Override
    public List<HashMap<String, Object>> selectYear() {
        return xccsfxMapper.selectYear();
    }
}
