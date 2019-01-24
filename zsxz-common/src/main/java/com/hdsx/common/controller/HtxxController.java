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
