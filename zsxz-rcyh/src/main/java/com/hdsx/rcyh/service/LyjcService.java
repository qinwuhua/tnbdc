package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Jczb;
import com.hdsx.rcyh.entity.Lyjc;

import java.util.HashMap;
import java.util.List;

public interface LyjcService {

    List<HashMap<String, Object>> getLyjcAll(int pageNum, int pageSize);

    boolean addLyjc(Lyjc lyjc);

    boolean deleteLyjc(String id);

    boolean updateLyjc(Lyjc lyjc);

    List<HashMap<String, Object>> getLyjcbmxById(String id);

    List<HashMap<String, Object>> getJczbAll(int pageNum, int pageSize);

    boolean addJczb(Jczb jczb);

    boolean deleteJczb(String id);

    boolean updateJczb(Jczb jczb);

    List<HashMap<String, Object>> getJczbmxById(String id);

}
