package com.hdsx.common.service;

import java.util.List;
import java.util.Map;

/**
 * 基础信息 - Service
 * @author LiRui
 * @created 2019/3/1 0001
 */
public interface BaseService {

    /**
     * 创建组织域下拉框
     * @return
     */
    List<Map> createZzxxList();

    /**
     * 根据公司ID查人员信息
     * @param gsid
     * @return
     */
    List<Map> createRyxxList(String gsid);

}
