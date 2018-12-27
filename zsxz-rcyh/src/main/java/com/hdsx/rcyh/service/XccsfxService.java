package com.hdsx.rcyh.service;

import java.util.HashMap;
import java.util.List;

public interface XccsfxService {

    List<HashMap<String, Object>> selectDay(int pageNum, int pageSize);

    List<HashMap<String, Object>> selectMonth(int pageNum, int pageSize);

    List<HashMap<String, Object>> selectYear(int pageNum, int pageSize);

}

