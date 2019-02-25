package com.hdsx.jdwh.service;

import com.hdsx.jdwh.entity.Fjwx;
import com.hdsx.jdwh.entity.Fjwxjs;

import java.util.List;
import java.util.Map;

public interface FjwxjsService {

    List<Map<String, String>> getFjwxdInfByDw(Map<String, String> param);

    List<Map<String, String>> getFjwxdBjInfByDw(Map<String, String> param);

    int addFjwxjs(Fjwxjs fjwxjs);

    int editFjwxjs(Fjwxjs fjwxjs);

    int delFjwxjsBydjbhs(List<String> l);

    Fjwxjs getFjwxjsInfoById(String id);

    List<Fjwxjs> getFjwxjsList(Map<String, String> param, int pageNum, int pageSize);
}
