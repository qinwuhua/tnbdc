package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Lhyh;
import com.hdsx.rcyh.entity.LhyhPZ;

import java.util.List;
import java.util.Map;

public interface LhyhService {

    List<Lhyh> getLhyhrwList(Map<String, String> param, int pageNum, int pageSize);

    int insertLhyh(Lhyh lhyh);

    int insertLhyhPZ(LhyhPZ lhyhPZ);

    List<Map> getLhyhPz(String lhry);
}
