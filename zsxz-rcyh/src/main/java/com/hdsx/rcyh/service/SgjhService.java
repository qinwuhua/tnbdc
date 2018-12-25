package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Sgjh;
import com.hdsx.rcyh.entity.Sgjhwc;

import java.util.HashMap;
import java.util.List;

public interface SgjhService {

    List<Sgjh> getSgjhAll(HashMap<String,String>paramMap, int pageNum, int pageSize);

    int addSgjh(Sgjh sgjh);

    int upateSgjh(Sgjh sgjh);

    int deleteSgjh(String id);

    List<HashMap<String, Object>> getSgjhmxById(String id);

    List<HashMap<String, Object>> getWcSgjhAll(HashMap<String,String>paramMap, int pageNum, int pageSize);

    int addWcSgjh(Sgjhwc sgjhwc);

    int upateWcsgjh(Sgjhwc sgjhwc);

    int deleteWcSgjh(String id);

    List<HashMap<String, Object>> getWcSgjhmxById(String id);

}
