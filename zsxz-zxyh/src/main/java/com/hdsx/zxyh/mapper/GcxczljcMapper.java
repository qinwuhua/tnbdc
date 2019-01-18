package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Gcxczljc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GcxczljcMapper {

    List<Gcxczljc> getGcxczljc();

    int addGcxczljc(Gcxczljc gcxczljc);

    int updateGcxczljc(Gcxczljc gcxczljc);

    int deleteGcxczljc(String[] ids);
}
