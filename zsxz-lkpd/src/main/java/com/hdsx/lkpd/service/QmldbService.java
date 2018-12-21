package com.hdsx.lkpd.service;

import com.hdsx.lkpd.entity.Qmldb;

import java.util.List;

public interface QmldbService {

    List<Qmldb> getQmldForLkdc(Qmldb qmldb);
}
