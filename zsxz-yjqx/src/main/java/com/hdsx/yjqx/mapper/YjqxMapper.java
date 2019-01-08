package com.hdsx.yjqx.mapper;

import com.hdsx.yjqx.entity.Yjqx;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface YjqxMapper {

    int addYjqxgc(Yjqx yjqx);

    int editYjqxgc(Yjqx yjqx);

    int delYjqxgcByIds(String[] ids);

    List<Yjqx> getYjqxgcList(HashMap<String, String > paramMap);


}
