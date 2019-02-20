package com.hdsx.lkpd.service;

import com.hdsx.lkpd.entity.Pdfa;
import com.hdsx.lkpd.entity.Qmldb;

import java.util.List;
import java.util.Map;

public interface LkpdCxService {

    List<Qmldb> getMxbForLksjcx(Map<String, String> param, int pageNum, int pageSize);

    List<Map<String, String>> getHzbForLksjcx(Map<String, String> param, int pageNum, int pageSize);

    Map getDjbhForLksjcx();

    Integer getIsFaDataByDjbh(Integer djbh);

    int addFaForLksjcx(Pdfa pdfa);

    List<Pdfa> getFaForLksjcx(Map<String, String> param, int pageNum, int pageSize);

    int editFaForLksjcx(Pdfa pdfa);

    int delFaForLksjcx(List<Long> djbhs);

    boolean createMxbDataForLksjcx(Map<String, String> param);

    Pdfa getFamc(String famc);
}
