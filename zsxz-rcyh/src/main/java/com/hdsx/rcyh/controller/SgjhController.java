package com.hdsx.rcyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.entity.Sgjh;
import com.hdsx.rcyh.entity.Sgjhwc;
import com.hdsx.rcyh.service.SgjhService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("sgjh")
@Api(value = "日常养护工程-月度实施计划")
public class SgjhController {

    @Resource
    private SgjhService sgjhService;

    @GetMapping("getSgjhAll")
    @ApiOperation("获取月度施工计划所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "表单主键ID"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htmc", value = "项目名称"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "spzt", value = "状态"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期"),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getSgjhAll(
            @RequestParam(value = "id", required = false)String id,
            @RequestParam(value = "htmc",required = false)String htmc,
            @RequestParam(value = "spzt",required = false)String spzt,
            @RequestParam(value = "ksrq",required = false)String ksrq,
            @RequestParam(value = "jsrq",required = false) String jsrq,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
       try {
           HashMap<String,String> paramMap = new HashMap<>();
           paramMap.put("id",id);paramMap.put("htmc",htmc);paramMap.put("spzt",spzt);paramMap.put("ksrq",ksrq);paramMap.put("jsrq",jsrq);
           return ResultUtil.success(new PageInfo<>(sgjhService.getSgjhAll(paramMap,pageNum,pageSize)));
       }catch (Exception e){
           return ResultUtil.error("查询失败！");
       }
    }

    @PostMapping("addSgjh")
    @ApiOperation("添加月度施工计划信息")
    public Msg addSgjh(@RequestBody Sgjh sgjh){
        try {
            if (sgjhService.addSgjh(sgjh) > 0){
                return ResultUtil.success("查询成功！");
            }else {
                return ResultUtil.error("查询失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @PutMapping("upateSgjh")
    @ApiOperation("更新月度施工计划信息")
    public Msg upateSgjh(@RequestBody Sgjh sgjh){
        try {
            if (sgjhService.upateSgjh(sgjh) > 0){
                return ResultUtil.success("更新成功！");
            }else {
                return ResultUtil.error("更新失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @DeleteMapping("deleteSgjh")
    @ApiOperation("删除月度施工计划信息")
    public Msg deleteSgjh(@RequestParam("id")String id){
        try {
            if (sgjhService.deleteSgjh(id) > 0){
                return ResultUtil.success("删除成功！");
            }else {
                return ResultUtil.error("删除失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @GetMapping("getSgjhmxById")
    @ApiOperation("通过表单ID获取明细表内容")
    public Msg getSgjhmxById(@RequestParam("id")String id){
        try {
            return ResultUtil.success(sgjhService.getSgjhmxById(id));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @GetMapping("getWcSgjhAll")
    @ApiOperation("获取月度施工计划完成所有信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "表单主键ID"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htmc", value = "项目名称"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "spzt", value = "状态"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期"),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getWcSgjhAll(@RequestParam(value = "id",required = false)String id,
            @RequestParam(value = "htmc",required = false)String htmc,
            @RequestParam(value = "spzt",required = false)String spzt,
            @RequestParam(value = "ksrq",required = false)String ksrq,
            @RequestParam(value = "jsrq",required = false) String jsrq,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            HashMap<String,String> paramMap = new HashMap<>();
            paramMap.put("id",id);paramMap.put("htmc",htmc);paramMap.put("spzt",spzt);paramMap.put("ksrq",ksrq);paramMap.put("jsrq",jsrq);
            return ResultUtil.success(new PageInfo<>(sgjhService.getWcSgjhAll(paramMap,pageNum,pageSize)));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @PostMapping("addWcSgjh")
    @ApiOperation("添加月度施工计划信息")
    public Msg addWcsgjh(@RequestBody Sgjhwc sgjhwc){
        try {
            if (sgjhService.addWcSgjh(sgjhwc) > 0){
                return ResultUtil.success("查询成功！");
            }else {
                return ResultUtil.error("查询失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @PutMapping("upateWcSgjh")
    @ApiOperation("更新月度施工计划信息")
    public Msg upateWcsgjh(@RequestBody Sgjhwc sgjhwc){
        try {
            if (sgjhService.upateWcsgjh(sgjhwc) > 0){
                return ResultUtil.success("更新成功！");
            }else {
                return ResultUtil.error("更新失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @DeleteMapping("deleteWcSgjh")
    @ApiOperation("删除月度施工计划信息")
    public Msg deleteWcSgjh(@RequestParam("id")String id){
        try {
            if (sgjhService.deleteWcSgjh(id) > 0){
                return ResultUtil.success("删除成功！");
            }else {
                return ResultUtil.error("删除失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @GetMapping("getWcSgjhmxById")
    @ApiOperation("通过表单ID获取明细表内容")
    public Msg getWcSgjhmxById(@RequestParam("id")String id){
        try {
            return ResultUtil.success(sgjhService.getWcSgjhmxById(id));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

}