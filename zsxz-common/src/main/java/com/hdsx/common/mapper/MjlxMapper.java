package com.hdsx.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MjlxMapper {

    List<HashMap<String, Object>>  getMjxx(String mjlxbm);

    List<HashMap<String, Object>> getBbxx();
}
