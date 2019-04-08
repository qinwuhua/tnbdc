package com.hdsx.rcyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.entity.Sjqs;
import com.hdsx.rcyh.entity.SjqsPZ;
import com.hdsx.rcyh.service.SjqsService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("sjyh/sjqs")
@Api(value = "事件清扫控制器",description = "事件清扫控制器")
public class SjqsController {

    @Resource
    private SjqsService sjqsService;

    @RequestMapping(value = "getSjqsrwList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "lxcode", value = "路线编码(Z817)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "xcfx", value = "行车方向(0301)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取事件清扫任务列表数据")
    public Msg getSjqsrwList(@RequestParam(value = "lxcode",required = false) String lxcode,
                               @RequestParam(value = "xcfx",required = false) String xcfx,
                               @RequestParam(value = "ksrq",required = false) String ksrq,
                               @RequestParam(value = "jsrq",required = false) String jsrq,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("lxcode",lxcode);param.put("xcfx",xcfx);param.put("ksrq",ksrq);param.put("jsrq",jsrq);
        List<Sjqs> list = sjqsService.getSjqsrwList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Sjqs>(list));
    }


    @ApiOperation(value = "添加事件清扫事件")
    @RequestMapping(value = "insertSjqs", method = RequestMethod.POST)
    @ResponseBody
    public Msg insertSjqs(@RequestBody Sjqs sjqs) {
        try {
            if (sjqsService.insertSjqs(sjqs) > 0) {
                return ResultUtil.success("添加信息成功！");
            } else {
                return ResultUtil.error("添加信息失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @ApiOperation(value = "添加事件清扫配置信息")
    @RequestMapping(value = "insertRcqsPZ", method = RequestMethod.POST)
    public Msg insertSjqsPZ(@RequestBody SjqsPZ sjqsPZ) {
        try {
            if (sjqsPZ.getId()!=null && sjqsPZ.getLxcode() != null && sjqsPZ.getQsry() != null && sjqsPZ.getQsxx() != null && sjqsPZ.getXcfx() != null) {
                return ResultUtil.success(sjqsService.insertSjqsPZ(sjqsPZ));
            } else {
                return ResultUtil.error("添加信息失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }
    @GetMapping("getSjqsPz")
    @ApiOperation("根据“人员”查询事件清扫配置信息”列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType="query", dataType = "String", name = "qsry", value = "人员", required = true)})
    public Msg getSjqsPz(@RequestParam(value = "qsry",required = false) String qsry){
        try {
            return ResultUtil.success(sjqsService.getSjqsPz(qsry));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }

}
