package com.hdsx.tjbb.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TestMapper {

    List<HashMap<String,Object>> test();

}