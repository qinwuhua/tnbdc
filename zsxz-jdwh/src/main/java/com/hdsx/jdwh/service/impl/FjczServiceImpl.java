package com.hdsx.jdwh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.jdwh.entity.Fjcz;
import com.hdsx.jdwh.mapper.FjczMapper;
import com.hdsx.jdwh.service.FjczService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class FjczServiceImpl implements FjczService {

    @Resource
    private FjczMapper fjczMapper;

    @Override
    public int addFjcz(Fjcz fjcz) {
        int i=fjczMapper.addFjcz(fjcz);
        int k=fjczMapper.addFjczMx(fjcz);
        int j=fjczMapper.addFjczfyMx(fjcz);
        return i;
    }

    @Override
    public int editFjcz(Fjcz fjcz) {
        int i=fjczMapper.editFjcz(fjcz);
        //删除子表
        int j=fjczMapper.delFjczMx(fjcz);
        int j1=fjczMapper.delFjczfyMx(fjcz);
        //添加子表
        int k=fjczMapper.addFjczMx(fjcz);
        int j2=fjczMapper.addFjczfyMx(fjcz);
        return i;
    }

    @Override
    public int delFjczByDjbhs(List<String> l) {
        int i=fjczMapper.delFjczBydjbhs(l);
        int j=fjczMapper.delFjczMxBydjbhs(l);
        int k=fjczMapper.delFjczfyMxBydjbhs(l);
        return i;
    }

    @Override
    public Fjcz getFjczInfoByDjbh(String djbh) {
        return fjczMapper.getFjczInfoByDjbh(djbh);
    }

    @Override
    public List<Fjcz> getFjczList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Fjcz> list = fjczMapper.getFjczList(param);
        return list;
    }

    @Override
    public int spFjczByDjbh(Map<String, Object> param) {
        //设置状态为处置
        fjczMapper.editFjZtFlag(param);
        return fjczMapper.spFjczByDjbh(param);
    }


}
