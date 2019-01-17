package com.hdsx.zxyh.service;

import com.hdsx.zxyh.entity.Ydjh;

import java.util.List;

public interface YdjhService {

    List<Ydjh> getYdjh(int pageNum, int pageSize);

    int addYdjh(Ydjh ydjh);

    int deleteYdjh(String[] ids);

    int updateYdjh(Ydjh ydjh);
}
