package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Jczb;
import com.hdsx.rcyh.entity.Jczbmxb;
import com.hdsx.rcyh.entity.Lyjc;
import com.hdsx.rcyh.entity.Lyjcmxb;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface LyjcMapper {

    List<HashMap<String, Object>> getLyjcAll();

    List<HashMap<String, Object>> getDjsjHtxx();

    List<HashMap<String, Object>> getDjsjLyjcmx();

    boolean addFiles(Map<String, String> fileMap);

    boolean addLyjc(Lyjc lyjc);

    boolean addLyjcmxb(Lyjcmxb lyjcmxb);

    List<HashMap<String, String>> getFilesDataById(String id);

    boolean deleteFilesDataById(String id);

    boolean deleteLyjcmxbById(String id);

    boolean deleteLyjcById(String id);

    List<HashMap<String, Object>> getLyjcbmxById(String id);

    boolean updateLyjc(Lyjc lyjc);

    List<HashMap<String, Object>> getJczbAll();

    boolean addJczb(Jczb jczb);

    boolean addJczbmxb(Jczbmxb jczbmxb);

    boolean deleteJczbmxbById(String id);

    boolean deleteJczbById(String id);

    List<HashMap<String, Object>> getJczbmxById(String id);

    boolean updateJczb(Jczb jczb);
}
