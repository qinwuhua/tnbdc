package com.hdsx.zxyh.utils;

import java.util.UUID;

public class UuidUtil {

    /**
     * 获取uuid
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
