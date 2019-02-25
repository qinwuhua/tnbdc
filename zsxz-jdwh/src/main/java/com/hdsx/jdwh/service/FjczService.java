package com.hdsx.jdwh.service;

import com.hdsx.jdwh.entity.Fjcz;
import com.hdsx.jdwh.entity.Fjwxjs;

import java.util.List;
import java.util.Map;

public interface FjczService {

    int addFjcz(Fjcz fjcz);

    int editFjcz(Fjcz fjcz);

    int delFjczByDjbhs(List<String> l);

    Fjcz getFjczInfoByDjbh(String djbh);

    List<Fjcz> getFjczList(Map<String, String> param, int pageNum, int pageSize);

    int spFjczByDjbh(Map<String, Object> param);
}
