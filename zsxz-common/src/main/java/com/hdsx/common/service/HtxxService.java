package com.hdsx.common.service;

import com.hdsx.common.entity.Htxx;

import java.util.HashMap;
import java.util.List;

public interface HtxxService {

    List<Htxx> getHtxxRelatedAll(HashMap<String,String> paramMap);

}
