package com.hdsx.rcyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.Jczb;
import com.hdsx.rcyh.entity.Lyjc;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.service.LyjcService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(value = "日常养护-履约检查")
public class LyjcController{

    @Resource
    private LyjcService lyjcService;

    @GetMapping("getLyjcAll")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询施工单位履约检查表所有信息")
    public Msg getLyjcAll(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            return ResultUtil.success(new PageInfo<>(lyjcService.getLyjcAll(pageNum,pageSize)));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }

    }

    @PostMapping("addLyjc")
    @ApiOperation(value = "添加履约检查信息")
    public Msg addLyjc(@RequestBody Lyjc lyjc){
        try {
            if (lyjcService.addLyjc(lyjc)){
                return ResultUtil.success("添加信息成功！");
            }else {
                return ResultUtil.error("添加信息失败！");
            }
        }catch (Exception e){
            return ResultUtil.error("添加信息失败！");
        }
    }

    @DeleteMapping("deleteLyjc")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "主键ID", required = true)
    })
    @ApiOperation(value = "删除履约检查信息")
    public Msg deleteLyjc(@RequestParam("id") String id){
        try {
            if (lyjcService.deleteLyjc(id)){
                return ResultUtil.success("删除信息成功！");
            }else {
                return ResultUtil.error("删除信息失败！");
            }
        }catch (Exception e){
            return ResultUtil.error("删除信息失败！");
        }
    }

    @PutMapping("updateLyjc")
    @ApiOperation(value = "更新履约检查信息")
    public Msg updateLyjc(@RequestBody Lyjc lyjc){
        try {
            if (lyjcService.updateLyjc(lyjc)){
                return ResultUtil.success("更新信息成功！");
            }else {
                return ResultUtil.error("更新信息失败！");
            }
        }catch (Exception e){
            return ResultUtil.error("更新信息失败！");
        }
    }

    @GetMapping("getLyjcbmxById")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "主键ID", required = true)
    @ApiOperation(value = "根据id查询履约检查表信息")
    public Msg getLyjcbmxById(@RequestParam("id") String id){
        try {
            return ResultUtil.success(lyjcService.getLyjcbmxById(id));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @GetMapping("getJczbAll")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询进场准备情况检查表所有信息")
    public Msg getJczbAll(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            return ResultUtil.success(new PageInfo<>(lyjcService.getJczbAll(pageNum,pageSize)));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @PostMapping("addJczb")
    @ApiOperation(value = "添加进场准备检查信息")
    public Msg addLyjc(@RequestBody Jczb jczb){
        try {
            if (lyjcService.addJczb(jczb)){
                return ResultUtil.success("添加信息成功！");
            }else {
                return ResultUtil.error("添加信息失败！");
            }
        }catch (Exception e){
            return ResultUtil.error("添加信息失败！");
        }
    }

    @DeleteMapping("deleteJczb")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "主键ID", required = true)
    })
    @ApiOperation(value = "删除履约检查信息")
    public Msg deleteJczb(@RequestParam("id") String id){
        try {
            if (lyjcService.deleteJczb(id)){
                return ResultUtil.success("添加信息成功！");
            }else {
                return ResultUtil.error("添加信息失败！");
            }
        }catch (Exception e){
            return ResultUtil.error("添加信息失败！");
        }
    }

    @PutMapping("updateJczb")
    @ApiOperation(value = "更新进场准备信息")
    public Msg updateJczb(@RequestBody Jczb jczb){
        try {
            if (lyjcService.updateJczb(jczb)){
                return ResultUtil.success("添加信息成功！");
            }else {
                return ResultUtil.error("添加信息失败！");
            }
        }catch (Exception e){
            return ResultUtil.error("添加信息失败！");
        }
    }

    @GetMapping("getJczbmxById")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "主键ID", required = true)
    @ApiOperation(value = "根据id查询进场准备表信息")
    public Msg getJczbmxById(@RequestParam("id") String id){
        try {
            return ResultUtil.success(lyjcService.getJczbmxById(id));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

}
