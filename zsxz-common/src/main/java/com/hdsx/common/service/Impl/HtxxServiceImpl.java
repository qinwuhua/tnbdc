package com.hdsx.common.service.Impl;

import com.hdsx.common.mapper.HtxxMapper;
import com.hdsx.common.service.HtxxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class HtxxServiceImpl implements HtxxService {

    @Resource
    HtxxMapper htxxMapper;


    @Override
    public List<HashMap<String, Object>> getHtxxAll() {
        return htxxMapper.getHtxxAll();
    }

    @Override
    public List<HashMap<String, Object>> getHtxxLyjcAll() {
        return htxxMapper.getHtxxLyjcAll();
    }

    @Override
    public List<HashMap<String, Object>> getHtgjxxAll() {
        return htxxMapper.getHtgjxxAll();
    }

    @Override
    public List<HashMap<String, Object>> getHtxxYhAll() {
        return htxxMapper.getHtxxYhAll();
    }
}
