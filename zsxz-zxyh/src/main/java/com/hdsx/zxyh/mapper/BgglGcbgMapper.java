package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Bgglbgl;
import com.hdsx.zxyh.entity.Bgglbgsqb;
import com.hdsx.zxyh.entity.Bgglspsqs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BgglGcbgMapper {


    int addBgsqbForBggl(Bgglbgsqb bgglbgsqb);

    int editBgsqbForBggl(Bgglbgsqb bgglbgsqb);

    int delBgsqbForBggl(List<String> l);

    Bgglbgsqb getBgsqbInfoByDjbh(String djbh);

    List<Bgglbgsqb> getBgsqbList(Map<String, String> param);

    int spBgsqbForBggl(Map<String, Object> param);

    Bgglbgl getBglBgsqbInfo();

    int addBglForBggl(Bgglbgl bgglbgl);

    int editBglForBggl(Bgglbgl bgglbgl);

    int delBglForBggl(List<String> l);

    Bgglbgl getBglInfoByBglbh(String bglbh);

    List<Bgglbgl> getBglList(Map<String, String> param);

    int spBglForBggl(Map<String, Object> param);
}
