package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Kgsqd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KgsqdMapper {

    List<Kgsqd> getAll();
}
