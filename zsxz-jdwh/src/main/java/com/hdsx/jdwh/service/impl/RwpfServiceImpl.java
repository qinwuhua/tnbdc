package com.hdsx.jdwh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.jdwh.entity.Gzbx;
import com.hdsx.jdwh.mapper.GzbxMapper;
import com.hdsx.jdwh.mapper.RwpfMapper;
import com.hdsx.jdwh.service.GzbxService;
import com.hdsx.jdwh.service.RwpfService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RwpfServiceImpl implements RwpfService {

    @Resource
    private RwpfMapper rwpfMapper;


    @Override
    public List<Gzbx> getDfprwdList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return rwpfMapper.getDfprwdList(param);
    }

    @Override
    public List<Gzbx> getWxzrrInfo(Map<String, String> param) {
        return rwpfMapper.getWxzrrInfo(param);
    }

    @Override
    public int fpWxrwd(Gzbx gzbx) {
        return rwpfMapper.fpWxrwd(gzbx);
    }

    @Override
    public int czfpWxrwd(Gzbx gzbx) {
        return rwpfMapper.czfpWxrwd(gzbx);
    }

    @Override
    public List<Gzbx> getWxrwdList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return rwpfMapper.getWxrwdList(param);
    }
}
