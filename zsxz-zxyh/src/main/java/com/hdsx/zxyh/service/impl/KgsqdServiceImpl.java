package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Kgsqd;
import com.hdsx.zxyh.mapper.KgsqdMapper;
import com.hdsx.zxyh.service.KgsqdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KgsqdServiceImpl implements KgsqdService {

    @Resource
    private KgsqdMapper kgsqdMapper;

    @Override
    public List<Kgsqd> getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return kgsqdMapper.getAll();
    }

    @Override
    public int addKgsqd(Kgsqd kgsqd) {
        return kgsqdMapper.addKgsqd(kgsqd);
    }

    @Override
    public int updateKgsqd(Kgsqd kgsqd) {
        return kgsqdMapper.updateKgsqd(kgsqd);
    }

    @Override
    public int deleteKgsqd(String[] djbhs) {
        return kgsqdMapper.deleteKgsqd(djbhs);
    }
}
