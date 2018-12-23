package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Jczb;
import com.hdsx.rcyh.entity.Jczbmxb;
import com.hdsx.rcyh.entity.Lyjc;
import com.hdsx.rcyh.entity.Lyjcmxb;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface LyjcMapper {

    List<HashMap<String, Object>> getLyjcAll();

    boolean addLyjc(Lyjc lyjc);

    boolean addLyjcmxb(Lyjcmxb lyjcmxb);

    boolean deleteLyjcmxbById(String id);

    boolean deleteLyjcById(String id);

    List<HashMap<String, Object>> getLyjcbmxById(String id);

    boolean updateLyjc(Lyjc lyjc);

    boolean updateLyjcmxb(Lyjcmxb lyjcmxb);

    List<HashMap<String, Object>> getJczbAll();

    boolean addJczb(Jczb jczb);

    boolean addJczbmxb(Jczbmxb jczbmxb);

    boolean deleteJczbmxbById(String id);

    boolean deleteJczbById(String id);

    List<HashMap<String, Object>> getJczbmxById(String id);

    boolean updateJczb(Jczb jczb);

    boolean updateJczbmxb(Jczbmxb jczbmxb);
}
