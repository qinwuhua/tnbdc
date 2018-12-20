package com.hdsx.lkpd.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.lkpd.entity.Lkdcfb;
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
}
