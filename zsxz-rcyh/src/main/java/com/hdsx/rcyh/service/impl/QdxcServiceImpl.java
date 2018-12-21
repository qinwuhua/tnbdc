package com.hdsx.rcyh.service.impl;

import com.hdsx.rcyh.entity.Qdxc;
import com.hdsx.rcyh.mapper.QdxcMapper;
import com.hdsx.rcyh.service.QdxcService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class QdxcServiceImpl implements QdxcService {

    @Resource
    private QdxcMapper qdxcMapper;

    @Override
    public int delete(String xcrwId) {
        return qdxcMapper.delete(xcrwId);
    }

    @Override
    public int deletes(String[] xcrwId) {
        int deleteNum = 0;
        for (int i = 0; i < xcrwId.length; i++) {
            deleteNum += qdxcMapper.delete(xcrwId[i]);
        }
        return deleteNum;
    }

    @Override
    public int insert(Qdxc qdxc) {
       return qdxcMapper.insert(qdxc);
    }

    @Override
    public List<Qdxc> QueryOne(String xcrwId) {
        return qdxcMapper.QueryOne(xcrwId);
    }

}
