package com.hdsx.common.service.Impl;

import com.hdsx.common.entity.Htxx;
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
    public List<Htxx> getHtxxRelatedAll(HashMap<String,String> paramMap) {
        return htxxMapper.getHtxxRelateAll(paramMap);
    }
}
