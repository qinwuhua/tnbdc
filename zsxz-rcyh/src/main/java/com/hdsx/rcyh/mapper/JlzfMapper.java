package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.*;
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

    List<Zmzb> getGcjldHzList(Map<String, String> param);

    int addJrgspFbForJlzf(Jlzf_jrgsp jrgsp);

    int addJrgspForJlzf(Jlzf_jrgsp jrgsp);

    int deleJrgspByDjbh(String jrgsp_djbh);

    int editJrgspForJlzf(Jlzf_jrgsp jrgsp);

    int delJrgspFbForJlzf(List<String> l);

    int delJrgspForJlzf(List<String> l);

    List<Jlzf_jrgsp> getJgrspList(Map<String, String> param);

    Jlzf_jrgsp getJgrspInfoByDjbh(Map<String, String> param);

    int spJgrspForJlzf(Map<String,Object> l);

    List<Jlzf_zqcwzf> getHtCwInfoByBm(Map<String, String> param);

    int addZqcwzfFbForJlzf(Jlzf_zqcwzf zqcwzf);

    int addZqcwzfForJlzf(Jlzf_zqcwzf zqcwzf);

    int deleZqcwzfByDjbh(String zqcwzf_zfqh);

    int editZqcwzfForJlzf(Jlzf_zqcwzf jrgsp);

    int delZqcwzfFbForJlzf(List<String> l);

    int delZqcwzfForJlzf(List<String> l);

    List<Jlzf_zqcwzf> getZqcwzfList(Map<String, String> param);

    Jlzf_zqcwzf getZqcwzfInfoByZfqh(Map<String, String> param);

    List<Jlzf_zqcwzfmx> getZqcwzfReport(Map<String, String> param);

    List<Map<String, String>> getZqcwzfHzbReport(Map<String, String> param);

    int delJgrspMxById(String jrgmx_id);

    int delGcjldMxById(String gcjlmx_id);

    int delZqcwzfMxById(String zqzfmx_id);
}
