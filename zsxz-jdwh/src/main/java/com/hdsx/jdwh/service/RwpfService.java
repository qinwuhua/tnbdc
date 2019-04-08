package com.hdsx.jdwh.service;

import com.hdsx.jdwh.entity.Gzbx;

import java.util.List;
import java.util.Map;

public interface RwpfService {


    List<Gzbx> getDfprwdList(Map<String, String> param, int pageNum, int pageSize);

    List<Gzbx> getWxzrrInfo(Map<String, String> param);

    int fpWxrwd(Gzbx gzbx);

    List<Gzbx> getWxrwdList(Map<String, String> param, int pageNum, int pageSize);

    List<Gzbx> getDFPrw(Map<String, String> param);

    List<Gzbx> getYFPrw(Map<String, String> param);

}
