package com.hdsx.lkpd.mapper;

import com.hdsx.lkpd.entity.Pdfa;
import com.hdsx.lkpd.entity.Qmldb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface LkpdCxMapper {

    List<Qmldb> getMxbForLksjcx(Map<String, String> param);

    List<Map<String, String>> getHzbForLksjcx(Map<String, String> param);

    Map getDjbhForLksjcx();

    Integer getIsFaDataByDjbh(Integer djbh);

    int addFaForLksjcx(Pdfa pdfa);

    List<Pdfa> getFaForLksjcx(Map<String, String> param);

    int editFaForLksjcx(Pdfa pdfa);

    int delFaForLksjcx(List<Long> djbhs);

    int dropMxb(Map<String, String> param);


    List<Qmldb> getLmjc(Map<String, String> param);

    int addMxb(Qmldb qm);

    double getBcicx(Qmldb qm);

    double getPcicx(Qmldb qm);

    double getTcicx(Qmldb qm);

    double getScicx(Qmldb qm);

    int updateFaZtYfb(Qmldb qm);
}
