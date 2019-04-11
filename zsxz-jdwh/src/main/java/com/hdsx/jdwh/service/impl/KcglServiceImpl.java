package com.hdsx.jdwh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.jdwh.entity.Kcgl;
import com.hdsx.jdwh.entity.Ysrk;
import com.hdsx.jdwh.mapper.KcglMapper;
import com.hdsx.jdwh.mapper.YsrkMapper;
import com.hdsx.jdwh.service.KcglService;
import com.hdsx.jdwh.service.YsrkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class KcglServiceImpl implements KcglService {

    @Resource
    private KcglMapper kcglMapper;

    @Override
    public List<Kcgl> getCkBjAll(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Kcgl> list = kcglMapper.getCkBjAll(param);
        return  list;
    }

    @Override
    public List<Kcgl> getCkAll() {
        return kcglMapper.getCkAll();
    }

    @Override
    public List<Kcgl> getCkBjAllByCkmc(Map<String, String> param) {
        List<Kcgl> list = kcglMapper.getCkBjAllByCkmc(param);
        return  list;
    }

    @Override
    public double getTcsl(Kcgl kcgl) {
        return kcglMapper.getTcsl(kcgl);
    }

    @Override
    public int jldbrz(Kcgl kcgl) {
        return kcglMapper.jldbrz(kcgl);
    }

    @Override
    public int dbBj(Kcgl kcgl) {
        int i=kcglMapper.dbzbbj(kcgl);
        int j=kcglMapper.dbmxbj(kcgl);

        return i;
    }

    @Override
    public Kcgl getBjJbInfo(Kcgl kcgl) {
        return kcglMapper.getBjJbInfo(kcgl);
    }

    @Override
    public int dbBjCk(Kcgl kcgl) {
        int i=kcglMapper.dbBjCk(kcgl);
        int j=kcglMapper.dbBjCkMx(kcgl);
        return i;
    }

    @Override
    public int dbBjRk(Kcgl kcgl) {
        int i=kcglMapper.dbBjRk(kcgl);
        int j=kcglMapper.dbBjRkMx(kcgl);
        return i;
    }


   /* @Override
    public List<Map<String,String>> getCkInfo(Map<String, String> param) {
        return ysrkMapper.getCkInfo(param);
    }

    @Override
    public List<Map<String, String>> getWxdhInfo(Map<String, String> param) {
        return ysrkMapper.getWxdhInfo(param);
    }

    @Override
    public List<Map<String, String>> getHtBjInfo(Map<String, String> param) {
        return ysrkMapper.getHtBjInfo(param);
    }

    @Override
    public List<Map<String, String>> getWxBjInfo(Map<String, String> param) {
        return ysrkMapper.getWxBjInfo(param);
    }

    @Override
    public int addYsrk(Ysrk ysrk) {
        int i=ysrkMapper.addYsrk(ysrk);
        int k=ysrkMapper.addYsrkMx(ysrk);
        return i;
    }

    @Override
    public int editYsrk(Ysrk ysrk) {
        //修改主表
        int i=ysrkMapper.editYsrk(ysrk);
        //删除子表
        int j=ysrkMapper.delYsrkMx(ysrk);
        //添加子表
        int k=ysrkMapper.addYsrkMx(ysrk);
        return i;
    }

    @Override
    public int delYsrkBydjbhs(List<String> l) {
        int i=ysrkMapper.delYsrkBydjbhs(l);
        int j=ysrkMapper.delYsrkMxBydjbhs(l);
        return i;
    }

    @Override
    public Ysrk getYsrkInfoByDjbh(String djbh) {
        return ysrkMapper.getYsrkInfoByDjbh(djbh);
    }

    @Override
    public List<Ysrk> getYsrkList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Ysrk> list = ysrkMapper.getYsrkList(param);
        return  list;
    }*/


}
