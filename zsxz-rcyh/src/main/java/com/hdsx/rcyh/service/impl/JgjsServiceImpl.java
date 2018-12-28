package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.*;
import com.hdsx.rcyh.mapper.JgjsMapper;
import com.hdsx.rcyh.mapper.JlzfMapper;
import com.hdsx.rcyh.service.JgjsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class JgjsServiceImpl implements JgjsService {

    @Resource
    private JgjsMapper jgjsMapper;


    @Override
    public List<Jgjs> getHtCwInfoByBm(Map<String, String> param) {
        return jgjsMapper.getHtCwInfoByBm(param);
    }

    @Override
    public int addJgjssForJgjs(Jgjs jgjs) {
        jgjsMapper.addJgjssFbForJgjs(jgjs);
        return jgjsMapper.addJgjssForJgjs(jgjs);
    }

    @Override
    public int editJgjssForJgjs(Jgjs jgjs) {
        //根据单据编号删除子表
        jgjsMapper.deleJgjssByDjbh(jgjs.getPmmtjgjss_jssbh());
        //插入子表
        jgjsMapper.addJgjssFbForJgjs(jgjs);
        //修改主表
        return jgjsMapper.editJgjssForJgjs(jgjs);
    }

    @Override
    public int delJgjssForJgjs(List<String> l) {
        jgjsMapper.delJgjssFbForJgjs(l);
        return jgjsMapper.delJgjssForJgjs(l);
    }

    @Override
    public Jgjs getJgjssInfoByDjbh(String pmmtjgjss_jssbh) {
        return jgjsMapper.getJgjssInfoByDjbh(pmmtjgjss_jssbh);
    }

    @Override
    public List<Jgjs> getJgjssList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Jgjs> list = jgjsMapper.getJgjssList(param);
        return  list;
    }

    @Override
    public int delJgjsMxById(String pmmtjgjssmx_id) {
        return jgjsMapper.delJgjsMxById(pmmtjgjssmx_id);
    }

    @Override
    public int spJgjssForJgjs(Map<String, Object> param) {
        return jgjsMapper.spJgjssForJgjs(param);
    }
}
