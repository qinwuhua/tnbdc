package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Lyjc;
import com.hdsx.zxyh.entity.Lyjcmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface LyjcMapper {

    List<Lyjc> getLyjc(HashMap<String, Object> param);

    int addLyjc(Lyjc lyjc);

    int addLyjcMx(List<Lyjcmx> list);

    int deleteLyjc(String[] ids);

    int deleteLyjcMx(String[] lyjcids);

    int updateLyjc(Lyjc lyjc);

    List<Lyjcmx> selectMx(String id);
}
