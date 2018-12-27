package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Qsrwd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QsrwdMapper {
    int insert(Qsrwd qsrwd);



    int update(Qsrwd qsrwd);

    List<Qsrwd> getQsrwdList(Map<String, String> param);

    int delete(String qsrwdid);
}
