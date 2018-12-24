package com.hdsx.lkpd.mapper;

import com.hdsx.lkpd.entity.Lkdcfb;
import com.hdsx.lkpd.entity.Qmldb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface LkpdDrMapper {

    List<Qmldb> getLksjdrByDclx(Map<String,String> param);

    List<Lkdcfb> getLksjdrfb(String dcid);

    double getSci(Qmldb qm);

    double getBci(Qmldb qm);

    double getTci(Qmldb qm);

    double getPci(Qmldb qm);

    List<Map<String, String>> getLksjdrByJclx(Map<String, String> param);
}
