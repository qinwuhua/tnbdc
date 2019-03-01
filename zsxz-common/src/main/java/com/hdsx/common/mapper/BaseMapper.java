package com.hdsx.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 基础信息 - Mapper
 * @author LiRui
 * @created 2019/3/1 0001
 */
@Mapper
public interface BaseMapper {

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
