package com.hdsx.jdwh.service;

import com.hdsx.jdwh.entity.Bjck;
import com.hdsx.jdwh.entity.Bjckmx;
import com.hdsx.jdwh.entity.Fjrk;

import java.util.List;
import java.util.Map;

public interface FjrkService {

    List<Map<String, String>> getWxdhInfByDw(Map<String, String> param);

    int addFjrk(Fjrk fjrk);

    int editFjrk(Fjrk fjrk);

    int delFjrkBydjbhs(List<String> l);

    Fjrk getFjrkInfoByDjbh(String djbh);

    List<Fjrk> getFjrkList(Map<String, String> param, int pageNum, int pageSize);
}
