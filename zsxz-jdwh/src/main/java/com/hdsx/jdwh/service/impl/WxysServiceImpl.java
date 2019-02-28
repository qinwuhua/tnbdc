package com.hdsx.jdwh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.jdwh.entity.Wxys;
import com.hdsx.jdwh.mapper.WxysMapper;
import com.hdsx.jdwh.mapper.WxysMapper;
import com.hdsx.jdwh.service.WxysService;
import com.hdsx.jdwh.service.WxysService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class WxysServiceImpl implements WxysService {

    @Resource
    private WxysMapper wxysMapper;

    @Override
    public List<Wxys> getDjBxdInfo(Map<String, String> param) {
        return wxysMapper.getDjBxdInfo(param);
    }

    @Override
    public int addWxys(Wxys wxys) {
        return wxysMapper.addWxys(wxys);
    }

    @Override
    public int editWxys(Wxys wxys) {
        return wxysMapper.editWxys(wxys);
    }

    @Override
    public int delWxysByDjbhs(List<String> l) {
        return wxysMapper.delWxysByDjbhs(l);
    }

    @Override
    public Wxys getWxysInfoByIDjbh(String djbh) {
        return wxysMapper.getWxysInfoByIDjbh(djbh);
    }

    @Override
    public List<Wxys> getWxysList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return wxysMapper.getWxysList(param);
    }

    @Override
    public int spWxysByDjbh(Map<String, Object> param) {
        return wxysMapper.spWxysByDjbh(param);
    }

    @Override
    public int getYdjCount(Wxys wxys) {
        return wxysMapper.getYdjCount(wxys);
    }


}
