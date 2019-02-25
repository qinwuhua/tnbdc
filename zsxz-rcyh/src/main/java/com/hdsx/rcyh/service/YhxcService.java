package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Qdxc;

import java.util.HashMap;
import java.util.List;


public interface YhxcService {
    int insertYhxc(Qdxc qdxc);

     List<Qdxc> selectJdlx(HashMap<String, String> param, int pageNum, int pageSize);
}
