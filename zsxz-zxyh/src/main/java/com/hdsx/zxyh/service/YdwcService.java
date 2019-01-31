package com.hdsx.zxyh.service;

import com.hdsx.zxyh.entity.Ydjh;
import com.hdsx.zxyh.entity.Ydwc;

import java.util.List;

public interface YdwcService {

    List<Ydjh> getYdwc(int pageNum, int pageSize);

    int addYdwc(Ydwc ydwc);

    int deleteYdwc(String[] ids);

    int updateYdwc(Ydwc ydwc);
}
