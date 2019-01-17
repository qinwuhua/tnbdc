package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Ydjh;
import com.hdsx.zxyh.entity.Ydjhmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YdjhMapper {

    List<Ydjh> getYdjh();

    int addYdjh(Ydjh ydjh);

    int addYdjhmx(List<Ydjhmx> ydjhmxList);

    int deleteYdjh(String[] ids);

    int deleteYdjhmx(String[] ydids);

    int updateYdjh(Ydjh ydjh);
}
