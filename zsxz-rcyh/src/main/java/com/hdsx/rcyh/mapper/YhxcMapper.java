package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Qdxc;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface YhxcMapper {
    int insertYhxc(Qdxc qdxc);

    List<Qdxc> selectJdlx(HashMap<String, String> param);
}
