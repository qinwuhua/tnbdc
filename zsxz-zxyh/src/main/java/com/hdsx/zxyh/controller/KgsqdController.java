package com.hdsx.zxyh.controller;


import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.service.KgsqdService;
import com.hdsx.zxyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 开工申请控制器
 */
@RestController
@RequestMapping("kgsqd")
@Api(value = "开工申请")
public class KgsqdController {

    @Resource
    private KgsqdService kgsqdService;

    @GetMapping("getAll")
    @ApiOperation("获取所有开工申请单")
    public Msg getAll() {
        try {
            return ResultUtil.success(kgsqdService.getAll());
        }catch (Exception e) {
            return ResultUtil.error("开工申请单请求失败！");
        }
    }
}
