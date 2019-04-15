package com.tnbdc.service;

import com.tnbdc.entities.Dcwj;
import com.tnbdc.entities.Dcwjda;
import com.tnbdc.entities.Demo;
import com.tnbdc.entities.Users;

import java.util.List;
import java.util.Map;

public interface DemoService {
    Users getUsersByUsername(Users users);

    int userRegister(Users users);

    Users getUserByUsername(String username);

    int restPassword(Map<String, String> param);

    boolean addDcwjda(Dcwj dcwj);

    List<Dcwjda> getDcwjdas(Map<String, String> param);
}
