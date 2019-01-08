package com.hdsx.zxyh.service;


import com.hdsx.zxyh.entity.Gcyscbr;
import com.hdsx.zxyh.entity.Gcyssqd;

import java.util.List;
import java.util.Map;

public interface GcysCbrylwtService {


    List<Gcyscbr> getCbrylwtList(Map<String, String> param, int pageNum, int pageSize);

    Gcyscbr getCbrylwtInfoByDjbh(Map<String, String> param);

    int addCbrylwtForGcys(Gcyscbr ccyscbr);

    int editCbrylwtForGcys(Gcyscbr ccyscbr);

    int delCbrylwtForGcys(List<String> l);

    int spCbrylwtForGcys(Map<String, Object> param);
}
