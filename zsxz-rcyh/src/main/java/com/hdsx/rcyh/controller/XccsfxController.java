package com.hdsx.rcyh.controller;

import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.service.XccsfxService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(value = "日常养护-巡查次数分析")
@RequestMapping("/xccsfx")
public class XccsfxController {
    @Resource
    private XccsfxService xccsfxService;

    @ApiOperation(value = "查询日次数", httpMethod = "GET")
    @RequestMapping(value = "/queryDay/", method = {RequestMethod.GET})
    public Msg QueryDay() {
        try {
            System.out.println("1111111"+xccsfxService.selectDay());
            return ResultUtil.success(xccsfxService.selectDay());
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }


    @ApiOperation(value = "查询月次数", httpMethod = "GET")
    @RequestMapping(value = "/queryMonth/", method = {RequestMethod.GET})
    public Msg QueryMonth() {
        try {
            return ResultUtil.success(xccsfxService.selectMonth());
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }


    @ApiOperation(value = "查询年次数", httpMethod = "GET")
    @RequestMapping(value = "/queryYear/", method = {RequestMethod.GET})
    public Msg QueryYear() {
        try {
            return ResultUtil.success(xccsfxService.selectYear());
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

}
