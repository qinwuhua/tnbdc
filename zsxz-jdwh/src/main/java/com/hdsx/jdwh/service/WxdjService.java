package com.hdsx.jdwh.service;

import com.hdsx.jdwh.entity.Gzbx;
import com.hdsx.jdwh.entity.Wxdj;

import java.util.List;
import java.util.Map;

public interface WxdjService {


    List<Wxdj> getBxdInfo(Map<String, String> param);

    int addWxdj(Wxdj wxdj);

    int editWxdj(Wxdj wxdj);

    int delWxdjByDjbhs(List<String> l);

    Wxdj getWxdjInfoByIDjbh(String djbh);

    List<Wxdj> getWxdjList(Map<String, String> param, int pageNum, int pageSize);

    int getWdjCount(Wxdj wxdj);

    Wxdj getWxdjInfoByWxdh(String djbh);
}
