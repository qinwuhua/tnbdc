package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Sgjh;
import com.hdsx.rcyh.entity.Sgjhsbmx;
import com.hdsx.rcyh.entity.Sgjhwc;
import com.hdsx.rcyh.entity.Sgjhwcmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface SgjhMapper {

    List<Sgjh> getSgjhAll(HashMap<String,String> paramMap);

    int addSgjh(Sgjh sgjh);

    int addSgjhmx(List<Sgjhsbmx> sgjhsbmx);

    int updateSgjh(Sgjh sgjh);

    int updateSgjhmx(Sgjhsbmx sgjhsbmx);

    int deleteSgjh(String id);

    List<HashMap<String,Object>> getSgjhmxById(String mid);

    int deleteSgjhmx(String id);

    List<HashMap<String,Object>> getWcSgjhAll(HashMap<String,String> paramMap);

    int addWcSgjh(Sgjhwc sgjhwc);

    int addWcsgjhmx(List<Sgjhwcmx> sgjhwcmx);

    int upateWcsgjh(Sgjhwc sgjhwc);

    int updateWcSgjhmx(Sgjhwcmx sgjhwcmx);

    int deleteWcSgjh(String id);

    int deleteWcSgjhmx(String id);

    List<HashMap<String,Object>> getWcSgjhmxById(String id);

}
