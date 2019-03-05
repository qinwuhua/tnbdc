package com.hdsx.zxyh.service;

import com.hdsx.zxyh.entity.Ybgc;

import java.util.List;
import java.util.Map;

public interface YbgcService {

    List<Ybgc> getYbgc(int pageNum, int pageSize);

    int addYbgc(Ybgc ybgc);

    int deleteYbgc(String[] ids);

    int updateYbgc(Ybgc ybgc);

    int spYbgc(Map<String, Object> param);
}
