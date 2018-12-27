package com.hdsx.common.controller;

import com.hdsx.common.entity.Msg;
import com.hdsx.common.service.HtxxService;
import com.hdsx.common.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@Api(value = "合同信息")
@RequestMapping("common")
public class HtxxController {

    @Resource
    private HtxxService htxxService;

    @GetMapping("getHtxxAll")
    @ApiOperation(value = "查询合同信息")
    private Msg getHtxxAll(){
        try {
            return ResultUtil.success(htxxService.getHtxxAll());
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @GetMapping("getHtxxLyjcAll")
    @ApiOperation(value = "查询履约检查合同信息")
    private Msg getHtxxLyjcAll(){
        try {
            return ResultUtil.success(htxxService.getHtxxLyjcAll());
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @GetMapping("getHtgjxxAll")
    @ApiOperation(value = "查询合同关键信息")
    private Msg getHtgjxxAll(){
        try {
            return ResultUtil.success(htxxService.getHtgjxxAll());
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @GetMapping("getHtxxYhAll")
    @ApiOperation(value = "查询养护项目合同信息")
    private Msg getHtxxYhAll(){
        try {
            return ResultUtil.success(htxxService.getHtxxYhAll());
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @GetMapping("getHtxxRelatedAll")
    @ApiOperation(value = "查询合同全部相关信息")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号")
    private Msg getHtxxRelatedAll(@RequestParam(value = "htbh",required = false)String htbh){
        try {
            HashMap<String,String> paramMap = new HashMap<>();
            paramMap.put("htbh",htbh);
            return ResultUtil.success(htxxService.getHtxxRelatedAll(paramMap));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }
}
