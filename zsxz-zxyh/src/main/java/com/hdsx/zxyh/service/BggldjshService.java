package com.hdsx.zxyh.service;


import com.hdsx.zxyh.entity.Bggldjsh;

import java.util.List;
import java.util.Map;

public interface BggldjshService {

    List<Bggldjsh> getHtDjshInfoByBm(Map<String, String> param);

    int addDjshForGcys(Bggldjsh bggldjsh);

    int editDjshForGcys(Bggldjsh bggldjsh);

    int delDjshForGcys(List<String> l);

    Bggldjsh getDjshInfoByDjbh(String djbh);

    List<Bggldjsh> getDjshList(Map<String, String> param, int pageNum, int pageSize);

    int spDjshForGcys(Map<String, Object> param);

    List<Map<String, String>> getHtInfoByZmh(String zmh);
}
