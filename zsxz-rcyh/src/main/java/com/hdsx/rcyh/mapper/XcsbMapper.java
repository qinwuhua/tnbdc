package com.hdsx.rcyh.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface XcsbMapper {
    List<HashMap<String, Object>> getXcsb();
}
