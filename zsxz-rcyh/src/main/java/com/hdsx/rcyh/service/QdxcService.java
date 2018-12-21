package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Qdxc;

import java.util.List;

public interface QdxcService {

    int delete(String xcrwId);

    int deletes(String [] xcrwIds);

    int insert(Qdxc record);

    List<Qdxc> QueryOne(String xcrwId);

}
