package com.hdsx.zxyh.service;


import com.hdsx.zxyh.entity.Jczb;
import com.hdsx.zxyh.entity.Jczbmxb;
import com.hdsx.zxyh.entity.Lyjc;
import com.hdsx.zxyh.entity.Lyjcmxb;

import java.util.HashMap;
import java.util.List;

public interface LyjcService {

    List<Lyjc> getLyjcAll(HashMap<String,String> paramMap , int pageNum, int pageSize);

    int addLyjc(Lyjc lyjc);

    int deleteLyjc(String[] ids);

    int updateLyjc(Lyjc lyjc);

    List<Lyjcmxb> getLyjcbmxByMid(String id);

    List<Jczb> getJczbAll(HashMap<String,String> paramMap , int pageNum, int pageSize);

    int addJczb(Jczb jczb);

    int deleteJczb(String[] ids);

    int updateJczb(Jczb jczb);

    List<Jczbmxb> getJczbmxById(String id);

    int deleteLyjcmxbByIds(String[] ids);

    int deleteJczbmxByIds(String[] ids);
}
