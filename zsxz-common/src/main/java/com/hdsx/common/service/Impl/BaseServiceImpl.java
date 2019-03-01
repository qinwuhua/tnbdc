package com.hdsx.common.service.Impl;

import com.hdsx.common.mapper.BaseMapper;
import com.hdsx.common.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author LiRui
 * @created 2019/3/1 0001
 */

@Service
@Transactional
public class BaseServiceImpl implements BaseService {

    @Resource
    private BaseMapper mapper;

    @Override
    public List<Map> createZzxxList() {
        return mapper.createZzxxList();
    }

    @Override
    public List<Map> createRyxxList(String gsid) {
        return mapper.createRyxxList(gsid);
    }
}
