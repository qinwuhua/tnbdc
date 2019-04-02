package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Rcqs;
import com.hdsx.rcyh.entity.RcqsPZ;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface RcqsMapper {

    List<Rcqs> getRcqsrwList(Map<String, String> param);

    int insertRcqs(Rcqs rcqs);

    int insertRcqsPZ(RcqsPZ rcqsPZ);

    List<Map> getRcqsPz(String qsry);
}
