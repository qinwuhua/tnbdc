package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Gczfgcjld;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface GczfMapper {


    List<Gczfgcjld> getGcjldList(Map<String, String> param);

    List<Gczfgcjld> getHtXxInfoByBm(Map<String, String> param);

    int addGcjldMxForGczf(Gczfgcjld gczfgcjld);

    int addGcjldForGczf(Gczfgcjld gczfgcjld);

    int delGcjldByDjbh(String gcjl_djbh);

    int editGcjldForGczf(Gczfgcjld gczfgcjld);

    int delGcjldMxForGczf(List<String> l);

    int delGcjldForGczf(List<String> l);

    int spGcjldForGczf(Map<String, Object> param);
}
