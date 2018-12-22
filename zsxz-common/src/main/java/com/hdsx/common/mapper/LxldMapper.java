package com.hdsx.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface LxldMapper {

    List<HashMap<String, Object>> getLd(String bmCode);
}
