package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.RcyhSjdj;

import java.util.List;
import java.util.Map;

/**
 * 日常养护 - 事件登记
 * @author LiRui
 * @created 2019/2/26 0026
 */
public interface AppRcyhSjdjService {

    /**
     * 添加事件信息
     * @param bean
     * @return
     */
    boolean insertSj(RcyhSjdj bean);

    /**
     * 批量添加事件信息
     * @param list
     * @return
     */
    boolean batchInsertSj(List<RcyhSjdj> list);

}
