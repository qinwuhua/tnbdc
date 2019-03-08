package com.hdsx.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface ZlglkhxzMapper {

    List<HashMap<String,Object>> getAll();

    List<HashMap<String,Object>> GetAllByGcxm(HashMap<String,String> paramMap);
}
