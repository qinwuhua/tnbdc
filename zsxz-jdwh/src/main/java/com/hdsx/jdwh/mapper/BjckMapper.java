package com.hdsx.jdwh.mapper;

import com.hdsx.jdwh.entity.Bjck;
import com.hdsx.jdwh.entity.Bjckmx;
import com.hdsx.jdwh.entity.Lysq;
import com.hdsx.jdwh.entity.Lysqmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BjckMapper {

    List<Map<String, String>> getBjLySqdInfo(Map<String, String> param);

    List<Bjckmx> getBjInfoByLySqd(Map<String, String> param);

    int addBjck(Bjck bjck);

    int addBjckMx(Bjck bjck);

    int editBjck(Bjck bjck);

    int delBjckMx(Bjck bjck);

    int delBjckBydjbhs(List<String> l);

    int delBjckMxBydjbhs(List<String> l);

    List<Bjckmx> getBjckmxByPdjbh(String djbh);

    Bjck getBjckInfoByDjbh(String djbh);

    List<Bjck> getBjckList(Map<String, String> param);
}
