package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Bgglspsqs;
import com.hdsx.zxyh.entity.Gcyssqd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BgglspsqMapper {

    int addSpsqsForBggl(Bgglspsqs bgglspsqs);

    int editSpsqsForBggl(Bgglspsqs bgglspsqs);

    int delSpsqsForBggl(List<String> l);

    Bgglspsqs getSpsqsInfoByDjbh(String pmmtgcspsqs_djbh);

    List<Bgglspsqs> getSpsqdList(Map<String, String> param);

    int spSpsqsForBggl(Map<String, Object> param);
}
