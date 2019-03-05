package com.hdsx.zxyh.service;

import com.hdsx.zxyh.entity.Ydjh;

import java.util.List;
import java.util.Map;

public interface YdjhService {

    List<Ydjh> getYdjh(int pageNum, int pageSize);

    int addYdjh(Ydjh ydjh);

    int deleteYdjh(String[] ids);

    int updateYdjh(Ydjh ydjh);

    List<Map<String,String>> getZjdHtInfo(String tbdwdm);

    int getSfYczYd(Ydjh ydjh);

    int spYdjh(Map<String, Object> param);

    List<Map<String,String>> getZjdHtCzfs(String htbh);
}
