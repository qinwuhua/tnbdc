package com.hdsx.common.controller;

import com.hdsx.common.entity.Msg;
import com.hdsx.common.service.LxldService;
import com.hdsx.common.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(value = "路线路段控制器")
@RequestMapping("common")
public class LxldController {

    @Resource
    private LxldService lxldService;


    @GetMapping("getLd")
    @ApiOperation(value = "获取路段信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", defaultValue = "0101", name = "bmCode", value = "部门编码", required = true)
    })
    public Msg getLd(@RequestParam(value = "bmCode") String bmCode) {
        try {
            return ResultUtil.success(lxldService.getLd(bmCode));
        }catch (Exception e) {
            return ResultUtil.error("查询路段信息异常");
        }
    }
}
