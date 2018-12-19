package com.hdsx.lkpd.service.impl;

import com.hdsx.lkpd.mapper.TestMapper;
import com.hdsx.lkpd.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class TestServiceImple implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public List<HashMap<String, Object>> test() {
        return testMapper.test();
    }
}
