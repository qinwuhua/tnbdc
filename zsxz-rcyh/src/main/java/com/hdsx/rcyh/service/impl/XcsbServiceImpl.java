package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.mapper.XcsbMapper;
import com.hdsx.rcyh.service.XcsbService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@Service
@Transactional
public class XcsbServiceImpl implements XcsbService {
    @Resource
    private XcsbMapper xcsbMapper;
    @Override
    public List<HashMap<String, Object>> getXcsb(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = xcsbMapper.getXcsb();
        return list;
    }

}
