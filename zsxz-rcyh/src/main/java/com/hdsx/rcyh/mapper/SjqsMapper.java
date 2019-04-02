package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Sjqs;
import com.hdsx.rcyh.entity.SjqsPZ;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface SjqsMapper {


    List<Sjqs> getSjqsrwList(Map<String, String> param);

    int insertSjqs(Sjqs sjqs);

    int insertSjqsPZ(SjqsPZ sjqsPZ);

    List<Map> getSjqsPz(String qsry);

}
