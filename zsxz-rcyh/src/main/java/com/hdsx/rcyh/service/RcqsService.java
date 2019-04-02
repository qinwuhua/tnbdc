package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Rcqs;
import com.hdsx.rcyh.entity.RcqsPZ;

import java.util.List;
import java.util.Map;

public interface RcqsService {

    List<Rcqs> getRcqsrwList(Map<String, String> param, int pageNum, int pageSize);

    int insertRcqs(Rcqs rcqs);

    int insertRcqsPZ(RcqsPZ rcqsPZ);

    List<Map> getRcqsPz(String qsry);
}
