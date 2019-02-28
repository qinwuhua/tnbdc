package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Qsrwd;
import com.hdsx.rcyh.entity.RwdSubsidiary;
import com.hdsx.rcyh.entity.YhrwdInsert;
import com.hdsx.rcyh.entity.Yhrwysd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 日常养护 - 小修任务 - 总体Mapper
 * @author LiRui
 * @created 2019/2/21 0021
 */
@Mapper
public interface RcyhXxrwMapper {

    /**
     * 获取养护巡查的数据列表（对用数据库表的“启动巡查”）
     * @return
     */
    List<Map> getYhxcList(Map parMap);

    /**
     * 统计养护巡查（对用数据库表的“启动巡查”）数据条数
     * @param parMap
     * @return
     */
    int countYhxcNum(Map parMap);

    /**
     * 根据“启动巡查ID”查询旗下的“巡查上报（病害）”
     * @param id
     * @return
     */
    List<Map> getBhListByYhxcID(String id);

    /**
     * 获取病害（别名：事件；对用数据库表的“巡查上报”）的数据列表
     * @return
     */
    List<Map> getBhList(Map parMap);

    /**
     * 统计病害（别名：事件；对用数据库表的“巡查上报”）的数据条数
     * @param parMap
     * @return
     */
    int countBhNum(Map parMap);

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
    int updateBhData(YhrwdInsert yhrwd);

    /**
     * 添加“小修任务 - 养护任务单”数据
     * @param yhrwd
     * @return
     */
    int insertXxrwYhrwd(YhrwdInsert yhrwd);

    /**
     * 获取小修任务 - 养护任务单的数据列表
     * @return
     */
    List<Map> getXxrwYhrwdList(Map parMap);

    /**
     * 统计小修任务 - 养护任务单的数据条数
     * @param parMap
     * @return
     */
    int countXxrwYhrwdNum(Map parMap);

    /**
     * 获取病害（别名：事件；对用数据库表的“巡查上报”）的数据列表
     * 根据养护任务单的yhrwddjbh养护任务单ID
     * @param yhrwddjbh
     * @return
     */
    List<Map> getBhListByYhrwdDjbh(String yhrwddjbh);

    /**
     * 修改养护任务单
     * 主要是修改养护任务单的审核/验收状态
     * @param parMap
     * @return
     */
    int updateXxrwYhrwd(Map parMap);

    /**
     * 添加“小修任务 - 清扫任务单”数据
     * @param qsrwd
     * @return
     */
    int insertXxrwQsrwd(Qsrwd qsrwd);

    /**
     * 根据病害ID查询病害的详细信息
     * 用于添加清扫任务单
     * @param rwmxid
     * @return
     */
    Map getBhByRwmxdwid(String rwmxid);

    /**
     * 编辑“小修任务 - 清扫任务单”的审核/清扫状态
     * @param map
     * @return
     */
    int updateXxrwQsrwdShQszt(Map map);

    /**
     * 获取清扫任务单数据列表
     * @param parMap
     * @return
     */
    List<Map> getQsrwdList(Map parMap);

    /**
     * 统计清扫任务单数据条数
     * @param parMap
     * @return
     */
    int countQsrwdList(Map parMap);

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
    int insertYhrwysd(Yhrwysd bean);

    /**
     * 添加“养护任务验收单 - 任务单关联信息”数据
     * @param map
     * @return
     */
    int insertYhrwysdRwdRelation(Map map);

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
    List<Yhrwysd> getYsdList(Map map);

    /**
     * 统计验收单数据条数
     * @param map
     * @return
     */
    int countYsdList(Map map);

    /**
     * 获取病害（别名：事件；对用数据库表的“巡查上报”）的数据列表
     * 根据验收单ID（ysdid）
     * @param ysdid
     * @return
     */
    List<Map> getBhListByYsdid(String ysdid);

    /**
     * 根据“养护任务验收单ID”，验收“养护任务验收单”数据
     * @param parMap
     * @return
     */
    int updateYhrwysdYS(Map parMap);

    /**
     * 根据“养护任务验收单ID”，验收“养护任务单”数据
     * @param ysdid
     * @return
     */
    int updateYhrwdYS(String ysdid);

    /**
     * 查询维修施工照片记录列表
     * @param parMap
     * @return
     */
    List<Map> getWxsgzpjl(Map parMap);

    /**
     * 查询维修施工照片记录列表
     * @param parMap
     * @return
     */
    int countWxsgzpjl(Map parMap);

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

    /**
     * 添加“养护/清扫任务单子表”数据
     * @param bean
     * @return
     */
    int insertRwdSubsidiary(RwdSubsidiary bean);

    /**
     * 根据“任务单ID”删除“养护/清扫任务单子表”数据
     * @param rwdid
     * @return
     */
    int deleteRwdSubsidiaryByRwdid(String rwdid);

    /**
     * 根据“月度计划ID”查询其所属合同的子目下拉框。
     * @param yhijid
     * @return
     */
    List<Map> getZmxxByYdjhID(String yhijid);

    /**
     * 根据“月份”和“合同编号”构建用于“养护施工计划完成明细表”的数据
     * @param map
     * @return
     */
    List<Map> getCreateYhjdwcmxByYfAndHtbh(Map map);

}
