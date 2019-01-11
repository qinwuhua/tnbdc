package com.hdsx.zxyh.service;


import com.hdsx.zxyh.entity.Gcyssqd;
import com.hdsx.zxyh.entity.Gczfgcjld;
import com.hdsx.zxyh.entity.Gczfzqcwzf;

import java.util.List;
import java.util.Map;

public interface GcysSqdService {


    List<Gcyssqd> getGcyssqdList(Map<String, String> param, int pageNum, int pageSize);

    Gcyssqd getGcyssqdInfoBySqbh(Map<String, String> param);

    int addGcyssqdForGcys(Gcyssqd gcyssqd);

    int editGcyssqdForGcys(Gcyssqd gcyssqd);

    int delGcyssqdForGcys(List<String> l);

    int spGcyssqdForGcys(Map<String, Object> param);
}
