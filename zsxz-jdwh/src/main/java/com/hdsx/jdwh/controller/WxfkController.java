package com.hdsx.jdwh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.jdwh.entity.Msg;
import com.hdsx.jdwh.entity.Rcxj;
import com.hdsx.jdwh.entity.Wxfk;
import com.hdsx.jdwh.entity.Wxfkjsmx;
import com.hdsx.jdwh.service.RcxjService;
import com.hdsx.jdwh.service.WxfkService;
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
@Api(value = "维修付款申请控制器",description = "维修付款申请控制器")
public class WxfkController {

    @Resource
    private WxfkService wxfkService;

    @RequestMapping(value = "getFpInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取发票信息")
    public Msg getFpInfo(){
        try {
            List<Map<String,String>> map=wxfkService.getFpInfo();
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }


    @RequestMapping(value = "addWxfk", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加维修付款申请")
    public Msg addWxfk(@RequestBody Wxfk wxfk){
        try {
            int flag=wxfkService.addWxfk(wxfk);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "editWxfk", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑维修付款申请")
    public Msg editWxfk(@RequestBody Wxfk wxfk){
        try {
            int flag=wxfkService.editWxfk(wxfk);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delWxfkByDjbhs", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除维修付款申请")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delWxfkByDjbhs(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] id=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<id.length;i++){
                l.add(id[i]);
            }
            int flag=wxfkService.delWxfkByDjbhs(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "getWxfkInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取维修付款申请")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getWxfkInfoByDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Wxfk wxfk=wxfkService.getWxfkInfoByDjbh(djbh);
            return ResultUtil.success(wxfk);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getWxfkList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询维修付款申请列表数据")
    public Msg getWxfkList(@RequestParam(value = "djbh",required = false) String djbh,
                           @RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                           @RequestParam(value = "htbh",required = false) String htbh,
                           @RequestParam(value = "ksrq",required = false) String ksrq,
                           @RequestParam(value = "jsrq",required = false) String jsrq,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("djbh", djbh);
        param.put("tbdwdm", tbdwdm);
        param.put("htbh", htbh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Wxfk> list = wxfkService.getWxfkList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Wxfk>(list));
    }


    @RequestMapping(value = "getWxfyChooseList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false)
    })
    @ApiOperation(value = "查询维修费用选择数据")
    public Msg getWxfyChooseList(@RequestParam(value = "tbdwdm",required = false) String tbdwdm) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("tbdwdm", tbdwdm);
        List<Wxfkjsmx> list = wxfkService.getWxfyChooseList(param);
        return ResultUtil.success(list);
    }

}
