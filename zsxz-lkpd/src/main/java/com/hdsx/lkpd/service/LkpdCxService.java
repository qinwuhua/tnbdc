package com.hdsx.lkpd.service;

import com.hdsx.lkpd.entity.Qmldb;

import java.util.List;
import java.util.Map;

public interface LkpdCxService {

    List<Qmldb> getMxbForLksjcx(Map<String, String> param, int pageNum, int pageSize);

}
