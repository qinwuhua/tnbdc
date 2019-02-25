package com.hdsx.jdwh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.jdwh.entity.Rcxj;
import com.hdsx.jdwh.entity.Wxfk;
import com.hdsx.jdwh.entity.Wxfkjsmx;
import com.hdsx.jdwh.mapper.WxfkMapper;
import com.hdsx.jdwh.mapper.WxfkMapper;
import com.hdsx.jdwh.service.WxfkService;
import com.hdsx.jdwh.service.WxfkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class WxfkServiceImpl implements WxfkService {

    @Resource
    private WxfkMapper wxfkMapper;

    @Override
    public int addWxfk(Wxfk wxfk) {
        //添加主表
        int i=wxfkMapper.addWxfk(wxfk);
        //添加结算
        int j=wxfkMapper.addWxfkJsmx(wxfk);
        //添加发票
        int k=wxfkMapper.addWxfkFpmx(wxfk);
        return i;
    }

    @Override
    public int editWxfk(Wxfk wxfk) {
        //修改主表
        int i=wxfkMapper.editWxfk(wxfk);
        //删除结算
        int i1=wxfkMapper.delWxfkJsmx(wxfk);
        //删除发票
        int i2=wxfkMapper.delWxfkFpmx(wxfk);
        //添加结算
        int j=wxfkMapper.addWxfkJsmx(wxfk);
        //添加发票
        int k=wxfkMapper.addWxfkFpmx(wxfk);
        return i;
    }

    @Override
    public int delWxfkByDjbhs(List<String> l) {
        int i=wxfkMapper.delWxfkByDjbhs(l);
        int j=wxfkMapper.delWxfkJsmxByDjbhs(l);
        int k=wxfkMapper.delWxfkFpmxByDjbhs(l);
        return 0;
    }

    @Override
    public Wxfk getWxfkInfoByDjbh(String djbh) {
        return wxfkMapper.getWxfkInfoByDjbh(djbh);
    }

    @Override
    public List<Wxfk> getWxfkList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Wxfk> list = wxfkMapper.getWxfkList(param);
        return  list;
    }

    @Override
    public List<Wxfkjsmx> getWxfyChooseList(Map<String, String> param) {
        return wxfkMapper.getWxfyChooseList(param);
    }

    @Override
    public List<Map<String, String>> getFpInfo() {
        return wxfkMapper.getFpInfo();
    }


}
