package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Gcyssqd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface GcysFjyibMapper {

    List<Map<String, String>> getGcysFjylbList(Map<String, String> param);
}
