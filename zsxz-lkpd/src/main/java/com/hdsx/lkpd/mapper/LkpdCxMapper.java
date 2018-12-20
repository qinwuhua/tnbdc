package com.hdsx.lkpd.mapper;

import com.hdsx.lkpd.entity.Lkdcfb;
import com.hdsx.lkpd.entity.Qmldb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface LkpdCxMapper {

    List<Qmldb> getMxbForLksjcx(Map<String, String> param);

}
