package com.hdsx.jdwh.service;

import com.hdsx.jdwh.entity.Rcxj;
import com.hdsx.jdwh.entity.Wxfk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RcxjService {


    List<Rcxj> getXjType(Map<String, String> param);

    int addRcxj(Rcxj rcxj);

    int editRcxj(Rcxj rcxj);

    int delRcxjByIds(List<String> l);

    Rcxj getRcxjInfoById(String id);

    List<Rcxj> getRcxjList(Map<String, String> param, int pageNum, int pageSize);

}
