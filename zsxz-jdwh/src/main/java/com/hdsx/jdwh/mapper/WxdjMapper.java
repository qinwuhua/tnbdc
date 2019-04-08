package com.hdsx.jdwh.mapper;

import com.hdsx.jdwh.entity.Gzbx;
import com.hdsx.jdwh.entity.Wxdj;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface WxdjMapper {


    List<Wxdj> getBxdInfo(Map<String, String> param);

    int addWxdj(Wxdj wxdj);

    int editWxdj(Wxdj wxdj);

    int delWxdjByDjbhs(List<String> l);

    Wxdj getWxdjInfoByIDjbh(String djbh);

    List<Wxdj> getWxdjList(Map<String, String> param);

    int updateWxdjZt(Wxdj wxdj);

    int updateWxdjZtByList(List<String> l);

    int getWdjCount(Wxdj wxdj);

    Wxdj getWxdjInfoByWxdh(String djbh);
}
