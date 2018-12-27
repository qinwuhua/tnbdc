package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.Yhrwd;
import com.hdsx.rcyh.entity.Yhrwmx;
import com.hdsx.rcyh.mapper.YhrwdshMapper;
import com.hdsx.rcyh.service.YhrwdshService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class YhrwdshServiceImpl implements YhrwdshService {
    @Resource
    private  YhrwdshMapper yhrwdshMapper;
    @Override
    public List<Map<String,Object>> queryyhdw() {
        System.out.println("11111111111111111111111");
        return yhrwdshMapper.queryyhdw();
    }

    @Override
    public List<Map<String,Object>> querygldw() {
        return yhrwdshMapper.querygldw();
    }

    @Override
    public int insert(Yhrwd yhrwd) {
        String a = "djbh";
        long l = System.currentTimeMillis();
        String l1 = l + "";
        String ss = a +l1 ;
        yhrwd.setYhrwddjbh(ss);
        return yhrwdshMapper.insert(yhrwd);
    }

    @Override
    public int delete(String yhrwddjbh) {
        return yhrwdshMapper.delete(yhrwddjbh);
    }


    @Override
    public int update(Yhrwd yhrwd) {
        return yhrwdshMapper.update(yhrwd);
    }

    @Override
    public List<Yhrwd> getYhrwdshList(Map<String, String> param, int pageNum, int pageSize) {
            PageHelper.startPage(pageNum, pageSize);
            List<Yhrwd> list = yhrwdshMapper.getYhrwdshList(param);
            return list;
    }

    @Override
    public int updatezt(Yhrwd yhrwd) {

        return yhrwdshMapper.updatezt(yhrwd);

    }

    @Override
    public int deletezb(String yhrwdid) {
        return yhrwdshMapper.deletezb(yhrwdid);
    }

    @Override
    public int insertzb(Yhrwmx yhrwmx) {
        return yhrwdshMapper.insertzb(yhrwmx);
    }

    @Override
    public int updatezb(Yhrwmx yhrwmx) {
        return yhrwdshMapper.updatezb(yhrwmx);
    }

}
