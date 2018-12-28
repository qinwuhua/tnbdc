package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.Gcyhysd;
import com.hdsx.rcyh.entity.Gcyssqd;
import com.hdsx.rcyh.mapper.YhycMapper;
import com.hdsx.rcyh.service.YhycService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class YhycServiceImpl implements YhycService {

    @Resource
    private YhycMapper yhycMapper;

    @Override
    public List<Gcyssqd> getGcyssqdAll(HashMap<String,String> paramMap, int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Gcyssqd> list = yhycMapper.getGcyssqdAll(paramMap);
        return list;
    }

    @Override
    public int addGcyssqd(Gcyssqd gcyssqd) {
        return yhycMapper.addGcyssqd(gcyssqd);
    }

    @Override
    public int updateGcyssqd(Gcyssqd gcyssqd) {
       int ssqd = yhycMapper.updateGcyssqd(gcyssqd);
        if (ssqd > 0) {
            if ("已下发".equals(gcyssqd.getSpzt())){
                yhycMapper.addGcqdToGcysd(gcyssqd);
            }
        }
        return ssqd;
    }

    @Override
    public int deleteGcyssqd(String[] ids){
        return yhycMapper.deleteGcyssqd(ids);
    }

    @Override
    public List<Gcyhysd> getGcyhysdAll(HashMap<String, String> paramMap, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Gcyhysd> list = yhycMapper.getGcyhysdAll(paramMap);
        return list;
    }

    @Override
    public List<Gcyssqd> getGcyssqdByDjbh(String djbh) {
        return yhycMapper.getGcyssqdByDjbh(djbh);
    }

    @Override
    public int addGcyhysd(Gcyhysd gcyhysd) {
        return yhycMapper.addGcyhysd(gcyhysd);
    }

    @Override
    public int updateGcyhysd(Gcyhysd gcyhysd) {
        return yhycMapper.updateGcyhysd(gcyhysd);
    }

    @Override
    public int deleteGcyhysd(String[] ids) {
        return yhycMapper.deleteGcyhysd(ids);
    }


}
