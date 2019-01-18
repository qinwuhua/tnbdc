package com.hdsx.zxyh.service;

import com.hdsx.zxyh.entity.Kgsqd;

import java.util.List;

public interface KgsqdService {

    List<Kgsqd> getAll(int pageNum, int pageSize);

    int addKgsqd(Kgsqd kgsqd);

    int updateKgsqd(Kgsqd kgsqd);

    int deleteKgsqd(String[] djbhs);
}
