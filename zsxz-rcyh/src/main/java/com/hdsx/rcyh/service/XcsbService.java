package com.hdsx.rcyh.service;

import java.util.HashMap;
import java.util.List;

public interface XcsbService {
    List<HashMap<String, Object>> getXcsb(int pageNum, int pageSize);
}

