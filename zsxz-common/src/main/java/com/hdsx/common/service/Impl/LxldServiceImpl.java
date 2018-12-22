package com.hdsx.common.service.Impl;

import com.hdsx.common.mapper.LxldMapper;
import com.hdsx.common.service.LxldService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class LxldServiceImpl implements LxldService {

    @Resource
    private LxldMapper lxldMapper;

    @Override
    public List<HashMap<String, Object>> getLd(String bmCode) {
        return lxldMapper.getLd(bmCode);
    }
}
