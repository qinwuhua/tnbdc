package com.hdsx.rcyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.*;
import com.hdsx.rcyh.service.JgjsService;
import com.hdsx.rcyh.service.JlzfService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("rcyh/jgjszf")
@Api(value = "交工结算控制器",description = "交工结算控制器")
public class JgjsController {

    @Resource
    private JgjsService jgjsService;
    @RequestMapping(value = "getHtJgInfoByBm", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取合同详细信息(交工结算)")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false)
    public Msg getHtCwInfoByBm(@RequestParam(value = "htbh",required = false) String htbh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("htbh", htbh);
            List<Jgjs> map=jgjsService.getHtCwInfoByBm(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }


    @RequestMapping(value = "addJgjssForJgjs", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加交工结算书")
    public Msg addJgjssForJlzf(@RequestBody Jgjs jgjs){
        try {
            int flag=jgjsService.addJgjssForJgjs(jgjs);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "editJgjssForJgjs", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑交工结算书")
    public Msg editJgjssForJgjs(@RequestBody Jgjs jgjs){
        try {
            int flag=jgjsService.editJgjssForJgjs(jgjs);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delJgjssForJgjs", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除交工结算书")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "pmmtjgjss_jssbhs", value = "结算书编号(以“,”隔开)", required = true)
    public Msg delJgjssForJgjs(@RequestParam(value = "pmmtjgjss_jssbhs",required = true) String pmmtjgjss_jssbhs){
        try {
            String[] pmmtgcspsqs_djbh=pmmtjgjss_jssbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<pmmtgcspsqs_djbh.length;i++){
                l.add(pmmtgcspsqs_djbh[i]);
            }
            int flag=jgjsService.delJgjssForJgjs(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "getJgjssInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过结算书编号交工结算书")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "pmmtjgjss_jssbh", value = "结算书编号", required = true)
    public Msg getJgjssInfoByDjbh(@RequestParam(value = "pmmtjgjss_jssbh",required = true) String pmmtjgjss_jssbh){
        try {
            Jgjs jgjs=jgjsService.getJgjssInfoByDjbh(pmmtjgjss_jssbh);
            return ResultUtil.success(jgjs);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getJgjssList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询交工结算书列表数据")
    public Msg getJgjssList(@RequestParam(value = "htbh",required = false) String htbh,
                            @RequestParam(value = "ksrq",required = false) String ksrq,
                            @RequestParam(value = "jsrq",required = false) String jsrq,
                            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("htbh", htbh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Jgjs> list = jgjsService.getJgjssList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Jgjs>(list));
    }

}
