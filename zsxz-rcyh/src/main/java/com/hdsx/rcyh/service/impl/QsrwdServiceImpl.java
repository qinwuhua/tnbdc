package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.Qsrwd;
import com.hdsx.rcyh.mapper.QsrwdMapper;
import com.hdsx.rcyh.service.QsrwdService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QsrwdServiceImpl implements QsrwdService {
    @Resource
    private QsrwdMapper qsrwdMapper;

    @Override
    public int insert(Qsrwd qsrwd) {
        String a = "djbh";
        long l = System.currentTimeMillis();
        String l1 = l + "";
        String ss = a +l1 ;
        qsrwd.setQsrwddjbh(ss);
        qsrwd.setQsrwdshzt("未处理");
        return qsrwdMapper.insert(qsrwd);
    }



    @Override
    public int update(Qsrwd qsrwd) {
        return qsrwdMapper.update(qsrwd);
    }

    @Override
    public List<Qsrwd> getQsrwdList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Qsrwd> list = qsrwdMapper.getQsrwdList(param);
        return list;
    }

    @Override
    public int delete(String qsrwdid) {
        return qsrwdMapper.delete(qsrwdid);
    }
}
