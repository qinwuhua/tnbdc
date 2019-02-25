package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Xcsb;

import java.util.HashMap;
import java.util.List;

public interface XcsbService {
    List<HashMap<String, Object>> getXcsb(int pageNum, int pageSize);

    int insertXcsb(Xcsb xcsb);
}

