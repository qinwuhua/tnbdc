package com.hdsx.common.service;

import com.hdsx.common.entity.Htxx;

import java.util.HashMap;
import java.util.List;

public interface HtxxService {

    List<HashMap<String, Object>> getHtxxAll();

    List<HashMap<String, Object>> getHtxxLyjcAll();

    List<HashMap<String, Object>> getHtgjxxAll();

    List<HashMap<String, Object>> getHtxxYhAll();

    List<Htxx> getHtxxRelatedAll(HashMap<String,String> paramMap);

    List<Htxx> getZjHtxxRelatedAll(HashMap<String, String> paramMap);
}
