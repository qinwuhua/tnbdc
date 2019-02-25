package com.hdsx.jdwh.mapper;

import com.hdsx.jdwh.entity.Wxfy;
import com.hdsx.jdwh.entity.Wxys;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface WxfyMapper {

    List<Wxfy> getWxsbInfo(Map<String, String> param);

    List<Wxfy> getDfdwInfo(Map<String, String> param);

    int addWxfy(Wxfy wxfy);

    int editWxfy(Wxfy wxfy);

    int delWxfyByDjbhs(List<String> l);

    Wxfy getWxfyInfoByIDjbh(String djbh);

    List<Wxfy> getWxfyList(Map<String, String> param);

    int spWxfyByDjbh(Map<String, Object> param);
}
