package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.Xccspz;
import com.hdsx.rcyh.mapper.XccspzMapper;
import com.hdsx.rcyh.service.XccspzService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class XccspzServiceImpl implements XccspzService {

    @Resource
    private XccspzMapper xccspzMapper;


    @Override
    public int delete(String xccsId) {
        if (xccspzMapper.delete(xccsId) > 0) {
            System.out.println("fhg" + xccspzMapper.delete(xccsId));
            return xccspzMapper.delete(xccsId);
        }
        return 0;
    }


    @Override
    public List<HashMap<String, Object>> getXccspzAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = xccspzMapper.getXccspzAll();
        return list;
    }


   /* @Override
    public int deletes(String[] xccsId) {
        int deleteNum = 0;
        for (int i = 0; i < xccsId.length; i++) {
            deleteNum += xccspzMapper.delete(xccsId[i]);
        }
        return deleteNum;

    }*/

    @Override
    public int insert(Xccspz xccspz) {
        System.out.println(xccspz);
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
