package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Gcyssqd;
import com.hdsx.zxyh.mapper.GcysFjyibMapper;
import com.hdsx.zxyh.mapper.GcysSqdMapper;
import com.hdsx.zxyh.service.GcysFjylbService;
import com.hdsx.zxyh.service.GcysSqdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class GcysFjylbServiceImpl implements GcysFjylbService {

    @Resource
    private GcysFjyibMapper gcysFjyibMapper;


    @Override
    public List<Map<String, String>> getGcysFjylbList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, String>> list = gcysFjyibMapper.getGcysFjylbList(param);
        return list;
    }
}
