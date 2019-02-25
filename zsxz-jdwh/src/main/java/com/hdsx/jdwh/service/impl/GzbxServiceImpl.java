package com.hdsx.jdwh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.jdwh.entity.Gzbx;
import com.hdsx.jdwh.entity.Rcxj;
import com.hdsx.jdwh.mapper.GzbxMapper;
import com.hdsx.jdwh.mapper.RcxjMapper;
import com.hdsx.jdwh.service.GzbxService;
import com.hdsx.jdwh.service.RcxjService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class GzbxServiceImpl implements GzbxService {

    @Resource
    private GzbxMapper gzbxMapper;


    @Override
    public List<Gzbx> getSbInfo(Map<String, String> param) {
        return gzbxMapper.getSbInfo(param);
    }

    @Override
    public int addGzbx(Gzbx rcxj) {
        return gzbxMapper.addGzbx(rcxj);
    }

    @Override
    public int editGzbx(Gzbx rcxj) {
        return gzbxMapper.editGzbx(rcxj);
    }

    @Override
    public int delGzbxByDjbhs(List<String> l) {
        return gzbxMapper.delGzbxByDjbhs(l);
    }

    @Override
    public Gzbx getGzbxInfoByIDjbh(String djbh) {
        return gzbxMapper.getGzbxInfoByIDjbh(djbh);
    }

    @Override
    public List<Gzbx> getGzbxList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return gzbxMapper.getGzbxList(param);
    }
}
