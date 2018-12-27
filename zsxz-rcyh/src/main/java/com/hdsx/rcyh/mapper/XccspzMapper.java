package com.hdsx.rcyh.mapper;


import com.hdsx.rcyh.entity.Xccspz;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface XccspzMapper {
    int delete(String xccsId);

/*    int deletes(String[] xccsId);*/

    int insert(Xccspz xccspz);

    List<Xccspz> QueryOne(String xccsId);

    int update(Xccspz xccspz);

    List<HashMap<String, Object>> getXccspzAll();
}