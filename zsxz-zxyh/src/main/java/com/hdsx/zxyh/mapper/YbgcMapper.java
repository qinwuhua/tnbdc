package com.hdsx.zxyh.mapper;

import com.hdsx.zxyh.entity.Ybgc;
import com.hdsx.zxyh.entity.Ybgcmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YbgcMapper {

    List<Ybgc> getYbgc();

    int addYbgc(Ybgc ybgc);

    int addYbgcmx(List<Ybgcmx> list);

    int deleteYbgc(String[] ids);

    int deleteYbgcmx(String[] ybids);

    int updateYbgc(Ybgc ybgc);
}
