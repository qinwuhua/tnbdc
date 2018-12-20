package com.hdsx.lkpd.mapper;

import com.hdsx.lkpd.entity.Qmldb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface LkpdDrMapper {

    List<Qmldb> getLksjdrBylx(Map<String,String> param);
}
