package com.hdsx.rcyh.service;

import java.util.HashMap;
import java.util.List;

public interface XccsfxService {

    List<HashMap<String, Object>> selectDay();

    List<HashMap<String, Object>> selectMonth();

    List<HashMap<String, Object>> selectYear();

}

