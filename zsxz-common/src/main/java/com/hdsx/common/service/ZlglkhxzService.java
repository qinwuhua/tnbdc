package com.hdsx.common.service;

import java.util.HashMap;
import java.util.List;

public interface ZlglkhxzService {
    List<HashMap<String, Object>> getAll();

    List<HashMap<String, Object>> GetAllByGcxm(HashMap<String,String> paramMap);
}
