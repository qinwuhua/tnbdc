package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.Lhyh;
import com.hdsx.rcyh.mapper.LhyhMapper;
import com.hdsx.rcyh.service.LhyhService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LhyhServiceImpl implements LhyhService {

    @Resource
    private LhyhMapper lhyhMapper;

    @Override
    public List<Lhyh> getLhyhrwList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Lhyh> list = lhyhMapper.getLhyhrwList(param);
        return list;

    }

    @Override
    public int insertLhyh(Lhyh lhyh) {
        return lhyhMapper.insertLhyh(lhyh);
    }
}
