package com.hdsx.rcyh.mapper;


import com.hdsx.rcyh.entity.Xccspz;

import java.util.List;

public interface XccspzMapper {
    int delete(String xccsId);

    int deletes(String[] xccsId);

    int insert(Xccspz xccspz);

    List<Xccspz> QueryOne(String xccsId);

    int update(Xccspz xccspz);
}