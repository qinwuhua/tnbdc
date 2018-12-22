package com.hdsx.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface HtxxMapper {

    List<HashMap<String, Object>> getHtxxAll();

    List<HashMap<String, Object>> getHtxxLyjcAll();

    List<HashMap<String, Object>> getHtgjxxAll();

    List<HashMap<String, Object>> getHtxxYhAll();

}
