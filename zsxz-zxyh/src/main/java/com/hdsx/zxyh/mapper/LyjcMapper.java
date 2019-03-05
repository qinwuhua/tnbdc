package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface LyjcMapper {

    List<Lyjc> getLyjcAll(HashMap<String, String> paramMap);

    int addLyjc(Lyjc lyjc);

    int addLyjcmxb(List<Lyjcmxb> lyjcmxbs);

    int deleteLyjcmxbByMid(String[] ids);

    int deleteLyjcById(String[] ids);

    List<Lyjcmxb> getLyjcbmxByMid(String id);

    int updateLyjc(Lyjc lyjc);

    int updateLyjcmxb(Lyjcmxb lyjcmxb);

    List<Jczb> getJczbAll(HashMap<String, String> paramMap);

    int addJczb(Jczb jczb);

    int addJczbmxb(List<Jczbmxb> jczbmxbs);

    int deleteJczbmxbByMid(String[] ids);

    int deleteJczbByIds(String[] ids);

    List<Jczbmxb> getJczbmxById(String id);

    int updateJczb(Jczb jczb);

    int updateJczbmxb(Jczbmxb jczbmxb);

    int deleteLyjcmxbByIds(String[] ids);

    int deleteJczbmxByIds(String[] ids);


    List<Lyjcmxb> getLyjcmx(String id);


    List<Jczbmxb> getJczbmx(String id);
}
