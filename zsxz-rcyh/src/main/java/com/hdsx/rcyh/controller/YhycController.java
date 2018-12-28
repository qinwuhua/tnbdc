package com.hdsx.rcyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.Gcyhysd;
import com.hdsx.rcyh.entity.Gcyssqd;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.service.YhycService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("yhyc")
@Api(value = "日常养护工程-养护验收",description = "养护验收控制器")
public class YhycController {

    @Resource
    private YhycService yhycService;

    @GetMapping("getGcyssqdAll")
    @ApiOperation("查询验收申请单所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htmc", value = "项目名称"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "spzt", value = "状态"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期"),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getGcyssqdAll(@RequestParam(value = "djbh", required = false)String djbh,
                             @RequestParam(value = "htmc",required = false)String htmc,
                             @RequestParam(value = "spzt",required = false)String spzt,
                             @RequestParam(value = "ksrq",required = false)String ksrq,
                             @RequestParam(value = "jsrq",required = false) String jsrq,
                             @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            HashMap<String,String> paramMap = new HashMap<>();
            paramMap.put("djbh",djbh);paramMap.put("htmc",htmc);paramMap.put("spzt",spzt);paramMap.put("ksrq",ksrq);paramMap.put("jsrq",jsrq);
            return ResultUtil.success(new PageInfo<>(yhycService.getGcyssqdAll(paramMap,pageNum,pageSize)));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口错误！");
        }
    }

    @GetMapping("getGcyssqdByDjbh")
    @ApiOperation("根据单据编码查询验收申请单信息")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号" ,required = true)
    public Msg getGcyssqdByDjbh(@RequestParam("djbh")String djbh){
        try {
            return ResultUtil.success(yhycService.getGcyssqdByDjbh(djbh));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口出错！");
        }
    }

    @PostMapping("addGcyssqd")
    @ApiOperation(value = "添加养护验收申请单数据")
    public Msg addGcyssqd(@RequestBody Gcyssqd gcyssqd){
        try {
            if (yhycService.addGcyssqd(gcyssqd) > 0){
                return ResultUtil.success("添加信息成功！");
            }else {
                return ResultUtil.error("添加信息失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @PutMapping("updateGcyssqd")
    @ApiOperation(value = "更新养护验收申请单数据")
    public Msg updateGcyssqd(@RequestBody Gcyssqd gcyssqd){
        try {
            if (yhycService.updateGcyssqd(gcyssqd)>0){
                return ResultUtil.success("添加信息成功！");
            }else {
                return ResultUtil.error("添加信息失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @DeleteMapping("deleteGcyssqd")
    @ApiOperation(value = "删除养护工程验收申请单数据")
    @ApiImplicitParam(paramType="query", dataType = "array", name = "ids", value = "主键ID", allowMultiple = true ,required = true)
    public Msg deleteGcyssqd(@RequestParam("ids")String[] ids){
        try {
            if (yhycService.deleteGcyssqd(ids) > 0){
                return ResultUtil.success("删除成功！");
            }else {
                return ResultUtil.error("删除失败！");
            }
        }catch (Exception e){
            return ResultUtil.error("接口异常！");
        }
    }


    @GetMapping("getGcyhysdAll")
    @ApiOperation(value = "获取养护工程验收单所有数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htmc", value = "项目名称"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "spzt", value = "状态"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期"),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getGcyhysdAll(@RequestParam(value = "djbh", required = false)String djbh,
                             @RequestParam(value = "htmc",required = false)String htmc,
                             @RequestParam(value = "spzt",required = false)String spzt,
                             @RequestParam(value = "ksrq",required = false)String ksrq,
                             @RequestParam(value = "jsrq",required = false) String jsrq,
                             @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            HashMap<String,String> paramMap = new HashMap<>();
            paramMap.put("djbh",djbh);paramMap.put("htmc",htmc);paramMap.put("spzt",spzt);paramMap.put("ksrq",ksrq);paramMap.put("jsrq",jsrq);
            return ResultUtil.success(new PageInfo<>(yhycService.getGcyhysdAll(paramMap,pageNum,pageSize)));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口错误！");
        }
    }

    @PostMapping("addGcyhysd")
    @ApiOperation(value = "添加养护工程验收单数据")
    public Msg addGcyhysd(@RequestBody Gcyhysd gcyhysd){
        try {
            if (yhycService.addGcyhysd(gcyhysd) > 0){
                return ResultUtil.success("添加信息成功！");
            }else {
                return ResultUtil.error("添加信息失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @PutMapping("updateGcyhysd")
    @ApiOperation(value = "更新养护工程验收单数据")
    public Msg updateGcyhysd(@RequestBody Gcyhysd gcyhysd){
        try {
            if (yhycService.updateGcyhysd(gcyhysd) > 0){
                return ResultUtil.success("更新成功！");
            }else {
                return ResultUtil.error("更新失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口错误！");
        }
    }

    @DeleteMapping("deleteGcyhysd")
    @ApiOperation(value = "删除养护工程验收单数据")
    @ApiImplicitParam(paramType="query", dataType = "array", name = "ids", value = "单据编号", allowMultiple = true ,required = true)
    public Msg deleteGcyhysd(@RequestParam("ids")String[] ids){
        try {
            if (yhycService.deleteGcyhysd(ids) > 0){
                return ResultUtil.success("删除成功！");
            }else {
                return ResultUtil.error("删除失败！");
            }
        }catch (Exception e){
            e.printStackTrace();;
            return ResultUtil.error("接口错误！");
        }
    }
}
