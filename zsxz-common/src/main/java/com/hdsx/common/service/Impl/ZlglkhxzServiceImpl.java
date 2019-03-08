package com.hdsx.common.service.Impl;

import com.hdsx.common.mapper.ZlglkhxzMapper;
import com.hdsx.common.service.ZlglkhxzService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class ZlglkhxzServiceImpl implements ZlglkhxzService {
    @Resource
    private ZlglkhxzMapper zlglkhxzMapper;

    @Override
    public List<HashMap<String, Object>> getAll() {
        return zlglkhxzMapper.getAll();
    }

    @Override
    public List<HashMap<String, Object>> GetAllByGcxm(HashMap<String,String> paramMap) {
        return zlglkhxzMapper.GetAllByGcxm(paramMap);
    }

}
