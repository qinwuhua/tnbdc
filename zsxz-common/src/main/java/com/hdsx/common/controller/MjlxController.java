package com.hdsx.common.controller;

import com.hdsx.common.entity.Msg;
import com.hdsx.common.service.MjlxService;
import com.hdsx.common.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(value = "枚举类型控制器")
@RequestMapping("common")
public class MjlxController {

    @Resource
    private MjlxService mjlxService;

    @GetMapping("getMjxx")
    @ApiOperation(value = "获取枚举信息")
    public Msg getMjxx(@RequestParam(value = "mjlxbm")String mjlxbm) {
        try {
            return ResultUtil.success(mjlxService.getMjxx(mjlxbm));
        }catch (Exception e) {
            return ResultUtil.error("枚举信息获取失败");
        }
    }

    @GetMapping("getBbxx")
    @ApiOperation(value = "获取版本信息")
    public Msg getBbxx() {
        try {
            return ResultUtil.success(mjlxService.getBbxx());
        }catch (Exception e) {
            return ResultUtil.error("获取方案信息出错");
        }
    }
}
