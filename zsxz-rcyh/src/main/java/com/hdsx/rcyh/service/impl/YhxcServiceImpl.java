package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.Qdxc;
import com.hdsx.rcyh.mapper.YhxcMapper;
import com.hdsx.rcyh.service.YhxcService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class YhxcServiceImpl implements YhxcService {
    @Resource
    private YhxcMapper yhxcMapper;

    @Override
    public int insertYhxc(Qdxc qdxc) {
        return yhxcMapper.insertYhxc(qdxc);
    }

    @Override
    public List<Qdxc> selectJdlx(HashMap<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Qdxc>list=yhxcMapper.selectJdlx(param);
        return list;
    }

}
