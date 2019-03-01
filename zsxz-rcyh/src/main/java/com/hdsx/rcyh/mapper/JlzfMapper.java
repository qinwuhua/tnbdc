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

    int spSpsqsForJlzf(Map<String, Object> param);

    int spGcjldForJlzf(Map<String, Object> param);

    int spZqcwzfForJlzf(Map<String, Object> param);

    /**
     * 根据“合同编号”查询《中（终）期支付证书 - 明细》列表，用于添加《交工结算单》时，展示其明细信息
     * @param htbh
     * @return
     */
    List<Jlzf_zqcwzfmx> getZqzfzsMxList(String htbh);

    /**
     * 根据“合同编号”查询《工程计量单 - 明细》列表，用于添加《中（终）期支付证书 - 明细》时，展示其明细信息
     * @param htbh
     * @return
     */
    List<Jlzf_zqcwzfmx> createZqzfzsMxList(String htbh);

}
