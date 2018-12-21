package com.hdsx.rcyh.controller;

import com.hdsx.rcyh.entity.Lyjc;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.service.LyjcService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(value = "日常养护-履约检查")
public class LyjcController{

    @Resource
    private LyjcService lyjcService;

    @GetMapping("getLyjcAll")
    @ApiOperation(value = "查询施工单位履约检查表所有信息")
    public Msg getLyjcAll(){
        try {
            return ResultUtil.success(lyjcService.getLyjcAll());
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @GetMapping("getDjsjHtxx")
    @ApiOperation(value = "查询对接数据合同信息")
    public Msg getDjsjHtxx(){
        try {
            return ResultUtil.success(lyjcService.getDjsjHtxx());
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @GetMapping("getDjsjLyjcmx")
    @ApiOperation(value = "查询对接数据履约检查信息")
    public Msg getDjsjLyjcmx(){
        try {
            return ResultUtil.success(lyjcService.getDjsjLyjcmx());
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @PostMapping("addLyjc")
    @ApiOperation(value = "添加履约检查信息")
    public Msg AddLyjc(Lyjc lyjc){
        try {
            return ResultUtil.success(lyjcService.addLyjc(lyjc));
        }catch (Exception e){
            return ResultUtil.error("添加履约检查信息失败！");
        }
    }

}
