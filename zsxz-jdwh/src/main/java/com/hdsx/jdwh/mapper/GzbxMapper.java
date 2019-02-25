package com.hdsx.jdwh.mapper;

import com.hdsx.jdwh.entity.Gzbx;
import com.hdsx.jdwh.entity.Rcxj;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GzbxMapper {

    List<Gzbx> getSbInfo(Map<String, String> param);

    int addGzbx(Gzbx rcxj);

    int editGzbx(Gzbx rcxj);

    int delGzbxByDjbhs(List<String> l);

    Gzbx getGzbxInfoByIDjbh(String djbh);

    List<Gzbx> getGzbxList(Map<String, String> param);
}
