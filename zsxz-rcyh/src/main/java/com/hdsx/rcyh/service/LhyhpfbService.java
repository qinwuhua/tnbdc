package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Lhyhpfb;
import com.hdsx.rcyh.entity.Lhyhpfbmx;

import java.util.List;
import java.util.Map;

public interface LhyhpfbService {
    int insert(Lhyhpfb lhyhpfb);

/*    int insertzb(Lhyhpfbmx lhyhpfbmx);*/

    int delete(String lhyhdjbh);

    int deletezb(String lhyhid);

    int update(Lhyhpfb lhyhpfb);

/*    int updatezb(Lhyhpfbmx lhyhpfbmx);*/

    List<Lhyhpfb> getLhyhrwList(Map<String, String> param, int pageNum, int pageSize);

    int updatezt(String lhyhid, String lhyhzt);
}
