package com.hdsx.jdwh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.jdwh.entity.Lysq;
import com.hdsx.jdwh.mapper.LysqMapper;
import com.hdsx.jdwh.service.LysqService;
import com.hdsx.jdwh.service.LysqService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LysqServiceImpl implements LysqService {

    @Resource
    private LysqMapper lysqMapper;

    @Override
    public List<Map<String, String>> getBjLyInfo(Map<String, String> param) {
        return lysqMapper.getBjLyInfo(param);
    }

    @Override
    public int addLysq(Lysq lysq) {
        int i=lysqMapper.addLysq(lysq);
        int k=lysqMapper.addLysqMx(lysq);
        return i;
    }

    @Override
    public int editLysq(Lysq lysq) {
        //修改主表
        int i=lysqMapper.editLysq(lysq);
        //删除子表
        int j=lysqMapper.delLysqMx(lysq);
        //添加子表
        int k=lysqMapper.addLysqMx(lysq);
        return i;
    }

    @Override
    public int delLysqBydjbhs(List<String> l) {
        int i=lysqMapper.delLysqBydjbhs(l);
        int j=lysqMapper.delLysqMxBydjbhs(l);
        return i;
    }

    @Override
    public Lysq getLysqInfoByDjbh(String djbh) {
        return lysqMapper.getLysqInfoByDjbh(djbh);
    }

    @Override
    public List<Lysq> getLysqList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Lysq> list = lysqMapper.getLysqList(param);
        return list;
    }

}
