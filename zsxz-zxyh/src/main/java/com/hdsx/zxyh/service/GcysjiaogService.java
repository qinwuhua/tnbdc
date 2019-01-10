package com.hdsx.zxyh.service;


import com.hdsx.zxyh.entity.Gcysjiaog;

import java.util.List;
import java.util.Map;

public interface GcysjiaogService {


    List<Gcysjiaog> getHtJiaogInfoByBm(Map<String, String> param);

    int addJiaogForGcys(Gcysjiaog jgjs);

    int editJiaogForGcys(Gcysjiaog jgjs);

    int delJiaogForGcys(List<String> l);

    Gcysjiaog getJiaogInfoByDjbh(String pmmtjgjss_jssbh);

    List<Gcysjiaog> getJiaogList(Map<String, String> param, int pageNum, int pageSize);

    int spJiaogForGcys(Map<String, Object> param);
}
