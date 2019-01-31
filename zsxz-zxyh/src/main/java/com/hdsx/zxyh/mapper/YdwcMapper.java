package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Ydjh;
import com.hdsx.zxyh.entity.Ydjhmx;
import com.hdsx.zxyh.entity.Ydwc;
import com.hdsx.zxyh.entity.Ydwcmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YdwcMapper {

    List<Ydjh> getYdwc();

    int addYdwc(Ydwc ydwc);

    int addYdwcmx(List<Ydwcmx> list);

    int deleteYdwc(String[] ids);

    int deleteYdwcmx(String[] ydids);

    int updateYdwc(Ydwc ydwc);

}
