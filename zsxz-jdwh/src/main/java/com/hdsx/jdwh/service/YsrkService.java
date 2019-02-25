package com.hdsx.jdwh.service;

import com.hdsx.jdwh.entity.Rcxj;
import com.hdsx.jdwh.entity.Ysrk;

import java.util.List;
import java.util.Map;

public interface YsrkService {

    List<Map<String,String>> getCkInfo(Map<String, String> param);

    List<Map<String, String>> getWxdhInfo(Map<String, String> param);

    List<Map<String, String>> getHtBjInfo(Map<String, String> param);

    List<Map<String, String>> getWxBjInfo(Map<String, String> param);

    int addYsrk(Ysrk ysrk);

    int editYsrk(Ysrk ysrk);

    int delYsrkBydjbhs(List<String> l);

    Ysrk getYsrkInfoByDjbh(String djbh);

    List<Ysrk> getYsrkList(Map<String, String> param, int pageNum, int pageSize);
}
