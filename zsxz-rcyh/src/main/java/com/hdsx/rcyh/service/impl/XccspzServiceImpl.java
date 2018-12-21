package com.hdsx.rcyh.service.impl;

import com.hdsx.rcyh.entity.Xccspz;
import com.hdsx.rcyh.mapper.XccspzMapper;
import com.hdsx.rcyh.service.XccspzService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class XccspzServiceImpl implements XccspzService {

    @Resource
    private XccspzMapper xccspzMapper;


    @Override
    public int delete(String xccsId) {
        return xccspzMapper.delete(xccsId);
    }

    @Override
    public int deletes(String[] xccsId) {
        int deleteNum = 0;
        for (int i = 0; i < xccsId.length; i++) {
            deleteNum += xccspzMapper.delete(xccsId[i]);
        }
        return deleteNum;

    }

    @Override
    public int insert(Xccspz xccspz) {
        return xccspzMapper.insert(xccspz);
    }

    @Override
    public List<Xccspz> QueryOne(String xccsId) {
        return xccspzMapper.QueryOne(xccsId);
    }

    @Override
    public int update(Xccspz xccspz) {
        return xccspzMapper.update(xccspz);
    }
}
