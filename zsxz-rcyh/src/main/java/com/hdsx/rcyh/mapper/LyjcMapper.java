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

    List<Lyjc> getLyjcAll(HashMap<String, String> paramMap);

    int addLyjc(Lyjc lyjc);

    int addLyjcmxb(List<Lyjcmxb> lyjcmxbs);

    int deleteLyjcmxbById(String[] ids);

    int deleteLyjcById(String[] ids);

    List<Lyjcmxb> getLyjcbmxById(String id);

    int updateLyjc(Lyjc lyjc);

    int updateLyjcmxb(Lyjcmxb lyjcmxb);

    List<Jczb> getJczbAll(HashMap<String, String> paramMap);

    int addJczb(Jczb jczb);

    int addJczbmxb(List<Jczbmxb> jczbmxbs);

    int deleteJczbmxbById(String[] ids);

    int deleteJczbById(String[] ids);

    List<Jczbmxb> getJczbmxById(String id);

    int updateJczb(Jczb jczb);

    int updateJczbmxb(Jczbmxb jczbmxb);

    int deleteLyjcmxbByids(String[] ids);

    int deleteJczbmxByIds(String[] ids);
}
