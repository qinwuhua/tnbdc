package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Sgzjdjh;
import com.hdsx.zxyh.entity.Sgzjdjhmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SgzjdjhMapper {

    List<Sgzjdjh> getSgzjdjh();

    int addSgzjdjh(Sgzjdjh sgzjdjh);

    int updateSgzjdjh(Sgzjdjh sgzjdjh);

    int deleteSgzjdjh(List ids);

    List<Sgzjdjhmx> getSgzjdjhMX(String djbh);

    int addSgzjdjhMx(Sgzjdjh sgzjdjh);

    int delSgzjdjhMx(String djbh);

    int deleteSgzjdjhiMx(List ids);

    int spSgzjdjh(Map<String, Object> param);
}
