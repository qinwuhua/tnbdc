package com.hdsx.yjqx.service;

import com.hdsx.yjqx.entity.Yjqx;

import java.util.HashMap;
import java.util.List;

public interface YjqxService {

    int addYjqxgc(Yjqx yjqx);

    int editYjqxgc(Yjqx yjqx);

    int delYjqxgcByIds(String[] ids);

    List<Yjqx> getYjqxgcList(HashMap<String, String> paramMap, int pageNum, int pageSize);
}
