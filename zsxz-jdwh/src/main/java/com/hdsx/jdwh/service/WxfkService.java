package com.hdsx.jdwh.service;

import com.hdsx.jdwh.entity.Rcxj;
import com.hdsx.jdwh.entity.Wxfk;
import com.hdsx.jdwh.entity.Wxfkjsmx;

import java.util.List;
import java.util.Map;

public interface WxfkService {

    int addWxfk(Wxfk wxfk);

    int editWxfk(Wxfk wxfk);

    int delWxfkByDjbhs(List<String> l);

    Wxfk getWxfkInfoByDjbh(String djbh);

    List<Wxfk> getWxfkList(Map<String, String> param, int pageNum, int pageSize);

    List<Wxfkjsmx> getWxfyChooseList(Map<String, String> param);

    List<Map<String, String>> getFpInfo();
}
