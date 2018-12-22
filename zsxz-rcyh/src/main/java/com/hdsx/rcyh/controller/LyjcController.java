package com.hdsx.rcyh.controller;

import com.hdsx.rcyh.entity.Jczb;
import com.hdsx.rcyh.entity.Lyjc;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.service.LyjcService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(value = "日常养护-履约检查")
public class LyjcController{

    @Resource
    private LyjcService lyjcService;

    @GetMapping("getLyjcAll")
    @ApiOperation(value = "查询施工单位履约检查表所有信息")
    public Msg getLyjcAll(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            return ResultUtil.success(lyjcService.getLyjcAll(pageNum,pageSize));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @PostMapping("addLyjc")
    @ApiOperation(value = "添加履约检查信息")
    public Msg addLyjc(Lyjc lyjc){
        try {
            return ResultUtil.success(lyjcService.addLyjc(lyjc));
        }catch (Exception e){
            return ResultUtil.error("添加履约检查信息失败！");
        }
    }

    @DeleteMapping("deleteLyjc")
    @ApiOperation(value = "删除履约检查信息")
    public Msg deleteLyjc(@RequestParam("id") String id){
        try {
            return ResultUtil.success(lyjcService.deleteLyjc(id));
        }catch (Exception e){
            return ResultUtil.error("删除履约检查信息失败！");
        }
    }

    @PutMapping("updateLyjc")
    @ApiOperation(value = "更新履约检查信息")
    public Msg updateLyjc(Lyjc lyjc){
        try {
            return ResultUtil.success(lyjcService.updateLyjc(lyjc));
        }catch (Exception e){
            return ResultUtil.error("更新履约检查信息失败！");
        }
    }

    @GetMapping("getLyjcbmxById")
    @ApiOperation(value = "根据id查询履约检查表信息")
    public Msg getLyjcbmxById(@RequestParam("id") String id){
        try {
            return ResultUtil.success(lyjcService.getLyjcbmxById(id));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @GetMapping("getJczbAll")
    @ApiOperation(value = "查询进场准备情况检查表所有信息")
    public Msg getJczbAll(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            return ResultUtil.success(lyjcService.getJczbAll(pageNum,pageSize));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @PostMapping("addJczb")
    @ApiOperation(value = "添加进场准备检查信息")
    public Msg addLyjc(Jczb jczb){
        try {
            return ResultUtil.success(lyjcService.addJczb(jczb));
        }catch (Exception e){
            return ResultUtil.error("添加履约检查信息失败！");
        }
    }

    @DeleteMapping("deleteJczb")
    @ApiOperation(value = "删除履约检查信息")
    public Msg deleteJczb(@RequestParam("id") String id){
        try {
            return ResultUtil.success(lyjcService.deleteJczb(id));
        }catch (Exception e){
            return ResultUtil.error("删除履约检查信息失败！");
        }
    }

    @PutMapping("updateJczb")
    @ApiOperation(value = "更新进场准备信息")
    public Msg updateJczb(Jczb jczb){
        try {
            return ResultUtil.success(lyjcService.updateJczb(jczb));
        }catch (Exception e){
            return ResultUtil.error("更新履约检查信息失败！");
        }
    }

    @GetMapping("getJczbmxById")
    @ApiOperation(value = "根据id查询进场准备表信息")
    public Msg getJczbmxById(@RequestParam("id") String id){
        try {
            return ResultUtil.success(lyjcService.getJczbmxById(id));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @GetMapping("getFilesDataById")
    @ApiOperation(value = "根据id查询Files表信息")
    public Msg getFilesDataById(@RequestParam("id") String id){
        try {
            return ResultUtil.success(lyjcService.getFilesDataById(id));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }
}
