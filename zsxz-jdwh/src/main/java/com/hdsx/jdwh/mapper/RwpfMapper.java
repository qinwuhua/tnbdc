package com.hdsx.jdwh.mapper;

import com.hdsx.jdwh.entity.Gzbx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RwpfMapper {


    List<Gzbx> getDfprwdList(Map<String, String> param);

    List<Gzbx> getWxzrrInfo(Map<String, String> param);

    int fpWxrwd(Gzbx gzbx);

    List<Gzbx> getWxrwdList(Map<String, String> param);

    List<Gzbx> getDFPrwd(Map<String, String> param);

    List<Gzbx> getYFPrwd(Map<String, String> param);


    int czfpWxrwd(Gzbx gzbx);
}
