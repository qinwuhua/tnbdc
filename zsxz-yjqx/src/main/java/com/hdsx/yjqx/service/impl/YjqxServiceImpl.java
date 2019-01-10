package com.hdsx.yjqx.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.yjqx.entity.Yjqx;
import com.hdsx.yjqx.mapper.YjqxMapper;
import com.hdsx.yjqx.service.YjqxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class YjqxServiceImpl implements YjqxService {

    @Resource
    YjqxMapper yjqxMapper;

    @Override
    public int addYjqxgc(Yjqx yjqx) {
        return yjqxMapper.addYjqxgc(yjqx);
    }

    @Override
    public int editYjqxgc(Yjqx yjqx) { return yjqxMapper.editYjqxgc(yjqx); }

    @Override
    public int delYjqxgcByIds(String[] ids) {
        return yjqxMapper.delYjqxgcByIds(ids);
    }

    @Override
    public List<Yjqx> getYjqxgcList(HashMap<String, String> paramMap, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Yjqx> list = yjqxMapper.getYjqxgcList(paramMap);
        return list;
    }

}
