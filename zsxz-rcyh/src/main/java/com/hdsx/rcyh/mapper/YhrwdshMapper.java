package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Lhyh;
import com.hdsx.rcyh.entity.Yhrwd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface YhrwdshMapper {
    List<Map<String,Object>> queryyhdw();

    List<Map<String,Object>> querygldw();

    int insert(Yhrwd yhrwd);

    int delete(String yhrwddjbh);

    List<Yhrwd> getYhrwdshList(Map<String, String> param);

    int update(Yhrwd yhrwd);

}
