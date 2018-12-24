package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Xccspz;

import java.util.HashMap;
import java.util.List;

public interface XccspzService {

    int delete(String xccsId);

    int deletes(String[] xccsId);

    int insert(Xccspz xccspz);

    List<Xccspz> QueryOne(String xccsId);

    int update(Xccspz xccspz);


    List<HashMap<String, Object>> getXccspzAll(int pageNum, int pageSize);
}
