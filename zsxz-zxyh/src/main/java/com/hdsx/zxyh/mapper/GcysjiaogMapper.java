package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Gcysjiaog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface GcysjiaogMapper {

    List<Gcysjiaog> getHtJiaogInfoByBm(Map<String, String> param);

    int addJiaogMxForGcys(Gcysjiaog jgjs);

    int addJiaogForGcys(Gcysjiaog jgjs);

    int deleJiaogByDjbh(String pmmtjgjss_jssbh);

    int editJiaogForGcys(Gcysjiaog jgjs);

    int delJiaogMxForGcys(List<String> l);

    int delJiaogForGcys(List<String> l);

    Gcysjiaog getJiaogInfoByDjbh(String pmmtjgjss_jssbh);

    List<Gcysjiaog> getJiaogList(Map<String, String> param);

    int spJiaogForGcys(Map<String, Object> param);
}
