package com.hdsx.jdwh.service;

import com.hdsx.jdwh.entity.Kcgl;
import com.hdsx.jdwh.entity.Ysrk;

import java.util.List;
import java.util.Map;

public interface KcglService {


    List<Kcgl> getCkBjAll(Map<String, String> param, int pageNum, int pageSize);

    List<Kcgl> getCkAll();

    List<Kcgl> getCkBjAllByCkmc(Map<String, String> param);

    double getTcsl(Kcgl kcgl);

    int jldbrz(Kcgl kcgl);

    int dbBj(Kcgl kcgl);

    Kcgl getBjJbInfo(Kcgl kcgl);

    int dbBjCk(Kcgl kcgl);

    int dbBjRk(Kcgl kcgl);
}
