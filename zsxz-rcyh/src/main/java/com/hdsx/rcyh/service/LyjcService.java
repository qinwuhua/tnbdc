package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Jczb;
import com.hdsx.rcyh.entity.Lyjc;

import java.util.HashMap;
import java.util.List;

public interface LyjcService {

    List<HashMap<String, Object>> getLyjcAll(int pageNum, int pageSize);

    List<HashMap<String, String>> addLyjc(Lyjc lyjc);

    boolean deleteLyjc(String id);

    List<HashMap<String, String>> updateLyjc(Lyjc lyjc);

    List<HashMap<String, Object>> getLyjcbmxById(String id);

    List<HashMap<String, Object>> getJczbAll(int pageNum, int pageSize);

    List<HashMap<String, String>> addJczb(Jczb jczb);

    boolean deleteJczb(String id);

    List<HashMap<String, String>> updateJczb(Jczb jczb);

    List<HashMap<String, Object>> getJczbmxById(String id);

    List<HashMap<String, String>> getFilesDataById(String id);

}
