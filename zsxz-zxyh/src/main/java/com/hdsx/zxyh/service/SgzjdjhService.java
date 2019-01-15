package com.hdsx.zxyh.service;

import com.hdsx.zxyh.entity.Sgzjdjh;

import java.util.List;

public interface SgzjdjhService {

    List<Sgzjdjh> getSgzjdjh(int pageNum, int pageSize);

    int addSgzjdjh(Sgzjdjh sgzjdjh);

    int updateSgzjdjh(Sgzjdjh sgzjdjh);

    int deleteSgzjdjh(String[] ids);
}
