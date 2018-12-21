package com.hdsx.rcyh.service.impl;

import com.hdsx.rcyh.entity.Xcsb;
import com.hdsx.rcyh.mapper.XccspzMapper;
import com.hdsx.rcyh.mapper.XcsbMapper;
import com.hdsx.rcyh.service.XcsbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class XcsbServiceImpl implements XcsbService {

    @Resource
    private XcsbMapper xcsbMapper;

    @Override
    public int delete(String rwmxId) {
        return xcsbMapper.delete(rwmxId);
    }

    @Override
    public int deletes(String[] rwmxId) {
        int deleteNum = 0;
        for (int i = 0; i < rwmxId.length; i++) {
            deleteNum += xcsbMapper.delete(rwmxId[i]);
        }
        return deleteNum;
    }

    @Override
    public int insert(Xcsb xcsb) {
        return xcsbMapper.insert(xcsb);
    }

    @Override
    public List<Xcsb> QueryOne(String rwmxId) {
        return xcsbMapper.QueryOne(rwmxId);
    }
}
