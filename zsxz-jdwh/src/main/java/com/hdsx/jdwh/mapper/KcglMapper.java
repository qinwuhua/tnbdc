package com.hdsx.jdwh.mapper;

import com.hdsx.jdwh.entity.Kcgl;
import com.hdsx.jdwh.entity.Ysrk;
import com.hdsx.jdwh.entity.Ysrkmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface KcglMapper {

    List<Kcgl> getCkBjAll(Map<String, String> param);

    List<Kcgl> getCkAll();

    List<Kcgl> getCkBjAllByCkmc(Map<String, String> param);

    double getTcsl(Kcgl kcgl);

    int jldbrz(Kcgl kcgl);

    int dbzbbj(Kcgl kcgl);

    int dbmxbj(Kcgl kcgl);

    Kcgl getBjJbInfo(Kcgl kcgl);

    int dbBjCk(Kcgl kcgl);

    int dbBjCkMx(Kcgl kcgl);

    int dbBjRk(Kcgl kcgl);

    int dbBjRkMx(Kcgl kcgl);
}
