package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Gcysjiaog;
import com.hdsx.zxyh.mapper.GcysjiaogMapper;
import com.hdsx.zxyh.service.GcysjiaogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class GcysjiaogServiceImpl implements GcysjiaogService {

    @Resource
    private GcysjiaogMapper gcysjiaogMapper;


    @Override
    public List<Gcysjiaog> getHtJiaogInfoByBm(Map<String, String> param) {
        return gcysjiaogMapper.getHtJiaogInfoByBm(param);
    }

    @Override
    public int addJiaogForGcys(Gcysjiaog jgjs) {
        gcysjiaogMapper.addJiaogMxForGcys(jgjs);
        return gcysjiaogMapper.addJiaogForGcys(jgjs);
    }

    @Override
    public int editJiaogForGcys(Gcysjiaog jgjs) {
        //根据单据编号删除子表
        gcysjiaogMapper.deleJiaogByDjbh(jgjs.getPmmtjgjss_jssbh());
        //插入子表
        gcysjiaogMapper.addJiaogMxForGcys(jgjs);
        //修改主表
        return gcysjiaogMapper.editJiaogForGcys(jgjs);
    }

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
    }
}
