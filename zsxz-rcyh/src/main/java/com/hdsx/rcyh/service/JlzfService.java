package com.hdsx.rcyh.service;


import com.hdsx.rcyh.entity.*;

import java.util.List;
import java.util.Map;

public interface JlzfService {

    int addSpsqsForJlzf(Jlzf jlzf);

    int editSpsqsForJlzf(Jlzf jlzf);

    int delSpsqsForJlzf(List<String> l);

    Jlzf getSpsqsInfoByDjbh(String pmmtgcspsqs_djbh);

    List<Jlzf> getSpsqdList(Map<String, String> param, int pageNum, int pageSize);

    List<Map<String,String>> getHtInfoByBm(Map<String, String> param);

    List<Map<String, String>> getHtZmHzInfoByHtbh(Map<String, String> param);

    int addGcjldForJlzf(Jlzf jlzf);

    List<Map<String, String>> getHtZmMxInfoByHtbh(Map<String, String> param);

    int editGcjldForJlzf(Jlzf jlzf);

    Jlzf getGcjldInfoByDjbh(Map<String, String> param);

    List<Jlzf> getGcjldList(Map<String, String> param, int pageNum, int pageSize);

    List<Jlzf> getHtXxInfoByBm(Map<String, String> param);

    int delGcjldForJlzf(List<String> l);

    List<Zmzb> getGcjldHzList(Map<String, String> param, int pageNum, int pageSize);

    int addJrgspForJlzf(Jlzf_jrgsp jrgsp);

    int editJrgspForJlzf(Jlzf_jrgsp jrgsp);

    int delJgrspForJlzf(List<String> l);

    List<Jlzf_jrgsp> getJgrspList(Map<String, String> param, int pageNum, int pageSize);

    Jlzf_jrgsp getJgrspInfoByDjbh(Map<String, String> param);

    int spJgrspForJlzf(Map<String,Object> l);

    List<Jlzf_zqcwzf> getHtCwInfoByBm(Map<String, String> param);

    int addZqcwzfForJlzf(Jlzf_zqcwzf zqcwzf);

    int editZqcwzfForJlzf(Jlzf_zqcwzf jrgsp);

    int delZqcwzfForJlzf(List<String> l);

    List<Jlzf_zqcwzf> getZqcwzfList(Map<String, String> param, int pageNum, int pageSize);

    Jlzf_zqcwzf getZqcwzfInfoByZfqh(Map<String, String> param);

    List<Jlzf_zqcwzfmx> getZqcwzfReport(Map<String, String> param);

    List<Map<String, String>> getZqcwzfHzbReport(Map<String, String> param);

    int delJgrspMxById(String jrgmx_id);

    int delGcjldMxById(String gcjlmx_id);

    int delZqcwzfMxById(String zqzfmx_id);
}
