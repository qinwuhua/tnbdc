package com.hdsx.jdwh.mapper;

import com.hdsx.jdwh.entity.Lysq;
import com.hdsx.jdwh.entity.Lysqmx;
import com.hdsx.jdwh.entity.Ysrk;
import com.hdsx.jdwh.entity.Ysrkmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LysqMapper {
    List<Lysqmx> getLysqmxByPdjbh(String djbh);

    List<Map<String, String>> getBjLyInfo(Map<String, String> param);


    int addLysq(Lysq lysq);

    int addLysqMx(Lysq lysq);

    int editLysq(Lysq lysq);

    int delLysqMx(Lysq lysq);

    int delLysqBydjbhs(List<String> l);

    int delLysqMxBydjbhs(List<String> l);

    Lysq getLysqInfoByDjbh(String djbh);

    List<Lysq> getLysqList(Map<String, String> param);
}
