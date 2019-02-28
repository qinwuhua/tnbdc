package com.hdsx.jdwh.mapper;

import com.hdsx.jdwh.entity.Bjck;
import com.hdsx.jdwh.entity.Bjckmx;
import com.hdsx.jdwh.entity.Fjrk;
import com.hdsx.jdwh.entity.Fjrkmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FjrkMapper {

    List<Map<String, String>> getWxdhInfByDw(Map<String, String> param);

    int addFjrk(Fjrk fjrk);

    int addFjrkMx(Fjrk fjrk);

    int editFjrk(Fjrk fjrk);

    int delFjrkMx(Fjrk fjrk);

    int delFjrkBydjbhs(List<String> l);

    int delFjrkMxBydjbhs(List<String> l);

    Fjrk getFjrkInfoByDjbh(String djbh);

    List<Fjrk> getFjrkList(Map<String, String> param);

    List<Fjrkmx> getFjrkmxByPdjbh(String djbh);

    int getRkCount(Fjrk fjrk);
}
