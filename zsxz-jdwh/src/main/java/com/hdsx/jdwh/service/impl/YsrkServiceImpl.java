package com.hdsx.jdwh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.jdwh.entity.Ysrk;
import com.hdsx.jdwh.mapper.YsrkMapper;
import com.hdsx.jdwh.service.YsrkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class YsrkServiceImpl implements YsrkService {

    @Resource
    private YsrkMapper ysrkMapper;

    @Override
    public List<Map<String,String>> getCkInfo(Map<String, String> param) {
        return ysrkMapper.getCkInfo(param);
    }

    @Override
    public List<Map<String, String>> getWxdhInfo(Map<String, String> param) {
        return ysrkMapper.getWxdhInfo(param);
    }

    @Override
    public List<Map<String, String>> getHtBjInfo(Map<String, String> param) {
        return ysrkMapper.getHtBjInfo(param);
    }

    @Override
    public List<Map<String, String>> getWxBjInfo(Map<String, String> param) {
        return ysrkMapper.getWxBjInfo(param);
    }

    @Override
    public int addYsrk(Ysrk ysrk) {
        int i=ysrkMapper.addYsrk(ysrk);
        int k=ysrkMapper.addYsrkMx(ysrk);
        return i;
    }

    @Override
    public int editYsrk(Ysrk ysrk) {
        //修改主表
        int i=ysrkMapper.editYsrk(ysrk);
        //删除子表
        int j=ysrkMapper.delYsrkMx(ysrk);
        //添加子表
        int k=ysrkMapper.addYsrkMx(ysrk);
        return i;
    }

    @Override
    public int delYsrkBydjbhs(List<String> l) {
        int i=ysrkMapper.delYsrkBydjbhs(l);
        int j=ysrkMapper.delYsrkMxBydjbhs(l);
        return i;
    }

    @Override
    public Ysrk getYsrkInfoByDjbh(String djbh) {
        return ysrkMapper.getYsrkInfoByDjbh(djbh);
    }

    @Override
    public List<Ysrk> getYsrkList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Ysrk> list = ysrkMapper.getYsrkList(param);
        return  list;
    }


}
