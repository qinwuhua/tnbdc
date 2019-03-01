package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.*;
import com.hdsx.rcyh.mapper.JlzfMapper;
import com.hdsx.rcyh.service.JlzfService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class JlzfServiceImpl implements JlzfService {

    @Resource
    private JlzfMapper jlzfMapper;

    @Override
    public int addSpsqsForJlzf(Jlzf jlzf) {
        return jlzfMapper.addSpsqsForJlzf(jlzf);
    }

    @Override
    public int editSpsqsForJlzf(Jlzf jlzf) {
        return jlzfMapper.editSpsqsForJlzf(jlzf);
    }

    @Override
    public int delSpsqsForJlzf(List<String> l) {
        return jlzfMapper.delSpsqsForJlzf(l);
    }

    @Override
    public Jlzf getSpsqsInfoByDjbh(String pmmtgcspsqs_djbh) {
        return jlzfMapper.getSpsqsInfoByDjbh(pmmtgcspsqs_djbh);
    }

    @Override
    public List<Jlzf> getSpsqdList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Jlzf> list = jlzfMapper.getSpsqdList(param);
        return list;
    }

    @Override
    public List<Map<String,String>> getHtInfoByBm(Map<String, String> param) {
        return jlzfMapper.getHtInfoByBm(param);
    }

    @Override
    public List<Map<String, String>> getHtZmHzInfoByHtbh(Map<String, String> param) {
        return jlzfMapper.getHtZmHzInfoByHtbh(param);
    }

    @Override
    public int addGcjldForJlzf(Jlzf jlzf) {
        jlzfMapper.addGcjldFbForJlzf(jlzf);
        return jlzfMapper.addGcjldForJlzf(jlzf);
    }

    @Override
    public List<Map<String, String>> getHtZmMxInfoByHtbh(Map<String, String> param) {
        return jlzfMapper.getHtZmMxInfoByHtbh(param);
    }

    @Override
    public int editGcjldForJlzf(Jlzf jlzf) {
        //删除子目数据
        jlzfMapper.delZmbByDjbh(jlzf.getGcjl_djbh());
        //添加子目
        jlzfMapper.addGcjldFbForJlzf(jlzf);
        //编辑主表
        return jlzfMapper.editGcjldForJlzf(jlzf);

    }

    @Override
    public Jlzf getGcjldInfoByDjbh(Map<String, String> param) {
        //查询主表
        Jlzf jlzf=jlzfMapper.getGcjldInfoByDjbh(param);

        return jlzf;
    }

    @Override
    public List<Jlzf> getGcjldList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Jlzf> list = jlzfMapper.getGcjldList(param);
        return list;
    }

    @Override
    public List<Jlzf> getHtXxInfoByBm(Map<String, String> param) {
        List<Jlzf> list = jlzfMapper.getHtXxInfoByBm(param);

        return list;
    }

    @Override
    public int delGcjldForJlzf(List<String> l) {
        jlzfMapper.delGcjldFbForJlzf(l);
        return jlzfMapper.delGcjldForJlzf(l);
    }

    @Override
    public List<Zmzb> getGcjldHzList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Zmzb> list = jlzfMapper.getGcjldHzList(param);
        for (Zmzb z:list){
            //通过子目号和单据编号查询
            Map<String,String> param1= new HashMap<String,String>();
            param1.put("djbh",z.getJldbh());param1.put("zmh",z.getZmh());
            List<Zmb> zms=jlzfMapper.getZmbsByDjbh(param1);
            z.setZmbs(zms);
        }
        return list;
    }

    @Override
    public int addJrgspForJlzf(Jlzf_jrgsp jrgsp) {
        jlzfMapper.addJrgspFbForJlzf(jrgsp);
        return jlzfMapper.addJrgspForJlzf(jrgsp);
    }

    @Override
    public int editJrgspForJlzf(Jlzf_jrgsp jrgsp) {
        //根据单据编号删除子表
        jlzfMapper.deleJrgspByDjbh(jrgsp.getJrgsp_djbh());
        //插入子表
        jlzfMapper.addJrgspFbForJlzf(jrgsp);
        //修改主表
        return jlzfMapper.editJrgspForJlzf(jrgsp);
    }

    @Override
    public int delJgrspForJlzf(List<String> l) {
        jlzfMapper.delJrgspFbForJlzf(l);
        return jlzfMapper.delJrgspForJlzf(l);
    }

    @Override
    public List<Jlzf_jrgsp> getJgrspList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Jlzf_jrgsp> list = jlzfMapper.getJgrspList(param);
        return  list;
    }

    @Override
    public Jlzf_jrgsp getJgrspInfoByDjbh(Map<String, String> param) {
        return jlzfMapper.getJgrspInfoByDjbh(param);
    }

    @Override
    public int spJgrspForJlzf(Map<String,Object> l) {
        return jlzfMapper.spJgrspForJlzf(l);
    }

    @Override
    public List<Jlzf_zqcwzf> getHtCwInfoByBm(Map<String, String> param) {
        return jlzfMapper.getHtCwInfoByBm(param);
    }

    @Override
    public int addZqcwzfForJlzf(Jlzf_zqcwzf zqcwzf) {
        jlzfMapper.addZqcwzfFbForJlzf(zqcwzf);
        return jlzfMapper.addZqcwzfForJlzf(zqcwzf);
    }

    @Override
    public int editZqcwzfForJlzf(Jlzf_zqcwzf jrgsp) {
        //根据单据编号删除子表
        jlzfMapper.deleZqcwzfByDjbh(jrgsp.getZqcwzf_zfqh());
        //插入子表
        jlzfMapper.addZqcwzfFbForJlzf(jrgsp);
        //修改主表
        return jlzfMapper.editZqcwzfForJlzf(jrgsp);
    }

    @Override
    public int delZqcwzfForJlzf(List<String> l) {
        jlzfMapper.delZqcwzfFbForJlzf(l);
        return jlzfMapper.delZqcwzfForJlzf(l);
    }

    @Override
    public List<Jlzf_zqcwzf> getZqcwzfList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Jlzf_zqcwzf> list = jlzfMapper.getZqcwzfList(param);
        return  list;
    }

    @Override
    public Jlzf_zqcwzf getZqcwzfInfoByZfqh(Map<String, String> param) {
        return jlzfMapper.getZqcwzfInfoByZfqh(param);
    }

    @Override
    public List<Jlzf_zqcwzfmx> getZqcwzfReport(Map<String, String> param) {
        return jlzfMapper.getZqcwzfReport(param);
    }

    @Override
    public List<Map<String, String>> getZqcwzfHzbReport(Map<String, String> param) {
        return jlzfMapper.getZqcwzfHzbReport(param);
    }

    @Override
    public int delJgrspMxById(String jrgmx_id) {
        return jlzfMapper.delJgrspMxById(jrgmx_id);
    }

    @Override
    public int delGcjldMxById(String gcjlmx_id) {
        return jlzfMapper.delGcjldMxById(gcjlmx_id);
    }

    @Override
    public int delZqcwzfMxById(String zqzfmx_id) {
        return jlzfMapper.delZqcwzfMxById(zqzfmx_id);
    }

    @Override
    public int spSpsqsForJlzf(Map<String, Object> param) {
        return jlzfMapper.spSpsqsForJlzf(param);
    }

    @Override
    public int spGcjldForJlzf(Map<String, Object> param) {
        return jlzfMapper.spGcjldForJlzf(param);
    }

    @Override
    public int spZqcwzfForJlzf(Map<String, Object> param) {
        return jlzfMapper.spZqcwzfForJlzf(param);
    }

    @Override
    public List<Jlzf_zqcwzfmx> getZqzfzsMxList(String htbh) {
        return jlzfMapper.getZqzfzsMxList(htbh);
    }

    @Override
    public List<Jlzf_zqcwzfmx> createZqzfzsMxList(String htbh) {
        return jlzfMapper.createZqzfzsMxList(htbh);
    }

}
