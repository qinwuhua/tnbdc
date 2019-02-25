package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Qsrwd;
import com.hdsx.rcyh.entity.YhrwdInsert;
import com.hdsx.rcyh.entity.Yhrwysd;
import com.hdsx.rcyh.utils.RcyhXxrwResultBean;

import java.util.List;
import java.util.Map;

/**
 * 日常养护 - 小修任务 - Service
 * @author LiRui
 * @created 2019/2/21 0021
 */
public interface RcyhXxrwService {

    /**
     * 获取养护巡查的数据列表（对用数据库表的“启动巡查”）
     * @return
     */
    RcyhXxrwResultBean getYhxcList(Map parMap);

    /**
     * 获取病害（别名：事件；对用数据库表的“巡查上报”）的数据列表
     * @return
     */
    RcyhXxrwResultBean getBhList(Map parMap);

    /**
     * 根据单位（现在是单位名称）查询待下任务单的病害（事件/巡查上报）
     * @param dw
     * @return
     */
    List<Map> getBhListByDW(String dw);

    /**
     * 编辑病害信息
     * 主要是在添加“小修任务 - 养护任务单”时，对病害增加任务单ID（YHRWD_DJBH）
     * @param yhrwd
     * @return
     */
    boolean updateBhData(YhrwdInsert yhrwd);

    /**
     * 添加“小修任务 - 养护任务单”数据
     * @param yhrwd
     * @return
     */
    boolean insertXxrwYhrwd(YhrwdInsert yhrwd);

    /**
     * 获取小修任务 - 养护任务单的数据列表
     * @return
     */
    RcyhXxrwResultBean getXxrwYhrwdList(Map parMap);

    /**
     * 修改养护任务单
     * 要是修改养护任务单的审核/验收状态
     * @param yhrwddjbh ： 任务单主键
     * @param value ： 具体数值
     * @param dealType ： 修改的列：sh审核/ys验收
     * @return
     */
    boolean updateXxrwYhrwd(String yhrwddjbh, String value, String dealType);

    /**
     * 添加“小修任务 - 清扫任务单”数据
     * @param qsrwd
     * @return
     */
    boolean insertXxrwQsrwd(Qsrwd qsrwd);

    /**
     * 编辑“小修任务 - 清扫任务单”的审核/清扫状态
     * @param qsrwdid 清扫任务单ID
     * @param value 具体数值
     * @param dealType ： 修改的列：sh审核/qs清扫
     * @return
     */
    boolean updateXxrwQsrwdShQszt(String qsrwdid, String value, String dealType);

    /**
     * 获取清扫任务单数据列表
     * @return
     */
    RcyhXxrwResultBean getQsrwdList(Map parMap);

    /**
     * 获取合同信息列表
     * 用于：添加“养护验收单”时，选择“工程项目”
     * @return
     */
    List<Map> getHtxxList();

    /**
     * 添加“养护任务验收单”数据
     * @param bean
     * @return
     */
    boolean insertYhrwysd(Yhrwysd bean);

    /**
     * 根据“合同信息ID - yhhtxxhtbh”和“月度ysdyd”，通过“任务单ID”查询病害列表（目前仅有“养护任务单”）
     * @return
     */
    List<Map> getBhListByHtxxID(Map map);

    /**
     * 获取验收单数据列表
     * @param map
     * @return
     */
    RcyhXxrwResultBean getYsdList(Map map);

    /**
     * 根据“养护任务验收单ID”，验收“养护任务验收单”数据
     * @param parMap
     * @return
     */
    boolean updateYhrwysdYS(Map parMap);

    /**
     * 查询维修施工照片记录列表
     * @param parMap
     * @return
     */
    RcyhXxrwResultBean getWxsgzpjl(Map parMap);

    /**
     * 查询维修施工照片记录列表（用于计量工程单查询明细）
     * @param parMap
     * @return
     */
    List<Map> getWxsgzpjlByHtAndYd(Map parMap);

    /**
     * 计量工程明细，表2（用于计量工程单查询明细）
     * @param parMap
     * @return
     */
    List<Map> getJlgcMx2ByHtAndYd(Map parMap);

}
