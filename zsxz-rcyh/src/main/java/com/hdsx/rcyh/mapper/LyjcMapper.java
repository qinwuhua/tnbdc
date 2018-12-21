package com.hdsx.rcyh.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface LyjcMapper {

    List<HashMap<String, Object>> getLyjcAll();

    List<HashMap<String, Object>> getDjsjHtxx();

    List<HashMap<String, Object>> getDjsjLyjcmx();
}
