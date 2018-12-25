package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Jczb;
import com.hdsx.rcyh.entity.Lyjc;

import java.util.HashMap;
import java.util.List;

public interface LyjcService {

    List<Lyjc> getLyjcAll(HashMap<String,String> paramMap ,int pageNum, int pageSize);

    int addLyjc(Lyjc lyjc);

    int deleteLyjc(String id);

    int updateLyjc(Lyjc lyjc);

    List<HashMap<String, Object>> getLyjcbmxById(String id);

    List<Jczb> getJczbAll(HashMap<String,String> paramMap ,int pageNum, int pageSize);

    int addJczb(Jczb jczb);

    int deleteJczb(String id);

    int updateJczb(Jczb jczb);

    List<HashMap<String, Object>> getJczbmxById(String id);

}
