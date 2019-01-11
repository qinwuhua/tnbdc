package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Gcyssqd;
import com.hdsx.zxyh.mapper.GcysSqdMapper;
import com.hdsx.zxyh.service.GcysSqdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class GcysSqdServiceImpl implements GcysSqdService {

    @Resource
    private GcysSqdMapper gcysSqdMapper;

    @Override
    public List<Gcyssqd> getGcyssqdList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Gcyssqd> list = gcysSqdMapper.getGcyssqdList(param);
        return list;
    }

    @Override
    public Gcyssqd getGcyssqdInfoBySqbh(Map<String, String> param) {
        return gcysSqdMapper.getGcyssqdInfoBySqbh(param);
    }

    @Override
    public int addGcyssqdForGcys(Gcyssqd gcyssqd) {
        return gcysSqdMapper.addGcyssqdForGcys(gcyssqd);
    }

    @Override
    public int editGcyssqdForGcys(Gcyssqd gcyssqd) {
        return gcysSqdMapper.editGcyssqdForGcys(gcyssqd);
    }

    @Override
    public int delGcyssqdForGcys(List<String> l) {
        return gcysSqdMapper.delGcyssqdForGcys(l);
    }

    @Override
    public int spGcyssqdForGcys(Map<String, Object> param) {
        return gcysSqdMapper.spGcyssqdForGcys(param);
    }


}
