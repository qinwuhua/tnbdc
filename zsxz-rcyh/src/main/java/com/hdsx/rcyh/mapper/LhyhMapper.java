package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Lhyh;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface LhyhMapper {

    List<Lhyh> getLhyhrwList(Map<String, String> param);
}
