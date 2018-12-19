package com.hdsx.lkpd.mapper;

import com.hdsx.lkpd.entity.Qmldb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface QmldbMapper {

    List<Qmldb> getQmldForLkdc(Qmldb qmldb);
}
