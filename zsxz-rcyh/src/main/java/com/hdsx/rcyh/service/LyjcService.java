package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Lyjc;

import java.util.HashMap;
import java.util.List;

public interface LyjcService {

    List<HashMap<String,Object>> getLyjcAll();

    List<HashMap<String, Object>> getDjsjHtxx();

    List<HashMap<String, Object>> getDjsjLyjcmx();

    boolean addLyjc(Lyjc lyjc);
}
