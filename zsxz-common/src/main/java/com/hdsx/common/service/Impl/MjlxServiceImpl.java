package com.hdsx.common.service.Impl;

import com.hdsx.common.mapper.MjlxMapper;
import com.hdsx.common.service.MjlxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class MjlxServiceImpl implements MjlxService {

    @Resource
    private MjlxMapper mjlxMapper;

    @Override
    public List<HashMap<String, Object>> getMjxx(String mjlxbm) {
        return mjlxMapper.getMjxx(mjlxbm);
    }
}
