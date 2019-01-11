package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Bgglspsqs;
import com.hdsx.zxyh.entity.Gcyssqd;
import com.hdsx.zxyh.mapper.BgglspsqMapper;
import com.hdsx.zxyh.service.BgglspsqService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class BgglspsqServiceImpl implements BgglspsqService {

    @Resource
    private BgglspsqMapper bgglspsqMapper;

    @Override
    public int addSpsqsForBggl(Bgglspsqs bgglspsqs) {
        return bgglspsqMapper.addSpsqsForBggl(bgglspsqs);
    }

    @Override
    public int editSpsqsForBggl(Bgglspsqs bgglspsqs) {
        return bgglspsqMapper.editSpsqsForBggl(bgglspsqs);
    }

    @Override
    public int delSpsqsForBggl(List<String> l) {
        return bgglspsqMapper.delSpsqsForBggl(l);
    }

    @Override
    public Bgglspsqs getSpsqsInfoByDjbh(String pmmtgcspsqs_djbh) {
        return bgglspsqMapper.getSpsqsInfoByDjbh(pmmtgcspsqs_djbh);
    }

    @Override
    public List<Bgglspsqs> getSpsqdList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Bgglspsqs> list = bgglspsqMapper.getSpsqdList(param);
        return list;
    }

    @Override
    public int spSpsqsForBggl(Map<String, Object> param) {
        return bgglspsqMapper.spSpsqsForBggl(param);
    }


}
