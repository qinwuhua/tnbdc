package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Gcyhysd;
import com.hdsx.rcyh.entity.Gcyssqd;

import java.util.HashMap;
import java.util.List;

public interface YhycService {

    List<Gcyssqd> getGcyssqdAll(HashMap<String, String>paramMap, int pageNum, int pageSize);

    List<Gcyssqd> getGcyssqdByDjbh(String djbh);

    int addGcyssqd(Gcyssqd gcyssqd);

    int updateGcyssqd(Gcyssqd gcyssqd);

    int deleteGcyssqd(String[] ids);

    List<Gcyhysd> getGcyhysdAll(HashMap<String, String>paramMap, int pageNum, int pageSize);

    int addGcyhysd(Gcyhysd gcyhysd);

    int updateGcyhysd(Gcyhysd gcyhysd);

    int deleteGcyhysd(String[] ids);

}
