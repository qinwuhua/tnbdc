package com.hdsx.zxyh.service;


import com.hdsx.zxyh.entity.Bgglbgd;
import com.hdsx.zxyh.entity.Bgglbgl;
import com.hdsx.zxyh.entity.Bgglbgsqb;
import com.hdsx.zxyh.entity.Bgglspsqs;

import java.util.List;
import java.util.Map;

public interface BgglGcbgService {


    int addBgsqbForBggl(Bgglbgsqb bgglbgsqb);

    int editBgsqbForBggl(Bgglbgsqb bgglbgsqb);

    int delBgsqbForBggl(List<String> l);

    Bgglbgsqb getBgsqbInfoByDjbh(String djbh);

    List<Bgglbgsqb> getBgsqbList(Map<String, String> param, int pageNum, int pageSize);

    int spBgsqbForBggl(Map<String, Object> param);

    List<Bgglbgl> getBglBgsqbInfo();

    int addBglForBggl(Bgglbgl bgglbgl);

    int editBglForBggl(Bgglbgl bgglbgl);

    int delBglForBggl(List<String> l);

    Bgglbgl getBglInfoByBglbh(String bglbh);

    List<Bgglbgl> getBglList(Map<String, String> param, int pageNum, int pageSize);

    int spBglForBggl(Map<String, Object> param);

    int addBgdForBggl(Bgglbgd bgglbgd);

    int editBgdForBggl(Bgglbgd bgglbgd);

    int delBgdForBggl(List<String> l);

    Bgglbgd getBgdInfoByDjbh(String djbh);

    List<Bgglbgd> getBgdList(Map<String, String> param, int pageNum, int pageSize);

    int spBgdForBggl(Map<String, Object> param);

    List<Bgglbgd> getHtBgdInfoByBm(Map<String, String> param);
}
