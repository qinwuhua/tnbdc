package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.AppRcyhQdxc;
import com.hdsx.rcyh.entity.RcyhSjdj;
import com.hdsx.rcyh.entity.RwdSubsidiary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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

    /**
     * 更新“（清扫/日常）任务单子表”的“维修时间/维修状态”
     * @param bean
     * @return
     */
    int updateRwdSubsidiaryWx(RwdSubsidiary bean);

    /**
     * 添加“启动巡查”数据
     * @param bean
     * @return
     */
    int insertQdxc(AppRcyhQdxc bean);

    /**
     * 根据“人员ID”查询其所应做的养护/清扫任务信息（病害/事件）
     * @param ryid
     * @return
     */
    List<Map> getBhrwByRyid(String ryid);

    /**
     * 根据“人员ID”查询其所能进行的“月度计划”列表
     * @param ryid
     * @return
     */
    List<Map> getYhjhByRyid(String ryid);

}
