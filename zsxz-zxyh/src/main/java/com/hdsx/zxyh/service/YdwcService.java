package com.hdsx.zxyh.service;

import com.hdsx.zxyh.entity.Ydjh;
import com.hdsx.zxyh.entity.Ydwc;

import java.util.List;
import java.util.Map;

public interface YdwcService {

    List<Ydjh> getYdwc(int pageNum, int pageSize);

    int addYdwc(Ydwc ydwc);

    int deleteYdwc(String[] ids);

    int updateYdwc(Ydwc ydwc);

    List<Map<String, String>> getZbInfoByHtAndYd(Map<String, String> param);

    List<Map<String, String>> getYdjhHtInfo(String tbdwdm);

    int spYdwc(Map<String, Object> param);
}
