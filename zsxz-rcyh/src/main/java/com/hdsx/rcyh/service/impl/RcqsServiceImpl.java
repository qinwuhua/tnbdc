package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.Rcqs;
import com.hdsx.rcyh.mapper.RcqsMapper;
import com.hdsx.rcyh.service.RcqsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RcqsServiceImpl implements RcqsService {

    @Resource
    private RcqsMapper rcqsMapper;

    @Override
    public List<Rcqs> getRcqsrwList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Rcqs> list = rcqsMapper.getRcqsrwList(param);
        return list;
    }
}
