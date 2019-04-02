package com.hdsx.rcyh.controller;

import com.hdsx.rcyh.entity.*;
import com.hdsx.rcyh.service.AppRcyhSjdjService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * APP - 日常养护接口
 * @author LiRui
 * @created 2019/2/26 0026
 */

@RestController
@RequestMapping("appRcyh")
@Api(value = "APP接口 - 日常养护",description = "APP接口 - 日常养护：2019-02-26")
public class AppRcyhSjdjController {

    @Resource
    private AppRcyhSjdjService service;

    /**
     * （单条）事件登记
     * @param bean
     * @return
     */
    @PostMapping("insertSj")
    @ApiOperation("（单条）病害登记")
    public Msg insertSj(@RequestBody RcyhSjdj bean){
        try {
            if (service.insertSj(bean)){
                return ResultUtil.success("（单条）事件已登记！");
            }
            return ResultUtil.error("（单条）事件登记异常！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    /**
     * （批量）事件登记
     * @param list
     * @return
     */
    @PostMapping("batchInsertSj")
    @ApiOperation("（批量）病害登记")
    public Msg batchInsertSj(@RequestBody List<RcyhSjdj> list){
        try {
            if (service.batchInsertSj(list)){
                return ResultUtil.success("（批量）事件已登记！");
            }
            return ResultUtil.error("（批量）事件登记异常！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    /**
     * 任务单维修（更新“（清扫/日常）任务单子表”的“维修时间/维修状态”）
     * @param bean
     * @return
     */
    @PostMapping("updateRwdSubsidiaryWx")
    @ApiOperation("任务单维修（更新“（清扫/日常）任务单子表”的“维修时间/维修状态”）")
    public Msg updateRwdSubsidiaryWx(@RequestBody RwdSubsidiary bean){
        try {
            if (service.updateRwdSubsidiaryWx(bean)){
                return ResultUtil.success("更新成功！");
            }
            return ResultUtil.error("更新失败！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    /**
     * 添加/上传“启动巡查”数据
     * @param bean
     * @return
     */
    @PostMapping("insertQdxc")
    @ApiOperation("添加/上传“启动巡查”数据")
    public Msg insertQdxc(@RequestBody AppRcyhQdxc bean){
        try {
            if (service.insertQdxc(bean)){
                return ResultUtil.success("“启动巡查”数据上传成功！");
            }
            return ResultUtil.error("“启动巡查”数据上传异常！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    /**
     * 根据“人员ID”查询其所应做的养护/清扫任务信息（病害/事件）
     * @param ryid
     * @return
     */
    @GetMapping("getBhrwByRyid")
    @ApiOperation("根据“人员ID”查询其所应做的养护/清扫任务信息（病害/事件）")
    @ApiImplicitParams({@ApiImplicitParam(paramType="query", dataType = "String", name = "ryid", value = "人员ID", required = true)})
    public Msg getBhrwByRyid(@RequestParam(value = "ryid",required = false) String ryid){
        try {
            return ResultUtil.success(service.getBhrwByRyid(ryid));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }

    /**
     * 根据“人员ID”查询其所能进行的“月度计划”列表
     * @param ryid
     * @return
     */
    @GetMapping("getYhjhByRyid")
    @ApiOperation("根据“人员ID”查询其所能进行的“月度计划”列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType="query", dataType = "String", name = "ryid", value = "人员ID", required = true)})
    public Msg getYhjhByRyid(@RequestParam(value = "ryid",required = false) String ryid){
        try {
            return ResultUtil.success(service.getYhjhByRyid(ryid));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }


    /**
     * （单条）事件登记
     * @param qdxcPzdj
     * @return
     */
    @PostMapping("insertPZ")
    @ApiOperation("配置登记")
    public Msg insertPZ(@RequestBody QdxcPzdj qdxcPzdj){
        try {
            if (qdxcPzdj.getKssj()!= null && qdxcPzdj.getQqzh()!= null && qdxcPzdj.getXccl()!= null && qdxcPzdj.getId()!= null && qdxcPzdj.getXcfx()!= null && qdxcPzdj.getLx()!= null && qdxcPzdj.getXclx()!= null && qdxcPzdj.getXcry()!= null){
                return ResultUtil.success(service.insertPZ(qdxcPzdj));
            }
            return ResultUtil.error("（配置登记异常！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @GetMapping("getQdxcPz")
    @ApiOperation("根据“人员”查询配置信息”列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType="query", dataType = "String", name = "xcry", value = "人员", required = true)})
    public Msg getQdxcPz(@RequestParam(value = "xcry",required = false) String ry){
        try {
            return ResultUtil.success(service.getQdxcPz(ry));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }
}
