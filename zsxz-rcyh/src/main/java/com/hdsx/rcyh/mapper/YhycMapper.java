package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Gcyhysd;
import com.hdsx.rcyh.entity.Gcyssqd;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface YhycMapper {

    List<Gcyssqd> getGcyssqdAll(HashMap<String, String> paramMap);

    List<Gcyssqd> getGcyssqdByDjbh(String djbh);

    int addGcyssqd(Gcyssqd gcyssqd);

    int updateGcyssqd(Gcyssqd gcyssqd);

    int deleteGcyssqd(String[] djbhs);

    List<Gcyhysd> getGcyhysdAll(HashMap<String, String> paramMap);

    int addGcyhysd(Gcyhysd gcyhysd);

    int updateGcyhysd(Gcyhysd gcyhysd);

    int deleteGcyhysd(String[] djbhs);

    int addGcqdToGcysd(Gcyssqd gcyssqd);

}
