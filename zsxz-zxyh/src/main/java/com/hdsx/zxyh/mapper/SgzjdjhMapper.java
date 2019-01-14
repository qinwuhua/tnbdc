package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Sgzjdjh;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SgzjdjhMapper {

    List<Sgzjdjh> getSgzjdjh();

    int addSgzjdjh(Sgzjdjh sgzjdjh);

    int updateSgzjdjh(Sgzjdjh sgzjdjh);

    int deleteSgzjdjh(String[] ids);
}
