package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface JgjsMapper {

    List<Jgjs> getHtCwInfoByBm(Map<String, String> param);

    int addJgjssFbForJgjs(Jgjs jgjs);

    int addJgjssForJgjs(Jgjs jgjs);

    int deleJgjssByDjbh(String pmmtjgjss_jssbh);

    int editJgjssForJgjs(Jgjs jgjs);

    int delJgjssFbForJgjs(List<String> l);

    int delJgjssForJgjs(List<String> l);

    Jgjs getJgjssInfoByDjbh(String pmmtjgjss_jssbh);

    List<Jgjs> getJgjssList(Map<String, String> param);

    int delJgjsMxById(String pmmtjgjssmx_id);

    int spJgjssForJgjs(Map<String, Object> param);
}
