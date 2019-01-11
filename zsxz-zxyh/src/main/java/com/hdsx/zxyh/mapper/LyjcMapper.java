package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Lyjc;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface LyjcMapper {

    List<Lyjc> getLyjc(HashMap<String, Object> param);

    int addLyjc(Lyjc lyjc);

    int addLyjcMid(List<HashMap<String, Object>> list);

    int deleteLyjc(String id);

    int deleteLyjcMid(String lyjcid);

    int updateLyjc(Lyjc lyjc);
}
