package com.hdsx.lkpd.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.lkpd.entity.Pdfa;
import com.hdsx.lkpd.entity.Qmldb;
import com.hdsx.lkpd.mapper.LkpdCxMapper;
import com.hdsx.lkpd.service.LkpdCxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LkpdCxServiceImpl implements LkpdCxService {

    @Resource
    private LkpdCxMapper lkpdCxMapper;


    @Override
    public List<Qmldb> getMxbForLksjcx(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Qmldb> list = lkpdCxMapper.getMxbForLksjcx(param);
        return list;
    }

    @Override
    public List<Map<String, String>> getHzbForLksjcx(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String,String>> list = lkpdCxMapper.getHzbForLksjcx(param);
        return list;
    }

    @Override
    public Map getDjbhForLksjcx() {
        return lkpdCxMapper.getDjbhForLksjcx();
    }

    @Override
    public Integer getIsFaDataByDjbh(Integer djbh) {
        return lkpdCxMapper.getIsFaDataByDjbh(djbh);
    }

    @Override
    public int addFaForLksjcx(Pdfa pdfa) {
        return lkpdCxMapper.addFaForLksjcx(pdfa);
    }

    @Override
    public List<Pdfa> getFaForLksjcx(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Pdfa> list = lkpdCxMapper.getFaForLksjcx(param);
        return list;
    }

    @Override
    public int editFaForLksjcx(Pdfa pdfa) {
        return lkpdCxMapper.editFaForLksjcx(pdfa);
    }
}
