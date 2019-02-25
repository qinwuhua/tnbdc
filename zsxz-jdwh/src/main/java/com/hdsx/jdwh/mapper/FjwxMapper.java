package com.hdsx.jdwh.mapper;

import com.hdsx.jdwh.entity.Fjrk;
import com.hdsx.jdwh.entity.Fjrkmx;
import com.hdsx.jdwh.entity.Fjwx;
import com.hdsx.jdwh.entity.Fjwxmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FjwxMapper {

    List<Map<String, String>> getWxdhInfByDw(Map<String, String> param);

    List<Fjwxmx> getFjwxmxByPdjbh(String djbh);

    int addFjwx(Fjwx fjwx);

    int addFjwxMx(Fjwx fjwx);

    int editFjwx(Fjwx fjwx);

    int delFjwxMx(Fjwx fjwx);

    int delFjwxBydjbhs(List<String> l);

    int delFjwxMxBydjbhs(List<String> l);

    Fjwx getFjwxInfoByDjbh(String djbh);

    List<Fjwx> getFjwxList(Map<String, String> param);
}
