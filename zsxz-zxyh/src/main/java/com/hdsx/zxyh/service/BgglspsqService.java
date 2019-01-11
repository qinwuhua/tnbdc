package com.hdsx.zxyh.service;


import com.hdsx.zxyh.entity.Bgglspsqs;
import com.hdsx.zxyh.entity.Gcyssqd;

import java.util.List;
import java.util.Map;

public interface BgglspsqService {

    int addSpsqsForBggl(Bgglspsqs bgglspsqs);

    int editSpsqsForBggl(Bgglspsqs bgglspsqs);

    int delSpsqsForBggl(List<String> l);

    Bgglspsqs getSpsqsInfoByDjbh(String pmmtgcspsqs_djbh);

    List<Bgglspsqs> getSpsqdList(Map<String, String> param, int pageNum, int pageSize);

    int spSpsqsForBggl(Map<String, Object> param);
}
