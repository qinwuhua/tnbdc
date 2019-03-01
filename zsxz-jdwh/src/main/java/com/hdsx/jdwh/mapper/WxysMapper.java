package com.hdsx.jdwh.mapper;

import com.hdsx.jdwh.entity.Wxdj;
import com.hdsx.jdwh.entity.Wxys;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface WxysMapper {

    List<Wxys> getDjBxdInfo(Map<String, String> param);

    int addWxys(Wxys wxys);

    int editWxys(Wxys wxys);

    int delWxysByDjbhs(List<String> l);

    Wxys getWxysInfoByIDjbh(String djbh);

    List<Wxys> getWxysList(Map<String, String> param);

    int spWxysByDjbh(Map<String, Object> param);

    int getYdjCount(Wxys wxys);

    int getYysCount(Wxys wxys);
}
