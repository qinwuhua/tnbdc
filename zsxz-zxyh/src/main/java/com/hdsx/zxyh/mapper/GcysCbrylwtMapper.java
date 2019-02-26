package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Gcyscbr;
import com.hdsx.zxyh.entity.Gcyscbrmx;
import com.hdsx.zxyh.entity.Gcyssqd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface GcysCbrylwtMapper {

    List<Gcyscbr> getCbrylwtList(Map<String, String> param);

    List<Gcyscbrmx> getcbrylwtmx(String djbh);

    Gcyscbr getCbrylwtInfoByDjbh(Map<String, String> param);

    int addCbrylwtMxForGcys(Gcyscbr ccyscbr);

    int addCbrylwtForGcys(Gcyscbr ccyscbr);

    int delCbrylwtMxByDjbh(String djbh);

    int editCbrylwtForGcys(Gcyscbr ccyscbr);

    void delCbrylwtMxForGcys(List<String> l);

    int delCbrylwtForGcys(List<String> l);

    int spCbrylwtForGcys(Map<String, Object> param);
}
