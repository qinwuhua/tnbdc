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

    int spSpsqsForJlzf(Map<String, Object> param);

    int spGcjldForJlzf(Map<String, Object> param);

    int spZqcwzfForJlzf(Map<String, Object> param);

    /**
     * 根据“合同编号”查询《中（终）期支付证书 - 明细》列表，用于添加《交工结算单》时，展示其明细信息
     * @param htbh
     * @return
     */
    List<Jlzf_zqcwzfmx> getZqzfzsMxList(String htbh);

}
