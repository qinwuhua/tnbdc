package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Kgsqd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KgsqdMapper {

    List<Kgsqd> getAll();

    int addKgsqd(Kgsqd kgsqd);

    int updateKgsqd(Kgsqd kgsqd);

    int deleteKgsqd(String[] djbhs);
}
