package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Gczfgcjld;
import com.hdsx.zxyh.entity.Gczfzqcwzf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface GczfMapper {


    List<Gczfgcjld> getGcjldList(Map<String, String> param);

    List<Gczfgcjld> getHtXxInfoByBm(Map<String, String> param);

    int addGcjldMxForGczf(Gczfgcjld gczfgcjld);

    int addGcjldForGczf(Gczfgcjld gczfgcjld);

    int delGcjldMxByDjbh(String gcjl_djbh);

    int editGcjldForGczf(Gczfgcjld gczfgcjld);

    int delGcjldMxForGczf(List<String> l);

    int delGcjldForGczf(List<String> l);

    int spGcjldForGczf(Map<String, Object> param);

    List<Gczfzqcwzf> getHtCwInfoByBm(Map<String, String> param);

    Gczfgcjld getGcjldInfoByDjbh(Map<String, String> param);

    List<Gczfzqcwzf> getZqcwzfList(Map<String, String> param);

    Gczfzqcwzf getZqcwzfInfoByZfqh(Map<String, String> param);

    void addZqcwzfMxForGczf(Gczfzqcwzf gczfzqcwzf);

    int addZqcwzfForGczf(Gczfzqcwzf gczfzqcwzf);

    void delZqcwzfMxByDjbh(String zqcwzf_zfqh);

    int editZqcwzfForGczf(Gczfzqcwzf gczfzqcwzf);

    void delZqcwzfMxForGczf(List<String> l);

    int delZqcwzfForGczf(List<String> l);

    int spZqcwzfForGczf(Map<String, Object> param);
}
