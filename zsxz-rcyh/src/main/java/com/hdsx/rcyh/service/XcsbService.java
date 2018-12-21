package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Xcsb;

import java.util.List;

public interface XcsbService {
    int delete(String rwmxId);

    int deletes(String [] rwmxId);

    int insert(Xcsb xcsb);

    List<Xcsb> QueryOne(String rwmxId);
}
