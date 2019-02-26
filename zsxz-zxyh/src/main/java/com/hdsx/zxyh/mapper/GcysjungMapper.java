package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Gcysjiaog;
import com.hdsx.zxyh.entity.Gcysjung;
import com.hdsx.zxyh.entity.Gcysjungmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface GcysjungMapper {
    List<Gcysjung> getHtJungInfoByBm(Map<String, String> param);

    List<Gcysjungmx> getjgjsMx(String djbh);

    int addJungForGcys(Gcysjung jgjs);

    int addJungMxForGcys(Gcysjung jgjs);

    int delJungMxByDjbh(String jssbh);

    int editJungForGcys(Gcysjung jgjs);

    int delJungMxForGcys(List<String> l);

    int delJungForGcys(List<String> l);

    Gcysjung getJungInfoByDjbh(String jssbh);

    List<Gcysjung> getJungList(Map<String, String> param);

    int spJungForGcys(Map<String, Object> param);

    /*List<Gcysjiaog> getHtJiaogInfoByBm(Map<String, String> param);

    int addJiaogMxForGcys(Gcysjiaog jgjs);

    int addJiaogForGcys(Gcysjiaog jgjs);

    int deleJiaogByDjbh(String pmmtjgjss_jssbh);

    int editJiaogForGcys(Gcysjiaog jgjs);

    int delJiaogMxForGcys(List<String> l);

    int delJiaogForGcys(List<String> l);

    Gcysjiaog getJiaogInfoByDjbh(String pmmtjgjss_jssbh);

    List<Gcysjiaog> getJiaogList(Map<String, String> param);

    int spJiaogForGcys(Map<String, Object> param);*/
}
