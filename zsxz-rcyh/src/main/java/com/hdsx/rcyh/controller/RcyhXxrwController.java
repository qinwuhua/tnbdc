package com.hdsx.rcyh.controller;

import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.entity.Qsrwd;
import com.hdsx.rcyh.entity.RwdSubsidiary;
import com.hdsx.rcyh.entity.YhrwdInsert;
import com.hdsx.rcyh.service.RcyhXxrwService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 日常养护 - 小修任务 - Controller
 * @author LiRui
 * @created 2019/2/21 0021
 */

@RestController
@RequestMapping("rcyhXxrw")
@Api(value = "日常养护 - 小修任务",description = "日常养护 - 小修任务新版接口：2019-02-21")
public class RcyhXxrwController {

    @Resource
    private RcyhXxrwService service;

    @GetMapping("getYhxcList")
    @ApiOperation("获取养护巡查（启动巡查）数据列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwmc", value = "单位名称"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwid", value = "单位ID"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bmmc", value = "部门名称"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bmid", value = "部门ID"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbr", value = "填报人"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "xclx", value = "巡查路线ID（路线ID）"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "kssj", value = "巡查开始时间"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jssj", value = "巡查结束时间"),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getYhxcList(
            @RequestParam(value = "dwmc",required = false)String dwmc,
            @RequestParam(value = "dwid",required = false)String dwid,
            @RequestParam(value = "bmmc",required = false)String bmmc,
            @RequestParam(value = "bmid",required = false) String bmid,
            @RequestParam(value = "tbr",required = false) String tbr,
            @RequestParam(value = "xclx",required = false) String xclx,
            @RequestParam(value = "kssj",required = false) String kssj,
            @RequestParam(value = "jssj",required = false) String jssj,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            Map map = dealPageParame(pageNum, pageSize);
            map.put("dwmc", dwmc);
            map.put("dwid", dwid);
            map.put("bmmc", bmmc);
            map.put("bmid", bmid);
            map.put("tbr", tbr);
            map.put("xclx", xclx);
            map.put("kssj", dealDateStrToString(kssj));
            map.put("jssj", dealDateStrToString(jssj));
            return ResultUtil.success(service.getYhxcList(map));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }

    /**
     * 将字符串类型的日期去除“-”，形成“yyyyMMdd”格式
     * @param dateStr
     * @return
     */
    public String dealDateStrToString(String dateStr){
        if(dateStr != null && !"".equals(dateStr)){
            return dateStr.replace("-", "");
        }
        return "";
    }

    /**
     * 将页码，页数放入Map
     * @param pageNum
     * @param pageSize
     */
    public Map dealPageParame(int pageNum, int pageSize){
        Map map = new HashMap();
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        return map;
    }

    @GetMapping("getBhList")
    @ApiOperation("获取病害（巡查上报）信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwmc", value = "单位名称"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwid", value = "单位ID"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bmmc", value = "部门名称"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bmid", value = "部门ID"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbr", value = "填报人"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "shlx", value = "损坏类型"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bhlx", value = "病害类型"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "stime", value = "开始时间"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "etime", value = "结束时间"),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getYhxcList(
            @RequestParam(value = "dwmc",required = false)String dwmc,
            @RequestParam(value = "dwid",required = false)String dwid,
            @RequestParam(value = "bmmc",required = false)String bmmc,
            @RequestParam(value = "bmid",required = false) String bmid,
            @RequestParam(value = "tbr",required = false) String tbr,
            @RequestParam(value = "shlx",required = false) String shlx,
            @RequestParam(value = "bhlx",required = false) String bhlx,
            @RequestParam(value = "stime",required = false) String stime,
            @RequestParam(value = "etime",required = false) String etime,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            Map map = dealPageParame(pageNum, pageSize);
            map.put("dwmc", dwmc);
            map.put("dwid", dwid);
            map.put("bmmc", bmmc);
            map.put("bmid", bmid);
            map.put("tbr", tbr);
            map.put("shlx", shlx);
            map.put("bhlx", bhlx);
            map.put("stime", dealDateStrToString(stime));
            map.put("etime", dealDateStrToString(etime));
            return ResultUtil.success(service.getBhList(map));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }

    @GetMapping("getBhListByDW")
    @ApiOperation("根据单位（现在是单位名称）查询待下任务单的病害（事件/巡查上报）")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query", dataType = "String", name = "dw", value = "单位", required = true)
    })
    public Msg getBhListByDW(@RequestParam(value = "dw",required = false)String dw){
        try {
            return ResultUtil.success(service.getBhListByDW(dw));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }

    /**
     * 编辑病害信息
     * （中间方法，无需调用）主要是在添加“小修任务 - 养护任务单”时，对病害增加任务单ID（YHRWD_DJBH）
     * @param yhrwd
     * @return
     */
    @PostMapping("updateBhData")
    @ApiOperation("（中间方法，无需调用）主要是在添加“小修任务 - 养护任务单”时，对病害增加任务单ID（YHRWD_DJBH）")
    public Msg updateBhData(@RequestBody YhrwdInsert yhrwd){
        try {
            if(yhrwd.getRwmxIdArr() != null && !"".equals(yhrwd.getRwmxIdArr())){
                yhrwd.setRwmxIdArr("'" + yhrwd.getRwmxIdArr().replace(",", "','") + "'");
                if (service.updateBhData(yhrwd)){
                    return ResultUtil.success("编辑成功！");
                }
            }
            return ResultUtil.error("编辑失败！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    /**
     * 添加“小修任务 - 养护任务单”数据
     * 在添加“小修任务 - 养护任务单”时，还需要对病害增加任务单ID（YHRWD_DJBH）
     * @param yhrwd
     * @return
     */
    @PostMapping("insertXxrwYhrwd")
    @ApiOperation("添加“小修任务 - 养护任务单”数据。在添加“小修任务 - 养护任务单”时，还需要对病害增加任务单ID（YHRWD_DJBH）")
    public Msg insertXxrwYhrwd(@RequestBody YhrwdInsert yhrwd){
        try {
            if(yhrwd.getRwmxIdArr() != null && !"".equals(yhrwd.getRwmxIdArr())) {
                yhrwd.setRwmxIdArr("'" + yhrwd.getRwmxIdArr().replace(",", "','") + "'");
                if (service.insertXxrwYhrwd(yhrwd)) {
                    return ResultUtil.success("添加成功！");
                }
            }
            return ResultUtil.error("添加失败！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @GetMapping("getXxrwYhrwdList")
    @ApiOperation("获取小修任务 - 养护任务单的数据列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "yhrwdrwdshzt", value = "养护任务单审核状态"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "yhrwdyszt", value = "验收状态"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "yhrwdyd", value = "月度(yyyy-MM/yyyyMM)"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "stime", value = "开始时间"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "etime", value = "结束时间"),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getXxrwYhrwdList(
            @RequestParam(value = "yhrwdrwdshzt",required = false)String yhrwdrwdshzt,
            @RequestParam(value = "yhrwdyszt",required = false)String yhrwdyszt,
            @RequestParam(value = "yhrwdyd",required = false)String yhrwdyd,
            @RequestParam(value = "stime",required = false) String stime,
            @RequestParam(value = "etime",required = false) String etime,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            Map map = dealPageParame(pageNum, pageSize);
            map.put("yhrwdrwdshzt", yhrwdrwdshzt);
            map.put("yhrwdyszt", yhrwdyszt);
            map.put("yhrwdyd", yhrwdyd);
            map.put("stime", dealDateStrToString(stime));
            map.put("etime", dealDateStrToString(etime));
            return ResultUtil.success(service.getXxrwYhrwdList(map));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }

    /**
     * 修改“小修任务 - 养护任务单”数据
     * 主要是修改养护任务单的审核/验收状态
     * @param yhrwddjbh
     * @param value
     * @param dealType
     * @return
     */
    @PostMapping("updateXxrwYhrwd")
    @ApiOperation("修改养护任务单的审核/验收状态")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "yhrwddjbh", value = "养护任务单 - 单据编号（主键）", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "value", value = "养护任务单的审核/验收状态的编码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dealType", value = "操作状态：sh审核/ys验收", required = true)
    })
    public Msg updateXxrwYhrwd(
            @RequestParam(value = "yhrwddjbh")String yhrwddjbh,
            @RequestParam(value = "value")String value,
            @RequestParam(value = "dealType")String dealType){
        try {
            if (service.updateXxrwYhrwd(yhrwddjbh, value, dealType)) {
                return ResultUtil.success("成功！");
            }
            return ResultUtil.error("失败！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    /**
     * 添加“小修任务 - 清扫任务单”数据
     * @param qsrwd
     * @return
     */
    @PostMapping("insertXxrwQsrwd")
    @ApiOperation("添加“小修任务 - 清扫任务单”数据，需要传所关联的“病害/事件/巡查上报”的ID，用于补齐信息")
    public Msg insertXxrwQsrwd(@RequestBody Qsrwd qsrwd){
        try {
            if (service.insertXxrwQsrwd(qsrwd)) {
                return ResultUtil.success("添加成功！");
            }
            return ResultUtil.error("添加失败！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    /**
     * 修改“小修任务 - 清扫任务单”的审核/清扫状态
     * @param qsrwdid 清扫任务单ID
     * @param value 具体数值
     * @param dealType ： 修改的列：sh审核/qs清扫
     * @return
     */
    @PostMapping("updateXxrwQsrwdShQszt")
    @ApiOperation("修改“小修任务 - 清扫任务单”的审核/清扫状态")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "qsrwdid", value = "清扫任务单 - 单据编号（主键）", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "value", value = "清扫任务单的审核/验收状态的编码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dealType", value = "操作状态：sh审核/qs清扫", required = true)
    })
    public Msg updateXxrwQsrwdShQszt(
            @RequestParam(value = "qsrwdid")String qsrwdid,
            @RequestParam(value = "value")String value,
            @RequestParam(value = "dealType")String dealType){
        try {
            if (service.updateXxrwQsrwdShQszt(qsrwdid, value, dealType)) {
                return ResultUtil.success("成功！");
            }
            return ResultUtil.error("失败！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @GetMapping("getQsrwdList")
    @ApiOperation("获取清扫任务单数据列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "qsrwdsjld", value = "清扫任务事件路段"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "qsrwdsjlx", value = "清扫任务事件类型"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "stime", value = "开始时间"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "etime", value = "结束时间"),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getQsrwdList(
            @RequestParam(value = "qsrwdsjld",required = false)String qsrwdsjld,
            @RequestParam(value = "qsrwdsjlx",required = false)String qsrwdsjlx,
            @RequestParam(value = "stime",required = false) String stime,
            @RequestParam(value = "etime",required = false) String etime,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            Map map = dealPageParame(pageNum, pageSize);
            map.put("qsrwdsjld", qsrwdsjld);
            map.put("qsrwdsjlx", qsrwdsjlx);
            map.put("stime", dealDateStrToString(stime));
            map.put("etime", dealDateStrToString(etime));
            return ResultUtil.success(service.getQsrwdList(map));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }

    @GetMapping("getWxsgzpjl")
    @ApiOperation("查询维修施工照片记录列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwmc", value = "单位名称"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwid", value = "单位ID"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bmmc", value = "部门名称"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bmid", value = "部门ID"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbr", value = "填报人"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "shlx", value = "损坏类型"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bhlx", value = "病害类型"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "stime", value = "开始时间"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "etime", value = "结束时间"),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getWxsgzpjl(
            @RequestParam(value = "dwmc",required = false)String dwmc,
            @RequestParam(value = "dwid",required = false)String dwid,
            @RequestParam(value = "bmmc",required = false)String bmmc,
            @RequestParam(value = "bmid",required = false) String bmid,
            @RequestParam(value = "tbr",required = false) String tbr,
            @RequestParam(value = "shlx",required = false) String shlx,
            @RequestParam(value = "bhlx",required = false) String bhlx,
            @RequestParam(value = "stime",required = false) String stime,
            @RequestParam(value = "etime",required = false) String etime,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            Map map = dealPageParame(pageNum, pageSize);
            map.put("dwmc", dwmc);
            map.put("dwid", dwid);
            map.put("bmmc", bmmc);
            map.put("bmid", bmid);
            map.put("tbr", tbr);
            map.put("shlx", shlx);
            map.put("bhlx", bhlx);
            map.put("stime", dealDateStrToString(stime));
            map.put("etime", dealDateStrToString(etime));
            return ResultUtil.success(service.getWxsgzpjl(map));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }

    @GetMapping("getWxsgzpjlByHtAndYd")
    @ApiOperation("查询维修施工照片记录列表（用于计量工程单查询明细）HT-CS-20180000009 + 2018-12")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htxxhtbh", value = "合同编号", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "yd", value = "月度（yyyy-MM）", required = true)
    })
    public Msg getWxsgzpjlByHtAndYd(
            @RequestParam(value = "htxxhtbh",required = false)String htxxhtbh,
            @RequestParam(value = "yd",required = false)String yd){
        try {
            Map map = new HashMap();
            map.put("htxxhtbh", htxxhtbh);
            map.put("yd", dealDateStrToString(yd));
            return ResultUtil.success(service.getWxsgzpjlByHtAndYd(map));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }

    @GetMapping("getJlgcMx2ByHtAndYd")
    @ApiOperation("计量工程明细，表2（用于计量工程单查询明细）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htxxhtbh", value = "合同编号", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htxxhtmc", value = "合同名称", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "yd", value = "月度（yyyy-MM）", required = true)
    })
    public Msg getJlgcMx2ByHtAndYd(
            @RequestParam(value = "htxxhtbh",required = false)String htxxhtbh,
            @RequestParam(value = "htxxhtmc",required = false)String htxxhtmc,
            @RequestParam(value = "yd",required = false)String yd){
        try {
            Map map = new HashMap();
            map.put("htxxhtbh", htxxhtbh);
            map.put("htxxhtmc", htxxhtmc);
            map.put("yd", dealDateStrToString(yd));
            return ResultUtil.success(service.getJlgcMx2ByHtAndYd(map));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }

    /**
     * 添加“养护/清扫任务单子表”数据
     * @param bean
     * @return
     */
    @PostMapping("insertRwdSubsidiary")
    @ApiOperation("添加“养护/清扫任务单子表”数据")
    public Msg insertRwdSubsidiary(@RequestBody RwdSubsidiary bean){
        try {
            if (service.insertRwdSubsidiary(bean)) {
                return ResultUtil.success("添加成功！");
            }
            return ResultUtil.error("添加失败！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    /**
     * 根据“任务单ID”删除“养护/清扫任务单子表”数据
     * @param rwdid
     * @return
     */
    @ApiOperation(value = "根据“任务单ID”删除“养护/清扫任务单子表”数据")
    @RequestMapping(value = "deleteRwdSubsidiaryByRwdid", method = RequestMethod.DELETE)
    @ApiImplicitParam(name = "rwdid", value = "其所属（清扫/养护）任务单ID", dataType = "string", paramType = "query",required = true)
    public Msg deleteRwdSubsidiaryByRwdid(@RequestParam("rwdid") String rwdid) {
        try {
            if (service.deleteRwdSubsidiaryByRwdid(rwdid)) {
                return ResultUtil.success("删除成功！");
            }
            return ResultUtil.error("删除失败！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    /**
     * 根据“月度计划ID”查询其所属合同的子目下拉框
     * @param yhijid
     * @return
     */
    @GetMapping("getZmxxByYdjhID")
    @ApiOperation("根据“月度计划ID”查询其所属合同的子目下拉框")
    @ApiImplicitParams({@ApiImplicitParam(paramType="query", dataType = "String", name = "yhijid", value = "月度计划ID，测试ID：'lyjc1551066927707', 'lyjc1551053949129'", required = true)})
    public Msg getZmxxByYdjhID(@RequestParam(value = "yhijid",required = false) String yhijid){
        try {
            return ResultUtil.success(service.getZmxxByYdjhID(yhijid));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }

}
