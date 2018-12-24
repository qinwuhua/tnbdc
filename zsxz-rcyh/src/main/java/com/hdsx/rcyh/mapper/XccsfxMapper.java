package com.hdsx.rcyh.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface XccsfxMapper {


    List<HashMap<String,Object>> selectDay();

    List<HashMap<String,Object>> selectMonth();

    List<HashMap<String,Object>> selectYear();
}
