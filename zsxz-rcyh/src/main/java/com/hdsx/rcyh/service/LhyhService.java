package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Lhyh;

import java.util.List;
import java.util.Map;

public interface LhyhService {

    List<Lhyh> getLhyhrwList(Map<String, String> param, int pageNum, int pageSize);
}
