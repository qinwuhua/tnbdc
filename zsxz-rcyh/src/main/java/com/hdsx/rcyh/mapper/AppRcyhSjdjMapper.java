package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.RcyhSjdj;
import org.apache.ibatis.annotations.Mapper;

/**
 * 日常养护 - 事件登记
 * @author LiRui
 * @created 2019/2/26 0026
 */
@Mapper
public interface AppRcyhSjdjMapper {

    /**
     * 添加事件信息
     * @param bean
     * @return
     */
    int insertSj(RcyhSjdj bean);

}
