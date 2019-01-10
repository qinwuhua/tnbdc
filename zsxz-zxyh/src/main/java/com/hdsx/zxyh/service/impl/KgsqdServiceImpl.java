package com.hdsx.zxyh.service.impl;

import com.hdsx.zxyh.entity.Kgsqd;
import com.hdsx.zxyh.mapper.KgsqdMapper;
import com.hdsx.zxyh.service.KgsqdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KgsqdServiceImpl implements KgsqdService {

    @Resource
    private KgsqdMapper kgsqdMapper;

    @Override
    public List<Kgsqd> getAll() {
        return kgsqdMapper.getAll();
    }
}
