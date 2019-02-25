package com.hdsx.jdwh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.jdwh.entity.Fjwx;
import com.hdsx.jdwh.mapper.FjwxMapper;
import com.hdsx.jdwh.service.FjwxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class FjwxServiceImpl implements FjwxService {

    @Resource
    private FjwxMapper fjwxMapper;

    @Override
    public List<Map<String, String>> getShbjInfByDw(Map<String, String> param) {
        return fjwxMapper.getWxdhInfByDw(param);
    }

    @Override
    public int addFjwx(Fjwx fjwx) {
        int i=fjwxMapper.addFjwx(fjwx);
        int k=fjwxMapper.addFjwxMx(fjwx);
        return i;
    }

    @Override
    public int editFjwx(Fjwx fjwx) {
        //修改主表
        int i=fjwxMapper.editFjwx(fjwx);
        //删除子表
        int j=fjwxMapper.delFjwxMx(fjwx);
        //添加子表
        int k=fjwxMapper.addFjwxMx(fjwx);
        return i;
    }

    @Override
    public int delFjwxBydjbhs(List<String> l) {
        int i=fjwxMapper.delFjwxBydjbhs(l);
        int j=fjwxMapper.delFjwxMxBydjbhs(l);
        return i;
    }

    @Override
    public Fjwx getFjwxInfoByDjbh(String djbh) {
        return fjwxMapper.getFjwxInfoByDjbh(djbh);
    }

    @Override
    public List<Fjwx> getFjwxList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Fjwx> list = fjwxMapper.getFjwxList(param);
        return list;
    }

}
