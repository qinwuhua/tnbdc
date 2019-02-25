package com.hdsx.jdwh.mapper;

import com.hdsx.jdwh.entity.Rcxj;
import com.hdsx.jdwh.entity.Rcxjmx;
import com.hdsx.jdwh.entity.Ysrk;
import com.hdsx.jdwh.entity.Ysrkmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface YsrkMapper {

    List<Map<String,String>> getCkInfo(Map<String, String> param);

    List<Map<String, String>> getWxdhInfo(Map<String, String> param);

    List<Map<String, String>> getHtBjInfo(Map<String, String> param);

    List<Map<String, String>> getWxBjInfo(Map<String, String> param);

    int addYsrk(Ysrk ysrk);

    int addYsrkMx(Ysrk ysrk);

    List<Ysrkmx> getYsrkmxByPdjbh(String rkdjbh);

    int editYsrk(Ysrk ysrk);

    int delYsrkMx(Ysrk ysrk);

    int delYsrkBydjbhs(List<String> l);

    int delYsrkMxBydjbhs(List<String> l);

    Ysrk getYsrkInfoByDjbh(String djbh);

    List<Ysrk> getYsrkList(Map<String, String> param);
}
