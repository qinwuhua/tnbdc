package com.hdsx.zxyh.service;


import com.hdsx.zxyh.entity.Gczfgcjld;
import com.hdsx.zxyh.entity.Gczfzqcwzf;
import com.hdsx.zxyh.entity.Gczfzqcwzfmx;

import java.util.List;
import java.util.Map;

public interface GczfService {


    List<Gczfgcjld> getGcjldList(Map<String, String> param, int pageNum, int pageSize);

    List<Gczfgcjld> getHtXxInfoByBm(Map<String, String> param);

    int addGcjldForGczf(Gczfgcjld gczfgcjld);

    int editGcjldForGczf(Gczfgcjld gczfgcjld);

    int delGcjldForGczf(List<String> l);

    int spGcjldForGczf(Map<String, Object> param);

    List<Gczfzqcwzf> getHtCwInfoByBm(Map<String, String> param);

    Gczfgcjld getGcjldInfoByDjbh(Map<String, String> param);

    List<Gczfzqcwzf> getZqcwzfList(Map<String, String> param, int pageNum, int pageSize);

    Gczfzqcwzf getZqcwzfInfoByZfqh(Map<String, String> param);

    int addZqcwzfForGczf(Gczfzqcwzf gczfzqcwzf);

    int editZqcwzfForGczf(Gczfzqcwzf gczfzqcwzf);

    int delZqcwzfForGczf(List<String> l);

    int spZqcwzfForGczf(Map<String, Object> param);

    List<Gczfzqcwzfmx> createZqzfzsMxList(String htbh);

    List<Gczfzqcwzfmx> getZqzfzsMxList(String htbh);

    List<Gczfzqcwzfmx> getZqcwzfReport(Map<String, String> param);

    List<Map<String, String>> getZqcwzfHzbReport(Map<String, String> param);
}
