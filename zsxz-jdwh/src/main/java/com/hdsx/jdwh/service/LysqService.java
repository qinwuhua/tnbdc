package com.hdsx.jdwh.service;

import com.hdsx.jdwh.entity.Lysq;
import com.hdsx.jdwh.entity.Ysrk;

import java.util.List;
import java.util.Map;

public interface LysqService {

    List<Map<String, String>> getBjLyInfo(Map<String, String> param);

    int addLysq(Lysq lysq);

    int editLysq(Lysq lysq);

    int delLysqBydjbhs(List<String> l);

    Lysq getLysqInfoByDjbh(String djbh);

    List<Lysq> getLysqList(Map<String, String> param, int pageNum, int pageSize);
}
