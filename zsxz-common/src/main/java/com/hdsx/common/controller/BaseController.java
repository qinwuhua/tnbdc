package com.hdsx.common.controller;

import com.hdsx.common.entity.Msg;
import com.hdsx.common.service.BaseService;
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
import java.util.Map;

/**
 * @author LiRui
 * @created 2019/3/1 0001
 */
@RestController
@Api(value = "基础信息")
@RequestMapping("common")
public class BaseController {

    @Resource
    private BaseService service;

    /**
     * 创建组织域下拉框
     * @return
     */
    @GetMapping("createZzxxList")
    @ApiOperation(value = "创建组织域下拉框")
    public Msg createZzxxList(){
        try {
            return ResultUtil.success(service.createZzxxList());
        }catch (Exception e){
            return ResultUtil.error("接口异常！");
        }
    }

    /**
     * 根据公司ID查人员信息
     * @param gsid
     * @return
     */
    @GetMapping("createRyxxList")
    @ApiOperation("根据“人员ID”查询其所能进行的“月度计划”列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType="query", dataType = "String", name = "gsid", value = "人员ID")})
    public Msg createRyxxList(@RequestParam(value = "gsid",required = false) String gsid){
        try {
            return ResultUtil.success(service.createRyxxList(gsid));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }

}
