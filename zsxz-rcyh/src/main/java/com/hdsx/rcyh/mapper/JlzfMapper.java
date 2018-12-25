package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Jlzf;
import com.hdsx.rcyh.entity.Zmb;
import com.hdsx.rcyh.entity.Zmzb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface JlzfMapper {

    int addSpsqsForJlzf(Jlzf jlzf);

    int editSpsqsForJlzf(Jlzf jlzf);

    int delSpsqsForJlzf(List<String> l);

    Jlzf getSpsqsInfoByDjbh(String pmmtgcspsqs_djbh);

    List<Jlzf> getSpsqdList(Map<String, String> param);

    List<Map<String, String>> getHtInfoByBm(Map<String, String> param);

    List<Map<String, String>> getHtZmHzInfoByHtbh(Map<String, String> param);

    int addGcjldForJlzf(Jlzf jlzf);

    int addGcjldFbForJlzf(Jlzf jlzf);

    List<Map<String, String>> getHtZmMxInfoByHtbh(Map<String, String> param);

    List<Zmb> getZmbsByDjbh(Map<String, String> param);

    int delZmbByDjbh(String gcjl_djbh);

    int editGcjldForJlzf(Jlzf jlzf);

    Jlzf getGcjldInfoByDjbh(Map<String, String> param);

    List<Zmzb> getZmzbsByDjbh(Map<String, String> param);

    List<Jlzf> getGcjldList(Map<String, String> param);

    List<Jlzf> getHtXxInfoByBm(Map<String, String> param);

    List<Zmb> getHtZmXxInfoByBm(Map<String, String> param1);

    int delGcjldFbForJlzf(List<String> l);

    int delGcjldForJlzf(List<String> l);
}
