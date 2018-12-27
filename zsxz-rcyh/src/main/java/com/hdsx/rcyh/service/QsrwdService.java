package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Qsrwd;

import java.util.List;
import java.util.Map;

public interface QsrwdService {
    int insert(Qsrwd qsrwd);



    int update(Qsrwd qsrwd);

    List<Qsrwd> getQsrwdList(Map<String, String> param, int pageNum, int pageSize);

    int delete(String qsrwdid);
}
