package com.hdsx.zxyh.service;


import com.hdsx.zxyh.entity.Gczfgcjld;

import java.util.List;
import java.util.Map;

public interface GczfService {


    List<Gczfgcjld> getGcjldList(Map<String, String> param, int pageNum, int pageSize);

    List<Gczfgcjld> getHtXxInfoByBm(Map<String, String> param);

    int addGcjldForGczf(Gczfgcjld gczfgcjld);

    int editGcjldForGczf(Gczfgcjld gczfgcjld);

    int delGcjldForGczf(List<String> l);

    int spGcjldForGczf(Map<String, Object> param);
}
