package com.hdsx.common.service.Impl;

import com.hdsx.common.mapper.LhyhzljcpfbMapper;
import com.hdsx.common.service.LhyhzljcpfbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class LhyhzljcpfbServiceImpl implements LhyhzljcpfbService {
    @Resource
    private LhyhzljcpfbMapper lhyhzljcpfbMapper;

    @Override
    public List<HashMap<String, Object>> getAll() {
        return lhyhzljcpfbMapper.getAll();
    }
}
