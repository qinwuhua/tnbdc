package com.hdsx.zxyh.service.impl;


import com.hdsx.zxyh.mapper.TestMapper;
import com.hdsx.zxyh.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    TestMapper testMapper;

    @Override
    public List<HashMap<String,Object>> test(){
        return testMapper.test();
    }

    @Override
    public List<HashMap<String,Object>> exportExcel() {
        return testMapper.exportexcel();
    }
}
