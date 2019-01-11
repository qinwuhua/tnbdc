package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Gcysjung;
import com.hdsx.zxyh.mapper.GcysjungMapper;
import com.hdsx.zxyh.service.GcysjungService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class GcysjungServiceImpl implements GcysjungService {

    @Resource
    private GcysjungMapper gcysjungMapper;

    @Override
    public List<Gcysjung> getHtJungInfoByBm(Map<String, String> param) {
        return gcysjungMapper.getHtJungInfoByBm(param);
    }

    @Override
    public int addJungForGcys(Gcysjung jgjs) {
        gcysjungMapper.addJungMxForGcys(jgjs);
        return gcysjungMapper.addJungForGcys(jgjs);
    }

    @Override
    public int editJungForGcys(Gcysjung jgjs) {
        //根据单据编号删除子表
        gcysjungMapper.delJungMxByDjbh(jgjs.getJssbh());
        //插入子表
        gcysjungMapper.addJungMxForGcys(jgjs);
        //修改主表
        return gcysjungMapper.editJungForGcys(jgjs);
    }

    @Override
    public int delJungForGcys(List<String> l) {
        gcysjungMapper.delJungMxForGcys(l);
        return gcysjungMapper.delJungForGcys(l);
    }

    @Override
    public Gcysjung getJungInfoByDjbh(String jssbh) {
        return gcysjungMapper.getJungInfoByDjbh(jssbh);
    }

    @Override
    public List<Gcysjung> getJungList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Gcysjung> list = gcysjungMapper.getJungList(param);
        return  list;
    }

    @Override
    public int spJungForGcys(Map<String, Object> param) {
        return gcysjungMapper.spJungForGcys(param);
    }


    /*

    @Override
    public int delJiaogForGcys(List<String> l) {
        gcysjiaogMapper.delJiaogMxForGcys(l);
        return gcysjiaogMapper.delJiaogForGcys(l);
    }

    @Override
    public Gcysjiaog getJiaogInfoByDjbh(String pmmtjgjss_jssbh) {
        return gcysjiaogMapper.getJiaogInfoByDjbh(pmmtjgjss_jssbh);
    }

    @Override
    public List<Gcysjiaog> getJiaogList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Gcysjiaog> list = gcysjiaogMapper.getJiaogList(param);
        return  list;
    }

    @Override
    public int spJiaogForGcys(Map<String, Object> param) {
        return gcysjiaogMapper.spJiaogForGcys(param);
    }*/
}
