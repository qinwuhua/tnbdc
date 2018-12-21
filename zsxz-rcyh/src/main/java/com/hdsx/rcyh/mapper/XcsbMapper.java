package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Xcsb;

import java.util.List;

public interface XcsbMapper {
    int delete(String rwmxId);

    int deletes(String [] rwmxId);

    int insert(Xcsb xcsb);

    List<Xcsb> QueryOne(String rwmxId);

    int update(Xcsb xcsb);
}