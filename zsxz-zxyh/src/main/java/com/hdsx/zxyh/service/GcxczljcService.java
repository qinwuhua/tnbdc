package com.hdsx.zxyh.service;

import com.hdsx.zxyh.entity.Gcxczljc;

import java.util.List;

public interface GcxczljcService {

    List<Gcxczljc> getGcxczljc(int pageNum, int pageSize);

    int addGcxczljc(Gcxczljc gcxczljc);

    int updateGcxczljc(Gcxczljc gcxczljc);

    int deleteGcxczljc(String[] ids);
}
