package com.hdsx.rcyh.service.impl;

import com.hdsx.rcyh.mapper.YdssMapper;
import com.hdsx.rcyh.service.YdssService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class YdssServiceImpl implements YdssService {

    @Resource
    private YdssMapper ydssMapper;

    @Override
    public List<HashMap<String, Object>> getYdsgjhAll(int pageNum, int pageSize) {
        return null;
    }
}
