package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Bggldjsh;
import com.hdsx.zxyh.entity.Gcysjung;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BggldjshMapper {

    List<Bggldjsh> getHtDjshInfoByBm(Map<String, String> param);

    int addDjshMxForGcys(Bggldjsh bggldjsh);

    int addDjshForGcys(Bggldjsh bggldjsh);

    int delDjshMxByDjbh(String djbh);

    int editDjshForGcys(Bggldjsh bggldjsh);

    int delDjshMxForGcys(List<String> l);

    int delDjshForGcys(List<String> l);

    Bggldjsh getDjshInfoByDjbh(String djbh);

    List<Bggldjsh> getDjshList(Map<String, String> param);

    int spDjshForGcys(Map<String, Object> param);

    List<Map<String, String>> getHtInfoByZmh(String zmh);
}
