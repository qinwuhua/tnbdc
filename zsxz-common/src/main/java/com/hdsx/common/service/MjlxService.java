package com.hdsx.common.service;

import java.util.HashMap;
import java.util.List;

public interface MjlxService {

    /**
     * 通过枚举类型编码获取枚举编码和名称
     * @param mjlxbm 枚举类型编码 eg：上下行03
     * @return
     */
    List<HashMap<String, Object>> getMjxx(String mjlxbm);
}
