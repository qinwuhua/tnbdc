package com.hdsx.common.controller;

import com.hdsx.common.entity.Msg;
import com.hdsx.common.service.BaseService;
import com.hdsx.common.service.ZlglkhxzService;
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
import java.util.HashMap;

/**
 * @author LiRui
 * @created 2019/3/1 0001
 */
@RestController
@Api(value = "质量管理考核表")
@RequestMapping("common")
public class ZlglkhbController {

    @Resource
    private ZlglkhxzService zlglkhxzService;


    @GetMapping("getAll")
    @ApiOperation(value = "创建组织域下拉框")
    public Msg getAll(){
        try {
            return ResultUtil.success(zlglkhxzService.getAll());
        }catch (Exception e){
            return ResultUtil.error("接口异常！");
        }
    }


    @GetMapping("GetAllByGcxm")
    @ApiOperation("根据“工程项目”查询其所能进行的“月度计划”列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType="query", dataType = "String", name = "gcxm", value = "工程项目")})
    public Msg GetAllByGcxm(@RequestParam(value = "gcxm",required = false) String gcxm){
        try {
            HashMap<String,String> paramMap = new HashMap<>();
            paramMap.put("gcxm",gcxm);
            return ResultUtil.success(zlglkhxzService.GetAllByGcxm(paramMap));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }

}
