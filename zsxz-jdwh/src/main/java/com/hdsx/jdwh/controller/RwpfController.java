package com.hdsx.jdwh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.jdwh.entity.Gzbx;
import com.hdsx.jdwh.entity.Msg;
import com.hdsx.jdwh.service.RwpfService;
import com.hdsx.jdwh.utils.ResultUtil;
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
@RequestMapping("jdwh/xjwx")
@Api(value = "任务派发和维修任务单控制器",description = "任务派发和维修任务单控制器")
public class RwpfController {

    @Resource
    private RwpfService rwpfService;

    @RequestMapping(value = "getDfprwdList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "gzlx", value = "故障类型", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ggxh", value = "规格型号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取待分配维修任务单列表")
    public Msg getDfprwdList(@RequestParam(value = "djbh",required = false) String djbh,
                             @RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                           @RequestParam(value = "gzlx",required = false) String gzlx,
                           @RequestParam(value = "ggxh",required = false) String ggxh,
                             @RequestParam(value = "ksrq",required = false) String ksrq,
                             @RequestParam(value = "jsrq",required = false) String jsrq,
                             @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("djbh", djbh);
        param.put("tbdwdm", tbdwdm);
        param.put("gzlx", gzlx);
        param.put("ggxh", ggxh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Gzbx> list = rwpfService.getDfprwdList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Gzbx>(list));
    }

    @RequestMapping(value = "getWxzrrInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取维修责任人信息")
    public Msg getWxzrrInfo(){
        try {
            Map<String, String> param = new HashMap<String, String>();
            List<Gzbx> map=rwpfService.getWxzrrInfo(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "wxrid", value = "维修人id", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "fpry", value = "分配人员", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    })
    @RequestMapping(value = "fpWxrwd", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "分配待分配维修任务单")
    public Msg fpWxrwd(@RequestParam(value = "wxrid",required = true) String wxrid,
                        @RequestParam(value = "fpry",required = true) String fpry,
                        @RequestParam(value = "djbh",required = true) String djbh){
        try {
            Gzbx gzbx=new Gzbx();
            gzbx.setWxrid(wxrid);gzbx.setDjbh(djbh);gzbx.setFpry(fpry);
            int flag=rwpfService.fpWxrwd(gzbx);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }


    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    })
    @RequestMapping(value = "czfpWxrwd", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "重置维修任务单状态人员")
    public Msg czfpWxrwd(
                       @RequestParam(value = "djbh",required = true) String djbh){
        try {
            Gzbx gzbx=new Gzbx();gzbx.setDjbh(djbh);
            int flag=rwpfService.czfpWxrwd(gzbx);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    //维修任务单列表

    @RequestMapping(value = "getWxrwdList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ssdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "gzlx", value = "故障类型", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ggxh", value = "规格型号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取维修任务单列表")
    public Msg getWxrwdList(@RequestParam(value = "djbh",required = false) String djbh,
                            @RequestParam(value = "ssdwdm",required = false) String ssdwdm,
                             @RequestParam(value = "gzlx",required = false) String gzlx,
                             @RequestParam(value = "ggxh",required = false) String ggxh,
                            @RequestParam(value = "ksrq",required = false) String ksrq,
                            @RequestParam(value = "jsrq",required = false) String jsrq,
                            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("djbh", djbh);
        param.put("ssdwdm", ssdwdm);
        param.put("gzlx", gzlx);
        param.put("ggxh", ggxh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Gzbx> list = rwpfService.getWxrwdList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Gzbx>(list));
    }


    /*@RequestMapping(value = "getSbInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取设备信息")
    public Msg getSbInfo(){
        try {
            Map<String, String> param = new HashMap<String, String>();
            List<Gzbx> map=rwpfService.getSbInfo(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }




    @RequestMapping(value = "addGzbx", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加任务派发")
    public Msg addGzbx(@RequestBody Gzbx rcxj){
        try {
            int flag=rwpfService.addGzbx(rcxj);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "editGzbx", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑任务派发")
    public Msg editGzbx(@RequestBody Gzbx rcxj){
        try {
            int flag=rwpfService.editGzbx(rcxj);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delGzbxByDjbhs", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除任务派发")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delGzbxByDjbhs(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] id=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<id.length;i++){
                l.add(id[i]);
            }
            int flag=rwpfService.delGzbxByDjbhs(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }


    @RequestMapping(value = "getGzbxInfoByIDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取任务派发")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getGzbxInfoByIDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Gzbx rcxj=rwpfService.getGzbxInfoByIDjbh(djbh);
            return ResultUtil.success(rcxj);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }


    @RequestMapping(value = "getGzbxList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "gzlx", value = "故障类型", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ggxh", value = "规格型号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询任务派发列表数据")
    public Msg getGzbxList(@RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                           @RequestParam(value = "gzlx",required = false) String gzlx,
                           @RequestParam(value = "ggxh",required = false) String ggxh,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("tbdwdm", tbdwdm);
        param.put("gzlx", gzlx);
        param.put("ggxh", ggxh);
        List<Gzbx> list = rwpfService.getGzbxList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Gzbx>(list));
    }*/


}
