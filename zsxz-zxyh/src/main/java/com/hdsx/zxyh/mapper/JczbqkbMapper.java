package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Jczbqkb;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface JczbqkbMapper {

    List<Jczbqkb> getJczbqkb(HashMap<String, Object> param);

    int addJczbqkb(Jczbqkb jczbqkb);

    int addJczbqkbMid(List<HashMap<String, Object>> list);

    int deleteJczbqkb(String id);

    int deleteJczbqkbMid(String jczbid);

    int updateJczbqkb(Jczbqkb jczbqkb);
}
