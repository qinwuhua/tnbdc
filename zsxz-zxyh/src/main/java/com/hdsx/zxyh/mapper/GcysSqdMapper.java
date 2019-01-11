package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Gcyssqd;
import com.hdsx.zxyh.entity.Gczfgcjld;
import com.hdsx.zxyh.entity.Gczfzqcwzf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface GcysSqdMapper {

    List<Gcyssqd> getGcyssqdList(Map<String, String> param);

    Gcyssqd getGcyssqdInfoBySqbh(Map<String, String> param);

    int addGcyssqdForGcys(Gcyssqd gcyssqd);

    int editGcyssqdForGcys(Gcyssqd gcyssqd);

    int delGcyssqdForGcys(List<String> l);

    int spGcyssqdForGcys(Map<String, Object> param);
}
