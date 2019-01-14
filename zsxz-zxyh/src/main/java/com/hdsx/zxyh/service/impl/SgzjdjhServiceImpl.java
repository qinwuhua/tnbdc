package com.hdsx.zxyh.service.impl;

import com.hdsx.zxyh.entity.Sgzjdjh;
import com.hdsx.zxyh.mapper.SgzjdjhMapper;
import com.hdsx.zxyh.service.SgzjdjhService;
import com.hdsx.zxyh.utils.UuidUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SgzjdjhServiceImpl implements SgzjdjhService {

    @Resource
    private SgzjdjhMapper sgzjdjhMapper;

    @Override
    public List<Sgzjdjh> getSgzjdjh() {
        return sgzjdjhMapper.getSgzjdjh();
    }

    @Override
    public int addSgzjdjh(Sgzjdjh sgzjdjh) {
        if (sgzjdjh.getId() == null || sgzjdjh.getId() == "") {
            sgzjdjh.setId(UuidUtil.getUUID());
        }
        return sgzjdjhMapper.addSgzjdjh(sgzjdjh);
    }

    @Override
    public int updateSgzjdjh(Sgzjdjh sgzjdjh) {
        return sgzjdjhMapper.updateSgzjdjh(sgzjdjh);
    }

    @Override
    public int deleteSgzjdjh(String[] ids) {
        return sgzjdjhMapper.deleteSgzjdjh(ids);
    }
}
