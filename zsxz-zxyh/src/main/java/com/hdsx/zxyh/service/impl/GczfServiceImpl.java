package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
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


}
