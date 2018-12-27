package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Sgjh;
import com.hdsx.rcyh.entity.Sgjhsbmx;
import com.hdsx.rcyh.entity.Sgjhwc;
import com.hdsx.rcyh.entity.Sgjhwcmx;

import java.util.HashMap;
import java.util.List;

public interface SgjhService {

    List<Sgjh> getSgjhAll(HashMap<String,String>paramMap, int pageNum, int pageSize);

    int addSgjh(Sgjh sgjh);

    int upateSgjh(Sgjh sgjh);

    int deleteSgjh(String[] ids);

    List<Sgjhsbmx> getSgjhmxById(String id);

    List<HashMap<String, Object>> getWcSgjhAll(HashMap<String,String>paramMap, int pageNum, int pageSize);

    int addWcSgjh(Sgjhwc sgjhwc);

    int upateWcsgjh(Sgjhwc sgjhwc);

    int deleteWcSgjh(String[] ids);

    List<Sgjhwcmx> getWcSgjhmxById(String id);

    int deleteWcSgjhmxByIds(String[] ids);

    int deleteSgjhmxByIds(String[] ids);

}
