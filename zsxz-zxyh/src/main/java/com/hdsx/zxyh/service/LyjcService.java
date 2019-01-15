package com.hdsx.zxyh.service;

import com.hdsx.zxyh.entity.Lyjc;

import java.util.List;

public interface LyjcService {

    List<Lyjc> getLyjc(String htbh, String gldw,int pageNum, int pageSize);

    int addLyjc(Lyjc lyjc);

    int deleteLyjc(String[] ids);

    int updateLyjc(Lyjc lyjc);
}
