package com.tnbdc.service;

import com.tnbdc.entities.*;

import java.util.List;
import java.util.Map;

public interface DemoService {
    Users getUsersByUsername(Users users);

    int userRegister(Users users);

    Users getUserByUsername(String username);

    int restPassword(Map<String, String> param);

    boolean addDcwjda(Dcwj dcwj);

    List<Dcwjda> getDcwjdas(Map<String, String> param);

    boolean addFwWzTotle(FwWzTotle fwWzTotle);

    List<FwWzTotle> getFwWzTotle(Map<String, String> param);
}
