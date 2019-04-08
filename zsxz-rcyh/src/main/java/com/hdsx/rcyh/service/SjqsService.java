package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Rcqs;
import com.hdsx.rcyh.entity.RcqsPZ;
import com.hdsx.rcyh.entity.Sjqs;
import com.hdsx.rcyh.entity.SjqsPZ;

import java.util.List;
import java.util.Map;

public interface SjqsService {


    List<Sjqs> getSjqsrwList(Map<String, String> param, int pageNum, int pageSize);

    int insertSjqs(Sjqs sjqs);

    int insertSjqsPZ(SjqsPZ sjqsPZ);

    List<Map> getSjqsPz(String qsry);


}
