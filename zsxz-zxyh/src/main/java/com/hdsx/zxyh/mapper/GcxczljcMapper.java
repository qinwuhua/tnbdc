package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Gcxczljc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GcxczljcMapper {

    List<Gcxczljc> getGcxczljc();

    int addGcxczljc(Gcxczljc gcxczljc);

    int updateGcxczljc(Gcxczljc gcxczljc);

    int deleteGcxczljc(String[] ids);

    int spGcxczljc(Map<String, Object> param);
}
