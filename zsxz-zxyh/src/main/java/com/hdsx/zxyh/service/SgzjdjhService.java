package com.hdsx.zxyh.service;

import com.hdsx.zxyh.entity.Sgzjdjh;

import java.util.List;
import java.util.Map;

public interface SgzjdjhService {

    List<Sgzjdjh> getSgzjdjh(int pageNum, int pageSize);

    int addSgzjdjh(Sgzjdjh sgzjdjh);

    int updateSgzjdjh(Sgzjdjh sgzjdjh);

    int deleteSgzjdjh(List ids);

    int spSgzjdjh(Map<String, Object> param);
}
