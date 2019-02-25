package com.hdsx.jdwh.mapper;

import com.hdsx.jdwh.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FjczMapper {
    List<Fjczmx> getFjczmxByPdjbh(String djbh);

    List<Fjczfymx> getFjczfymxByPdjbh(String djbh);

    int addFjcz(Fjcz fjcz);

    int addFjczMx(Fjcz fjcz);

    int addFjczfyMx(Fjcz fjcz);

    int editFjcz(Fjcz fjcz);

    int delFjczMx(Fjcz fjcz);

    int delFjczfyMx(Fjcz fjcz);

    int delFjczBydjbhs(List<String> l);

    int delFjczMxBydjbhs(List<String> l);

    int delFjczfyMxBydjbhs(List<String> l);

    Fjcz getFjczInfoByDjbh(String djbh);

    List<Fjcz> getFjczList(Map<String, String> param);

    int editFjZtFlag(Map<String, Object> param);

    int spFjczByDjbh(Map<String, Object> param);
}
