package com.hdsx.jdwh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.jdwh.entity.Wxfy;
import com.hdsx.jdwh.mapper.WxfyMapper;
import com.hdsx.jdwh.mapper.WxfyMapper;
import com.hdsx.jdwh.service.WxfyService;
import com.hdsx.jdwh.service.WxfyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class WxfyServiceImpl implements WxfyService {

    @Resource
    private WxfyMapper wxfyMapper;

    @Override
    public List<Wxfy> getWxsbInfo(Map<String, String> param) {
        return wxfyMapper.getWxsbInfo(param);
    }

    @Override
    public List<Wxfy> getDfdwInfo(Map<String, String> param) {
        return wxfyMapper.getDfdwInfo(param);
    }

    @Override
    public int addWxfy(Wxfy wxfy) {
        return wxfyMapper.addWxfy(wxfy);
    }

    @Override
    public int editWxfy(Wxfy wxfy) {
        return wxfyMapper.editWxfy(wxfy);
    }

    @Override
    public int delWxfyByDjbhs(List<String> l) {
        return wxfyMapper.delWxfyByDjbhs(l);
    }

    @Override
    public Wxfy getWxfyInfoByIDjbh(String djbh) {
        return wxfyMapper.getWxfyInfoByIDjbh(djbh);
    }

    @Override
    public List<Wxfy> getWxfyList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return wxfyMapper.getWxfyList(param);
    }

    @Override
    public int spWxfyByDjbh(Map<String, Object> param) {
        return wxfyMapper.spWxfyByDjbh(param);
    }

}
