package com.hdsx.jdwh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.jdwh.entity.Gzbx;
import com.hdsx.jdwh.entity.Wxdj;
import com.hdsx.jdwh.mapper.GzbxMapper;
import com.hdsx.jdwh.mapper.WxdjMapper;
import com.hdsx.jdwh.service.GzbxService;
import com.hdsx.jdwh.service.WxdjService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class WxdjServiceImpl implements WxdjService {

    @Resource
    private WxdjMapper wxdjMapper;

    @Override
    public List<Wxdj> getBxdInfo(Map<String, String> param) {
        return wxdjMapper.getBxdInfo(param);
    }

    @Override
    public int addWxdj(Wxdj wxdj) {
        return wxdjMapper.addWxdj(wxdj);
    }

    @Override
    public int editWxdj(Wxdj wxdj) {
        return wxdjMapper.editWxdj(wxdj);
    }

    @Override
    public int delWxdjByDjbhs(List<String> l) {
        return wxdjMapper.delWxdjByDjbhs(l);
    }

    @Override
    public Wxdj getWxdjInfoByIDjbh(String djbh) {
        return wxdjMapper.getWxdjInfoByIDjbh(djbh);
    }

    @Override
    public List<Wxdj> getWxdjList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return wxdjMapper.getWxdjList(param);
    }




}
