package com.hdsx.common.service;

import java.util.HashMap;
import java.util.List;

public interface LxldService {

    /**
     * 通过部门编码获取路段信息
     * @param bmCode 部门编码
     * @return
     */
    List<HashMap<String, Object>> getLd(String bmCode);
}
