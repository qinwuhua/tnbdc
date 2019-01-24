package com.hdsx.common.mapper;

import com.hdsx.common.entity.Htxx;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface HtxxMapper {

    List<Htxx> getHtxxRelateAll(HashMap<String, String> paramMap);

}
