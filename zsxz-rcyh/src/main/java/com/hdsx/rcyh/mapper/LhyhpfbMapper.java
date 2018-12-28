package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Lhyhpfb;
import com.hdsx.rcyh.entity.Lhyhpfbmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface LhyhpfbMapper {

    int insertzb(Lhyhpfbmx lhyhpfbmx);

    int insert(Lhyhpfb lhyhpfb);

    int delete(String lhyhdjbh);

    int deletezb(String lhyhdjbh);

    int update(Lhyhpfb lhyhpfb);

/*    int updatezb(Lhyhpfbmx lhyhpfbmx);*/

    List<Lhyhpfb> getLhyhrwList(Map<String, String> param);

    int updatezt(HashMap<String, Object> param);
}
