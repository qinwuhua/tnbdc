package com.hdsx.zxyh.service;

import com.hdsx.zxyh.entity.Ybgc;

import java.util.List;

public interface YbgcService {

    List<Ybgc> getYbgc(int pageNum, int pageSize);

    int addYbgc(Ybgc ybgc);

    int deleteYbgc(String[] ids);

    int updateYbgc(Ybgc ybgc);
}
