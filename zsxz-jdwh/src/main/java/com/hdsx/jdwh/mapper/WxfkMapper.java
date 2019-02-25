package com.hdsx.jdwh.mapper;

import com.hdsx.jdwh.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface WxfkMapper {
    List<Wxfkjsmx> getJsmxByPdjbh(String pdjbh);

    List<Wxfkfpmx> getFpmxByPdjbh(String pdjbh);

    int addWxfk(Wxfk wxfk);

    int addWxfkJsmx(Wxfk wxfk);

    int addWxfkFpmx(Wxfk wxfk);

    int editWxfk(Wxfk wxfk);

    int delWxfkJsmx(Wxfk wxfk);

    int delWxfkFpmx(Wxfk wxfk);

    int delWxfkByDjbhs(List<String> l);

    int delWxfkJsmxByDjbhs(List<String> l);

    int delWxfkFpmxByDjbhs(List<String> l);

    Wxfk getWxfkInfoByDjbh(String djbh);

    List<Wxfk> getWxfkList(Map<String, String> param);

    List<Wxfkjsmx> getWxfyChooseList(Map<String, String> param);

    List<Map<String, String>> getFpInfo();
}
