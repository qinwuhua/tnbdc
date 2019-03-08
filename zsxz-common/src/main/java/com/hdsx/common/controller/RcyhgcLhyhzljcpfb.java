package com.hdsx.common.controller;

import com.hdsx.common.entity.Msg;
import com.hdsx.common.service.LhyhzljcpfbService;
import com.hdsx.common.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(value = "绿化养护质量检查评分表")
@RequestMapping("common")
public class RcyhgcLhyhzljcpfb {

    @Resource
    private LhyhzljcpfbService lhyhzljcpfbService;


    @GetMapping("getPfbAll")
    @ApiOperation(value = "获取绿化养护质量检查评分表")
    public Msg getAll() {
        try {
            return ResultUtil.success(lhyhzljcpfbService.getAll());
        }catch (Exception e) {
            return ResultUtil.error("查询信息异常");
        }
    }
}
