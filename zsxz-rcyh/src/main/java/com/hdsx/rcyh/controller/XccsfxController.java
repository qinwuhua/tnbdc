package com.hdsx.rcyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.service.XccsfxService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @RequestMapping(value = "/queryDay/", method = {RequestMethod.GET})
    public Msg QueryDay(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        try {
            return ResultUtil.success(new PageInfo<>(xccsfxService.selectDay(pageNum,pageSize)));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }

    }


    @ApiOperation(value = "查询月次数", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @RequestMapping(value = "/queryMonth/", method = {RequestMethod.GET})
    public Msg QueryMonth(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        try {
            return ResultUtil.success(new PageInfo<>(xccsfxService.selectMonth(pageNum,pageSize)));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }

    }

    @ApiOperation(value = "查询年次数", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @RequestMapping(value = "/queryYear/", method = {RequestMethod.GET})
    public Msg QueryYear(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        try {
            return ResultUtil.success(new PageInfo<>(xccsfxService.selectYear(pageNum,pageSize)));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }

    }

}
