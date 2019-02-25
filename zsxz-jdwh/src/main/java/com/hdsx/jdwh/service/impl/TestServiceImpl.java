package com.hdsx.jdwh.service.impl;

import com.hdsx.jdwh.mapper.TestMapper;
import com.hdsx.jdwh.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public List<HashMap<String, Object>> test() {
        return testMapper.test();
    }
}
