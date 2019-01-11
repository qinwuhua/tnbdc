package com.hdsx.zxyh.service;


import com.hdsx.zxyh.entity.Gcysjiaog;
import com.hdsx.zxyh.entity.Gcysjung;

import java.util.List;
import java.util.Map;

public interface GcysjungService {
    List<Gcysjung> getHtJungInfoByBm(Map<String, String> param);

    int addJungForGcys(Gcysjung jgjs);

    int editJungForGcys(Gcysjung jgjs);

    int delJungForGcys(List<String> l);

    Gcysjung getJungInfoByDjbh(String jssbh);

    List<Gcysjung> getJungList(Map<String, String> param, int pageNum, int pageSize);

    int spJungForGcys(Map<String, Object> param);


    /*List<Gcysjiaog> getHtJiaogInfoByBm(Map<String, String> param);

    int addJiaogForGcys(Gcysjiaog jgjs);

    int editJiaogForGcys(Gcysjiaog jgjs);

    int delJiaogForGcys(List<String> l);

    Gcysjiaog getJiaogInfoByDjbh(String pmmtjgjss_jssbh);

    List<Gcysjiaog> getJiaogList(Map<String, String> param, int pageNum, int pageSize);

    int spJiaogForGcys(Map<String, Object> param);*/
}
