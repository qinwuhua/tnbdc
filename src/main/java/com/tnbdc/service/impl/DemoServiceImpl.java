package com.tnbdc.service.impl;

import com.tnbdc.entities.Dcwj;
import com.tnbdc.entities.Dcwjda;
import com.tnbdc.entities.Demo;
import com.tnbdc.entities.Users;
import com.tnbdc.mapper.DemoMapper;
import com.tnbdc.service.DemoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService {
    @Resource
    private DemoMapper demoMapper;

    @Override
    public Users getUsersByUsername(Users users) {
        return demoMapper.getUsersByUsername(users);
    }

    @Override
    public int userRegister(Users users) {
        return demoMapper.userRegister(users);
    }

    @Override
    public Users getUserByUsername(String username) {
        return demoMapper.getUserByUsername(username);
    }

    @Override
    public int restPassword(Map<String, String> param) {
        return demoMapper.restPassword(param);
    }

    @Override
    public boolean addDcwjda(Dcwj dcwj) {
        //删除
        demoMapper.delDcwjda(dcwj);
        demoMapper.addDcwjda(dcwj);
        //查询是否添加进去
        List<Dcwjda> list = demoMapper.getDcwjda(dcwj);

        return list.size()==dcwj.getDcwjda().size();
    }

    @Override
    public List<Dcwjda> getDcwjdas(Map<String, String> param) {
        return demoMapper.getDcwjdas(param);
    }


    /*@Override
    public Demo selectDemoById(String id) {
        return demoMapper.selectDemoById(id);
    }

    @Override
    public List<Demo> selectDemoAll() {
        return demoMapper.selectDemoAll();
    }
    //这个是管理事务的
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    @Override
    public boolean insertDemo(Demo demo) {
        return demoMapper.insertDemo(demo);
    }*/
}
