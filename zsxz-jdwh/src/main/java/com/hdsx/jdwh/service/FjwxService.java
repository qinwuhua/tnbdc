package com.hdsx.jdwh.service;

import com.hdsx.jdwh.entity.Fjrk;
import com.hdsx.jdwh.entity.Fjwx;

import java.util.List;
import java.util.Map;

public interface FjwxService {

    List<Map<String, String>> getShbjInfByDw(Map<String, String> param);

    int addFjwx(Fjwx fjwx);

    int editFjwx(Fjwx fjwx);

    int delFjwxBydjbhs(List<String> l);

    Fjwx getFjwxInfoByDjbh(String djbh);

    List<Fjwx> getFjwxList(Map<String, String> param, int pageNum, int pageSize);
}
