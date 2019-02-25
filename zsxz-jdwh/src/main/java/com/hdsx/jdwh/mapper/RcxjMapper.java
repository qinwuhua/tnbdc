package com.hdsx.jdwh.mapper;

import com.hdsx.jdwh.entity.Rcxj;
import com.hdsx.jdwh.entity.Rcxjmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface RcxjMapper {

    List<Rcxj> getXjType(Map<String, String> param);

    int addRcxj(Rcxj rcxj);

    int addRcxjMx(Rcxj rcxj);

    int editRcxj(Rcxj rcxj);

    int delRcxjMx(Rcxj rcxj);

    int delRcxjByIds(List<String> l);

    int delRcxjMxByIds(List<String> l);

    Rcxj getRcxjInfoById(String id);

    List<Rcxj> getRcxjList(Map<String, String> param);

    List<Rcxjmx> getRcxjmxByPid(String mx_pid);
}
