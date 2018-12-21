package com.hdsx.lkpd.service;

import com.hdsx.lkpd.entity.Qmldb;

import java.util.List;
import java.util.Map;

public interface LkpdDrService {

    List<Qmldb> getLksjdrByDclx(Map<String,String> param, int pageNum, int pageSize);

    List<Qmldb> getLksjdrByJclx(Map<String, String> param, int pageNum, int pageSize);
}
