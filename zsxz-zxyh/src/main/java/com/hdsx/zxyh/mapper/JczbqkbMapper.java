package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Jczbqkb;
import com.hdsx.zxyh.entity.Jczbqkbmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface JczbqkbMapper {

    List<Jczbqkb> getJczbqkb(HashMap<String, Object> param);

    int addJczbqkb(Jczbqkb jczbqkb);

    int addJczbqkbMx(List<Jczbqkbmx> list);

    int deleteJczbqkb(String[] ids);

    int deleteJczbqkbMx(String[] jczbids);

    int updateJczbqkb(Jczbqkb jczbqkb);
}
