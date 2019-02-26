package com.hdsx.jdwh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.jdwh.entity.Msg;
import com.hdsx.jdwh.entity.Wxfy;
import com.hdsx.jdwh.service.WxfyService;
import com.hdsx.jdwh.service.WxfyService;
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
@Api(value = "维修费用控制器",description = "维修费用控制器")
public class WxfyController {

    @Resource
    private WxfyService wxfyService;


    @RequestMapping(value = "getWxsbInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取维修设备信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "wxdh", value = "维修单号", required = false)
    })
    public Msg getWxsbInfo(@RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                            @RequestParam(value = "wxdh",required = false) String wxdh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("tbdwdm",tbdwdm);param.put("wxdh",wxdh);
            List<Wxfy> map=wxfyService.getWxsbInfo(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getDfdwInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取对方单位信息")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "dfdwid", value = "对方单位id", required = false)
    public Msg getDfdwInfo(@RequestParam(value = "dfdwid",required = false) String dfdwid){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("dfdwid",dfdwid);
            List<Wxfy> map=wxfyService.getDfdwInfo(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }



    @RequestMapping(value = "addWxfy", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加维修费用")
    public Msg addWxfy(@RequestBody Wxfy wxfy){
        try {
            int flag=wxfyService.addWxfy(wxfy);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "editWxfy", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑维修费用")
    public Msg editWxfy(@RequestBody Wxfy wxfy){
        try {
            int flag=wxfyService.editWxfy(wxfy);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delWxfyByDjbhs", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除维修费用")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delWxfyByDjbhs(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] id=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<id.length;i++){
                l.add(id[i]);
            }
            int flag=wxfyService.delWxfyByDjbhs(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "getWxfyInfoByIDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取维修费用")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getWxfyInfoByIDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Wxfy wxfy=wxfyService.getWxfyInfoByIDjbh(djbh);
            return ResultUtil.success(wxfy);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getWxfyList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "wxdh", value = "维修单号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询维修费用列表数据")
    public Msg getWxfyList(@RequestParam(value = "djbh",required = false) String djbh,
                           @RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                           @RequestParam(value = "wxdh",required = false) String wxdh,
                           @RequestParam(value = "ksrq",required = false) String ksrq,
                           @RequestParam(value = "jsrq",required = false) String jsrq,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("djbh", djbh);
        param.put("tbdwdm", tbdwdm);
        param.put("wxdh", wxdh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Wxfy> list = wxfyService.getWxfyList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Wxfy>(list));
    }

    @RequestMapping(value = "spWxfyByDjbh", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批维修费用")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg spWxfyByDjbh(@RequestParam(value = "djbhs",required = true) String djbhs,
                            @RequestParam(value = "spzt",required = true) String spzt){
        try {
            String[] djbh=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",spzt);param.put("djbhs",l);
            int flag=wxfyService.spWxfyByDjbh(param);
            if(flag>0)
                return ResultUtil.success("审批成功");
            else
                return ResultUtil.error("审批失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("审批失败，接口异常");
        }

    }


}
