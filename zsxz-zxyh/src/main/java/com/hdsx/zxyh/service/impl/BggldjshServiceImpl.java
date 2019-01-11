package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Bggldjsh;
import com.hdsx.zxyh.entity.Gcysjung;
import com.hdsx.zxyh.mapper.BggldjshMapper;
import com.hdsx.zxyh.mapper.GcysjungMapper;
import com.hdsx.zxyh.service.BggldjshService;
import com.hdsx.zxyh.service.GcysjungService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class BggldjshServiceImpl implements BggldjshService {

    @Resource
    private BggldjshMapper bggldjshMapper;

    @Override
    public List<Bggldjsh> getHtDjshInfoByBm(Map<String, String> param) {
        return bggldjshMapper.getHtDjshInfoByBm(param);
    }

    @Override
    public int addDjshForGcys(Bggldjsh bggldjsh) {
        bggldjshMapper.addDjshMxForGcys(bggldjsh);
        return bggldjshMapper.addDjshForGcys(bggldjsh);
    }

    @Override
    public int editDjshForGcys(Bggldjsh bggldjsh) {
        //根据单据编号删除子表
        bggldjshMapper.delDjshMxByDjbh(bggldjsh.getDjbh());
        //插入子表
        bggldjshMapper.addDjshMxForGcys(bggldjsh);
        //修改主表
        return bggldjshMapper.editDjshForGcys(bggldjsh);
    }

    @Override
    public int delDjshForGcys(List<String> l) {
        bggldjshMapper.delDjshMxForGcys(l);
        return bggldjshMapper.delDjshForGcys(l);
    }

    @Override
    public Bggldjsh getDjshInfoByDjbh(String djbh) {
        return bggldjshMapper.getDjshInfoByDjbh(djbh);
    }

    @Override
    public List<Bggldjsh> getDjshList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Bggldjsh> list = bggldjshMapper.getDjshList(param);
        return  list;
    }

    @Override
    public int spDjshForGcys(Map<String, Object> param) {
        return bggldjshMapper.spDjshForGcys(param);
    }

    @Override
    public List<Map<String, String>> getHtInfoByZmh(String zmh) {
        return bggldjshMapper.getHtInfoByZmh(zmh);
    }


}
