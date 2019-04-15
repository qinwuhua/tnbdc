package com.tnbdc.mapper;

import com.tnbdc.entities.Dcwj;
import com.tnbdc.entities.Dcwjda;
import com.tnbdc.entities.Demo;
import com.tnbdc.entities.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DemoMapper {
/*    Demo selectDemoById(String id);
    List<Demo> selectDemoAll();
    boolean insertDemo(Demo demo);*/

    Users getUsersByUsername(Users users);

    int userRegister(Users users);

    Users getUserByUsername(String username);

    int restPassword(Map<String, String> param);

    int addDcwjda(Dcwj dcwj);

    List<Dcwjda> getDcwjda(Dcwj dcwj);

    void delDcwjda(Dcwj dcwj);

    List<Dcwjda> getDcwjdas(Map<String, String> param);
}
