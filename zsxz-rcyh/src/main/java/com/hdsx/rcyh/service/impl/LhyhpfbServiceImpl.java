package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.Lhyhpfb;
import com.hdsx.rcyh.entity.Lhyhpfbmx;
import com.hdsx.rcyh.mapper.LhyhpfbMapper;
import com.hdsx.rcyh.service.LhyhpfbService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LhyhpfbServiceImpl implements LhyhpfbService {
    @Resource
    private LhyhpfbMapper lhyhpfbMapper;

    @Override
    public int insert(Lhyhpfb lhyhpfb) {
        //添加主表

        //添加子表
        //1.添加主表单据编号给子表
        if (lhyhpfb.getLhyhpfbmxes().size() > 0) {
            for (Lhyhpfbmx lhyhpfbmx : lhyhpfb.getLhyhpfbmxes()) {
                lhyhpfbmx.setLhyhmxdjbh(lhyhpfb.getLhyhdjbh());
                //增加子表
                lhyhpfbMapper.insertzb(lhyhpfbmx);
            }
            return lhyhpfbMapper.insert(lhyhpfb);
        }
        return lhyhpfbMapper.insert(lhyhpfb);
    }

/*    @Override
    public int insertzb(Lhyhpfbmx lhyhpfbmx) {
        return lhyhpfbMapper.insertzb(lhyhpfbmx);
    }*/

    @Override
    public int delete(String lhyhdjbh) {
        //删除子表
        lhyhpfbMapper.deletezb(lhyhdjbh);
        //删除主表
        return lhyhpfbMapper.delete(lhyhdjbh);
    }

    @Override
    public int deletezb(String lhyhid) {
        return lhyhpfbMapper.deletezb(lhyhid);
    }

    @Override
    public int update(Lhyhpfb lhyhpfb) {
        //删除主表的djbh一样的子表
        lhyhpfbMapper.deletezb(lhyhpfb.getLhyhdjbh());
        //添加子表
        if (lhyhpfb.getLhyhpfbmxes().size() > 0) {
            for (Lhyhpfbmx lhyhpfbmx : lhyhpfb.getLhyhpfbmxes()) {
                lhyhpfbmx.setLhyhmxdjbh(lhyhpfb.getLhyhdjbh());
                lhyhpfbMapper.insertzb(lhyhpfbmx);
            }
        }
        //djbh更新主表
        return lhyhpfbMapper.update(lhyhpfb);
    }
/*
    @Override
    public int updatezb(Lhyhpfbmx lhyhpfbmx) {
        return lhyhpfbMapper.updatezb(lhyhpfbmx);
    }*/

    @Override
    public List<Lhyhpfb> getLhyhrwList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Lhyhpfb> list = lhyhpfbMapper.getLhyhrwList(param);
        return list;
    }

    @Override
    public int updatezt(String lhyhid, String lhyhzt) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("lhyhid", lhyhid);
        param.put("lhyhzt", lhyhzt);
        return lhyhpfbMapper.updatezt(param);
    }
}
