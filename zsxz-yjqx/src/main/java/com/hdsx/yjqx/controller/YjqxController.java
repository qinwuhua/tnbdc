package com.hdsx.yjqx.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.yjqx.entity.Msg;
import com.hdsx.yjqx.entity.Yjqx;
import com.hdsx.yjqx.service.YjqxService;
import com.hdsx.yjqx.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@RestController
@RequestMapping("yjqx")
@Api(value = "应急抢修工程", description = "应急抢修控制器")
public class YjqxController {

    @Resource
    private YjqxService yjqxService;

    @PostMapping("addYjqxgc")
    @ApiOperation(value = "添加应急抢修工程")
    public Msg addYjqxgc(@RequestBody Yjqx yjqx){
       try {
           if (yjqxService.addYjqxgc(yjqx) > 0){
               return ResultUtil.success("查询成功");
           }else {
               return ResultUtil.error("查询失败！");
           }
       }catch (Exception e){
           e.printStackTrace();
           return ResultUtil.error("接口错误！");
       }
    }

    @PutMapping("editYjqxgc")
    @ApiOperation(value = "编辑应急抢修工程")
    public Msg editYjqxgc(@RequestBody Yjqx yjqx){
        try {
            if (yjqxService.editYjqxgc(yjqx) > 0){
                return ResultUtil.success("更新成功！");
            }else {
                return ResultUtil.error("更新失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口错误！");
        }
    }

    @DeleteMapping("delYjqxgcByIds")
    @ApiOperation(value = "根据ID删除应急抢修工程")
    @ApiImplicitParam(paramType="query", dataType = "array", name = "ids", value = "主键ID", allowMultiple = true, required = true)
    public Msg delYjqxgcByIds(@RequestParam("ids") String[] ids){
        try {
            if (yjqxService.delYjqxgcByIds(ids) > 0){
                return ResultUtil.success("删除成功！");
            }else {
                return ResultUtil.error("删除失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口错误！");
        }
    }

    @GetMapping("getYjqxgcList")
    @ApiOperation(value = "查询应急抢修工程信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "djbh", value = "单据编号"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "gcmc", value = "工程名称"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "fx", value = "行车方向"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "ksrq", value = "开始日期"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "jsrq", value = "结束日期"),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getYjqxgcList(@RequestParam(value = "djbh", required = false)String djbh,
                             @RequestParam(value = "gcmc",required = false)String gcmc,
                             @RequestParam(value = "fx",required = false)String fx,
                             @RequestParam(value = "ksrq",required = false)String ksrq,
                             @RequestParam(value = "jsrq",required = false) String jsrq,
                             @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            HashMap<String, String> paramMap = new HashMap<>();
            paramMap.put("djbh",djbh);paramMap.put("gcmc",gcmc);paramMap.put("fx",fx);paramMap.put("ksrq",ksrq);paramMap.put("jsrq",jsrq);
            return ResultUtil.success(new PageInfo<>(yjqxService.getYjqxgcList(paramMap,pageNum,pageSize)));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口错误！");
        }
    }


}
