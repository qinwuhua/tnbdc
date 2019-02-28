package com.hdsx.jdwh.service;

import com.hdsx.jdwh.entity.Wxdj;
import com.hdsx.jdwh.entity.Wxys;

import java.util.List;
import java.util.Map;

public interface WxysService {

    List<Wxys> getDjBxdInfo(Map<String, String> param);

    int addWxys(Wxys wxys);

    int editWxys(Wxys wxys);

    int delWxysByDjbhs(List<String> l);

    Wxys getWxysInfoByIDjbh(String djbh);

    List<Wxys> getWxysList(Map<String, String> param, int pageNum, int pageSize);

    int spWxysByDjbh(Map<String, Object> param);

    int getYdjCount(Wxys wxys);

    int getYysCount(Wxys wxys);
}
