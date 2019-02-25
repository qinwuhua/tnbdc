package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Xcsb;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface XcsbMapper {
    List<HashMap<String, Object>> getXcsb();

    int insertXcsb(Xcsb xcsb);

}
