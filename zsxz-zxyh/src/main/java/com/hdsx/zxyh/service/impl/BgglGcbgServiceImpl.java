package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Bgglbgl;
import com.hdsx.zxyh.entity.Bgglbgsqb;
import com.hdsx.zxyh.entity.Bgglspsqs;
import com.hdsx.zxyh.mapper.BgglGcbgMapper;
import com.hdsx.zxyh.mapper.BgglspsqMapper;
import com.hdsx.zxyh.service.BgglGcbgService;
import com.hdsx.zxyh.service.BgglspsqService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class BgglGcbgServiceImpl implements BgglGcbgService {

    @Resource
    private BgglGcbgMapper bgglGcbgMapper;

    @Override
    public int addBgsqbForBggl(Bgglbgsqb bgglbgsqb) {
        return bgglGcbgMapper.addBgsqbForBggl(bgglbgsqb);
    }

    @Override
    public int editBgsqbForBggl(Bgglbgsqb bgglbgsqb) {
        return bgglGcbgMapper.editBgsqbForBggl(bgglbgsqb);
    }

    @Override
    public int delBgsqbForBggl(List<String> l) {
        return bgglGcbgMapper.delBgsqbForBggl(l);
    }

    @Override
    public Bgglbgsqb getBgsqbInfoByDjbh(String djbh) {
        return bgglGcbgMapper.getBgsqbInfoByDjbh(djbh);
    }

    @Override
    public List<Bgglbgsqb> getBgsqbList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Bgglbgsqb> list = bgglGcbgMapper.getBgsqbList(param);
        return list;
    }

    @Override
    public int spBgsqbForBggl(Map<String, Object> param) {
        return bgglGcbgMapper.spBgsqbForBggl(param);
    }

    @Override
    public Bgglbgl getBglBgsqbInfo() {
        return bgglGcbgMapper.getBglBgsqbInfo();
    }

    @Override
    public int addBglForBggl(Bgglbgl bgglbgl) {
        return bgglGcbgMapper.addBglForBggl(bgglbgl);
    }

    @Override
    public int editBglForBggl(Bgglbgl bgglbgl) {
        return bgglGcbgMapper.editBglForBggl(bgglbgl);
    }

    @Override
    public int delBglForBggl(List<String> l) {
        return bgglGcbgMapper.delBglForBggl(l);
    }

    @Override
    public Bgglbgl getBglInfoByBglbh(String bglbh) {
        return bgglGcbgMapper.getBglInfoByBglbh(bglbh);
    }

    @Override
    public List<Bgglbgl> getBglList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Bgglbgl> list = bgglGcbgMapper.getBglList(param);
        return list;
    }

    @Override
    public int spBglForBggl(Map<String, Object> param) {
        return bgglGcbgMapper.spBglForBggl(param);
    }


}
