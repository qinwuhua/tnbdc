package com.hdsx.lkpd.controller;

import com.hdsx.lkpd.entity.Msg;
import com.hdsx.lkpd.service.TestService;
import com.hdsx.lkpd.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(value = "测试类")
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("test")
    @ApiOperation(value = "测试方法")
    public Msg test() {
        try {
            return ResultUtil.success(testService.test());
        } catch (Exception e) {
            return ResultUtil.error("请求失败");
        }

    }
}
