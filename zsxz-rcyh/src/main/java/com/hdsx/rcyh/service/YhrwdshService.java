package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Yhrwd;

import java.util.List;
import java.util.Map;

public interface YhrwdshService {
    List<Map<String,Object>> queryyhdw();

    List<Map<String,Object>> querygldw();

    int insert(Yhrwd yhrwd);

    int delete(String yhrwddjbh);

    int update(Yhrwd yhrwd);

    List<Yhrwd> getYhrwdshList(Map<String, String> param, int pageNum, int pageSize);
}
