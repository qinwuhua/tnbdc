package com.hdsx.common.mapper;

import com.hdsx.common.entity.Htxx;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface HtxxMapper {

    List<HashMap<String, Object>> getHtxxAll();

    List<HashMap<String, Object>> getHtxxLyjcAll();

    List<HashMap<String, Object>> getHtgjxxAll();

    List<HashMap<String, Object>> getHtxxYhAll();

    List<Htxx> getHtxxRelateAll(HashMap<String, String> paramMap);

    List<Htxx> getZjHtxxRelatedAll(HashMap<String, String> paramMap);
}
