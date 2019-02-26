package com.hdsx.jdwh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.jdwh.entity.Gzbx;
import com.hdsx.jdwh.entity.Msg;
import com.hdsx.jdwh.entity.Rcxj;
import com.hdsx.jdwh.service.GzbxService;
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
@Api(value = "故障报修控制器",description = "故障报修控制器")
public class GzbxController {

    @Resource
    private GzbxService gzbxService;

    @RequestMapping(value = "getSbInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取设备信息")
    public Msg getSbInfo(){
        try {
            Map<String, String> param = new HashMap<String, String>();
            List<Gzbx> map=gzbxService.getSbInfo(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "addGzbx", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加故障报修")
    public Msg addGzbx(@RequestBody Gzbx rcxj){
        try {
            int flag=gzbxService.addGzbx(rcxj);
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
    @ApiOperation(value = "编辑故障报修")
    public Msg editGzbx(@RequestBody Gzbx rcxj){
        try {
            int flag=gzbxService.editGzbx(rcxj);
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
    @ApiOperation(value = "删除故障报修")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delGzbxByDjbhs(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] id=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<id.length;i++){
                l.add(id[i]);
            }
            int flag=gzbxService.delGzbxByDjbhs(l);
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
    @ApiOperation(value = "通过单据编号获取故障报修")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getGzbxInfoByIDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Gzbx rcxj=gzbxService.getGzbxInfoByIDjbh(djbh);
            return ResultUtil.success(rcxj);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }


    @RequestMapping(value = "getGzbxList", method = RequestMethod.GET, produces = "application/json")
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
    @ApiOperation(value = "查询故障报修列表数据")
    public Msg getGzbxList(@RequestParam(value = "djbh",required = false) String djbh,
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
        List<Gzbx> list = gzbxService.getGzbxList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Gzbx>(list));
    }


}
