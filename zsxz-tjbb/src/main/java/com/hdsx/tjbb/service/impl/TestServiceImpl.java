package com.hdsx.tjbb.service.impl;

import com.hdsx.tjbb.mapper.TestMapper;
import com.hdsx.tjbb.service.TestService;
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
