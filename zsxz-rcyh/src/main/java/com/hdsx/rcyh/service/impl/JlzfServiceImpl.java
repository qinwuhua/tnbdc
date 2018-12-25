package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.Jlzf;
import com.hdsx.rcyh.entity.Zmb;
import com.hdsx.rcyh.entity.Zmzb;
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
        for (Zmzb z:jlzf.getZmzbs()){
            //通过子目号和单据编号查询
            Map<String,String> param1= new HashMap<String,String>();
            param1.put("djbh",z.getJldbh());param1.put("zmh",z.getZmh());
            List<Zmb> zms=jlzfMapper.getZmbsByDjbh(param1);
            z.setZmbs(zms);
        }
        /*//查询子目总表
        List<Zmzb> zmz=jlzfMapper.getZmzbsByDjbh(param);
        //查询子目表
        List<Zmb> zm = jlzfMapper.getZmbsByDjbh(param);
        jlzf.setZmbs(zm);jlzf.setZmzbs(zmz);*/
        return jlzf;
    }

    @Override
    public List<Jlzf> getGcjldList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Jlzf> list = jlzfMapper.getGcjldList(param);
        for(Jlzf j: list){
            for (Zmzb z:j.getZmzbs()){
                //通过子目号和单据编号查询
                Map<String,String> param1= new HashMap<String,String>();
                param1.put("djbh",z.getJldbh());param1.put("zmh",z.getZmh());
                List<Zmb> zms=jlzfMapper.getZmbsByDjbh(param1);
                z.setZmbs(zms);
            }
        }

        return list;
    }

    @Override
    public List<Jlzf> getHtXxInfoByBm(Map<String, String> param) {
        List<Jlzf> list = jlzfMapper.getHtXxInfoByBm(param);
        for(Jlzf j: list){
            for (Zmzb z:j.getZmzbs()){
                //通过子目号和单据编号查询
                Map<String,String> param1= new HashMap<String,String>();
                param1.put("htbh",j.getGcjl_htbh());param1.put("zmh",z.getZmh());
                List<Zmb> zms=jlzfMapper.getHtZmXxInfoByBm(param1);
                z.setZmbs(zms);
            }
        }
        return list;
    }

    @Override
    public int delGcjldForJlzf(List<String> l) {
        jlzfMapper.delGcjldFbForJlzf(l);
        return jlzfMapper.delGcjldForJlzf(l);
    }


}
