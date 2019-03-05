package com.hdsx.zxyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.Jczb;
import com.hdsx.zxyh.entity.Lyjc;
import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.service.LyjcService;
import com.hdsx.zxyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("zxyh/lyjc")
@Api(value = "履约检查", description = "履约检查控制器")
public class LyjcController {

    @Resource
    private LyjcService lyjcService;

    @GetMapping("getLyjcAll")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "表单主键ID"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htmc", value = "项目名称"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "spzt", value = "状态"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期"),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询施工单位履约检查表所有信息")
    public Msg getLyjcAll(@RequestParam(value = "id", required = false)String id,
                          @RequestParam(value = "htmc",required = false)String htmc,
                          @RequestParam(value = "spzt",required = false)String spzt,
                          @RequestParam(value = "ksrq",required = false)String ksrq,
                          @RequestParam(value = "jsrq",required = false) String jsrq,
                          @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            HashMap<String,String> paramMap = new HashMap<>();
            paramMap.put("id",id);paramMap.put("htmc",htmc);paramMap.put("spzt",spzt);paramMap.put("ksrq",ksrq);paramMap.put("jsrq",jsrq);
            return ResultUtil.success(new PageInfo<>(lyjcService.getLyjcAll(paramMap,pageNum,pageSize)));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }

    }

    @PostMapping("addLyjc")
    @ApiOperation(value = "添加履约检查信息")
    public Msg addLyjc(@RequestBody Lyjc lyjc){
        try {
            if (lyjcService.addLyjc(lyjc)>0){
                return ResultUtil.success("添加信息成功！");
            }else {
                return ResultUtil.error("添加信息失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @DeleteMapping("deleteLyjc")
    @ApiImplicitParam(paramType="query", dataType = "array", name = "ids", value = "主键ID", allowMultiple = true, required = true)
    @ApiOperation(value = "删除履约检查信息")
    public Msg deleteLyjc(@RequestParam("ids") String[] ids){
        try {
            if (lyjcService.deleteLyjc(ids)>0){
                return ResultUtil.success("删除信息成功！");
            }else {
                return ResultUtil.error("删除信息失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }


    @PutMapping("updateLyjc")
    @ApiOperation(value = "更新履约检查信息")
    public Msg updateLyjc(@RequestBody Lyjc lyjc){
        try {
            if (lyjcService.updateLyjc(lyjc)>0){
                return ResultUtil.success("更新信息成功！");
            }else {
                return ResultUtil.error("更新信息失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @GetMapping("getLyjcbmxByMid")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "主键ID", required = true)
    @ApiOperation(value = "根据id查询履约检查表信息")
    public Msg getLyjcbmxByMid(@RequestParam("id") String id){
        try {
            return ResultUtil.success(lyjcService.getLyjcbmxByMid(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @GetMapping("getJczbAll")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "表单主键ID"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htmc", value = "项目名称"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "spzt", value = "状态"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期"),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询进场准备情况检查表所有信息")
    public Msg getJczbAll(@RequestParam(value = "id", required = false)String id,
                          @RequestParam(value = "htmc",required = false)String htmc,
                          @RequestParam(value = "spzt",required = false)String spzt,
                          @RequestParam(value = "ksrq",required = false)String ksrq,
                          @RequestParam(value = "jsrq",required = false) String jsrq,
                          @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            HashMap<String,String> paramMap = new HashMap<>();
            paramMap.put("id",id);paramMap.put("htmc",htmc);paramMap.put("spzt",spzt);paramMap.put("ksrq",ksrq);paramMap.put("jsrq",jsrq);
            return ResultUtil.success(new PageInfo<>(lyjcService.getJczbAll(paramMap, pageNum, pageSize)));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！！");
        }
    }

    @PostMapping("addJczb")
    @ApiOperation(value = "添加进场准备检查信息")
    public Msg addLyjc(@RequestBody Jczb jczb){
        try {
            if (lyjcService.addJczb(jczb)>0){
                return ResultUtil.success("添加信息成功！");
            }else {
                return ResultUtil.error("添加信息失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！！");
        }
    }

    @DeleteMapping("deleteJczb")
    @ApiImplicitParam(paramType="query", dataType = "array", name = "ids", value = "主键ID", allowMultiple = true, required = true)
    @ApiOperation(value = "删除履约检查信息")
    public Msg deleteJczb(@RequestParam("ids") String[] ids){
        try {
            if (lyjcService.deleteJczb(ids)>0){
                return ResultUtil.success("添加信息成功！");
            }else {
                return ResultUtil.error("添加信息失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！！");
        }
    }

    @PutMapping("updateJczb")
    @ApiOperation(value = "更新进场准备信息")
    public Msg updateJczb(@RequestBody Jczb jczb){
        try {
            if (lyjcService.updateJczb(jczb)>0){
                return ResultUtil.success("添加信息成功！");
            }else {
                return ResultUtil.error("添加信息失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！！");
        }
    }

    @GetMapping("getJczbmxById")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "主键ID", required = true)
    @ApiOperation(value = "根据id查询进场准备表信息")
    public Msg getJczbmxById(@RequestParam("id") String id){
        try {
            return ResultUtil.success(lyjcService.getJczbmxById(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！！");
        }
    }

    @DeleteMapping("deleteLyjcmxbByIds")
    @ApiOperation(value = "根据主键ID删除履约检查明细表")
    @ApiImplicitParam(paramType="query", dataType = "array", name = "ids", value = "主键ID", allowMultiple = true, required = true)
    public Msg deleteLyjcmxb(@RequestParam("ids")String[] ids){
        try {
            if (lyjcService.deleteLyjcmxbByIds(ids) > 0){
                return ResultUtil.success("删除成功！");
            }else {
                return ResultUtil.error("删除失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口错误！");
        }
    }

    @DeleteMapping("deleteJczbmxByIds")
    @ApiOperation(value = "根据主键ID删除进场准备明细表")
    @ApiImplicitParam(paramType="query", dataType = "array", name = "ids", value = "主键ID", allowMultiple = true, required = true)
    public Msg deleteJczbmxByIds(@RequestParam("ids")String[] ids){
        try {
            if (lyjcService.deleteJczbmxByIds(ids) > 0){
                return ResultUtil.success("删除成功！");
            }else {
                return ResultUtil.error("删除失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口错误！");
        }
    }

}
