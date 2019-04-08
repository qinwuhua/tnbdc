package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.hdsx.zxyh.entity.Sgzjdjh;
import com.hdsx.zxyh.mapper.SgzjdjhMapper;
import com.hdsx.zxyh.service.SgzjdjhService;
import com.hdsx.zxyh.utils.UuidUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SgzjdjhServiceImpl implements SgzjdjhService {

    @Resource
    private SgzjdjhMapper sgzjdjhMapper;

    @Override
    public List<Sgzjdjh> getSgzjdjh(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return sgzjdjhMapper.getSgzjdjh();
    }

    @Override
    public int addSgzjdjh(Sgzjdjh sgzjdjh) {
        if (sgzjdjh.getId() == null || sgzjdjh.getId() == "") {
            sgzjdjh.setId(UuidUtil.getUUID());
        }
        int i=sgzjdjhMapper.addSgzjdjh(sgzjdjh);
        if(sgzjdjh.getMx().size()>0){
            int j=sgzjdjhMapper.addSgzjdjhMx(sgzjdjh);
        }

        return i;
    }

    @Override
    public int updateSgzjdjh(Sgzjdjh sgzjdjh) {
        int i=sgzjdjhMapper.updateSgzjdjh(sgzjdjh);
        int j=sgzjdjhMapper.delSgzjdjhMx(sgzjdjh.getDjbh());
        int k=sgzjdjhMapper.addSgzjdjhMx(sgzjdjh);
        return i;
    }

    @Override
    public int deleteSgzjdjh(List ids) {
        int j=sgzjdjhMapper.deleteSgzjdjhiMx(ids);
        int i=sgzjdjhMapper.deleteSgzjdjh(ids);
        return i;
    }

    @Override
    public int spSgzjdjh(Map<String, Object> param) {
        return sgzjdjhMapper.spSgzjdjh(param);
    }
}
