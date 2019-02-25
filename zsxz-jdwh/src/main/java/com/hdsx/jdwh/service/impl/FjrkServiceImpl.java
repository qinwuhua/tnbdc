package com.hdsx.jdwh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.jdwh.entity.Fjrk;
import com.hdsx.jdwh.entity.Fjrkmx;
import com.hdsx.jdwh.mapper.FjrkMapper;
import com.hdsx.jdwh.service.FjrkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class FjrkServiceImpl implements FjrkService {

    @Resource
    private FjrkMapper fjrkMapper;

    @Override
    public List<Map<String, String>> getWxdhInfByDw(Map<String, String> param) {
        return fjrkMapper.getWxdhInfByDw(param);
    }

    @Override
    public int addFjrk(Fjrk fjrk) {
        int i=fjrkMapper.addFjrk(fjrk);
        int k=fjrkMapper.addFjrkMx(fjrk);
        return i;
    }

    @Override
    public int editFjrk(Fjrk fjrk) {
        //修改主表
        int i=fjrkMapper.editFjrk(fjrk);
        //删除子表
        int j=fjrkMapper.delFjrkMx(fjrk);
        //添加子表
        int k=fjrkMapper.addFjrkMx(fjrk);
        return i;
    }

    @Override
    public int delFjrkBydjbhs(List<String> l) {
        int i=fjrkMapper.delFjrkBydjbhs(l);
        int j=fjrkMapper.delFjrkMxBydjbhs(l);
        return i;
    }

    @Override
    public Fjrk getFjrkInfoByDjbh(String djbh) {
        return fjrkMapper.getFjrkInfoByDjbh(djbh);
    }

    @Override
    public List<Fjrk> getFjrkList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Fjrk> list = fjrkMapper.getFjrkList(param);
        return list;
    }

}
