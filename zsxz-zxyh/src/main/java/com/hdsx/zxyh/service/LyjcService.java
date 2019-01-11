package com.hdsx.zxyh.service;

import com.hdsx.zxyh.entity.Lyjc;

import java.util.List;

public interface LyjcService {

    List<Lyjc> getLyjc(String htbh, String gldw);

    int addLyjc(Lyjc lyjc);

    int deleteLyjc(String id);

    int updateLyjc(Lyjc lyjc);
}
