package com.hdsx.jdwh.service;

import com.hdsx.jdwh.entity.Wxfy;
import com.hdsx.jdwh.entity.Wxys;

import java.util.List;
import java.util.Map;

public interface WxfyService {

    List<Wxfy> getWxsbInfo(Map<String, String> param);

    List<Wxfy> getDfdwInfo(Map<String, String> param);

    int addWxfy(Wxfy wxfy);

    int editWxfy(Wxfy wxfy);

    int delWxfyByDjbhs(List<String> l);

    Wxfy getWxfyInfoByIDjbh(String djbh);

    List<Wxfy> getWxfyList(Map<String, String> param, int pageNum, int pageSize);

    int spWxfyByDjbh(Map<String, Object> param);
}
