package com.hdsx.jdwh.service;

import com.hdsx.jdwh.entity.Gzbx;
import com.hdsx.jdwh.entity.Rcxj;

import java.util.List;
import java.util.Map;

public interface GzbxService {


    List<Gzbx> getSbInfo(Map<String, String> param);

    int addGzbx(Gzbx rcxj);

    int editGzbx(Gzbx rcxj);

    int delGzbxByDjbhs(List<String> l);

    Gzbx getGzbxInfoByIDjbh(String djbh);

    List<Gzbx> getGzbxList(Map<String, String> param, int pageNum, int pageSize);
}
