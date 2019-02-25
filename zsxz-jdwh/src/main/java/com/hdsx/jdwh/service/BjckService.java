package com.hdsx.jdwh.service;

import com.hdsx.jdwh.entity.Bjck;
import com.hdsx.jdwh.entity.Bjckmx;
import com.hdsx.jdwh.entity.Lysq;

import java.util.List;
import java.util.Map;

public interface BjckService {

    List<Map<String, String>> getBjLySqdInfo(Map<String, String> param);

    List<Bjckmx> getBjInfoByLySqd(Map<String, String> param);

    int addBjck(Bjck bjck);

    int editBjck(Bjck bjck);

    int delBjckBydjbhs(List<String> l);

    Bjck getBjckInfoByDjbh(String djbh);

    List<Bjck> getBjckList(Map<String, String> param, int pageNum, int pageSize);
}
