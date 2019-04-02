package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;

import com.hdsx.rcyh.entity.Sjqs;
import com.hdsx.rcyh.entity.SjqsPZ;
import com.hdsx.rcyh.mapper.SjqsMapper;
import com.hdsx.rcyh.service.SjqsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SjqsServiceImpl implements SjqsService {

    @Resource
    private SjqsMapper sjqsMapper;


    @Override
    public List<Sjqs> getSjqsrwList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Sjqs> list = sjqsMapper.getSjqsrwList(param);
        return list;
    }

    @Override
    public int insertSjqs(Sjqs sjqs) {
        return sjqsMapper.insertSjqs(sjqs);
    }

    @Override
    public int insertSjqsPZ(SjqsPZ sjqsPZ) {
        return sjqsMapper.insertSjqsPZ(sjqsPZ);
    }

    @Override
    public List<Map> getSjqsPz(String qsry) {
        return sjqsMapper.getSjqsPz(qsry);
    }

}
