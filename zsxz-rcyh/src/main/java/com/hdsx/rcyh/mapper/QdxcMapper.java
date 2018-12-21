package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Qdxc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QdxcMapper {

    int delete(String xcrwId);

    int deletes(String [] xcrwId);

    int insert(Qdxc record);

    List<Qdxc> QueryOne(String xcrwId);

}