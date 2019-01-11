package com.hdsx.zxyh.service;

import com.hdsx.zxyh.entity.Jczbqkb;

import java.util.List;

public interface JczbqkbService {

    List<Jczbqkb> getJczbqkb(String htbh, String gldw);

    int addJczbqkb(Jczbqkb jczbqkb);

    int deleteJczbqkb(String id);

    int updateJczbqkb(Jczbqkb jczbqkb);
}
