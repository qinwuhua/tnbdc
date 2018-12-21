package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Lyjc;

import java.util.HashMap;
import java.util.List;

public interface LyjcService {

    List<HashMap<String, Object>> getLyjcAll();

    List<HashMap<String, Object>> getDjsjHtxx();

    List<HashMap<String, Object>> getDjsjLyjcmx();

    List<HashMap<String, String>> addLyjc(Lyjc lyjc);

    boolean deleteLyjc(String id);

    List<HashMap<String, String>> updateLyjc(Lyjc lyjc);

    List<HashMap<String, Object>> getLyjcbmxById(String id);
}
