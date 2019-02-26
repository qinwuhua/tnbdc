package com.hdsx.jdwh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.jdwh.entity.Msg;
import com.hdsx.jdwh.entity.Wxys;
import com.hdsx.jdwh.service.WxysService;
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
@Api(value = "维修验收控制器",description = "维修验收控制器")
public class WxysController {

    @Resource
    private WxysService wxysService;


    @RequestMapping(value = "getDjBxdInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取报修单信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
        @ApiImplicitParam(paramType="query", dataType = "String", name = "bxdh", value = "报修单号", required = false)
    })
    public Msg getDjBxdInfo(@RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                            @RequestParam(value = "bxdh",required = false) String bxdh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("tbdwdm",tbdwdm);param.put("bxdh",bxdh);
            List<Wxys> map=wxysService.getDjBxdInfo(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }


    @RequestMapping(value = "addWxys", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加维修验收")
    public Msg addWxys(@RequestBody Wxys wxys){
        try {
            int flag=wxysService.addWxys(wxys);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "editWxys", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑维修验收")
    public Msg editWxys(@RequestBody Wxys wxys){
        try {
            int flag=wxysService.editWxys(wxys);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delWxysByDjbhs", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除维修验收")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delWxysByDjbhs(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] id=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<id.length;i++){
                l.add(id[i]);
            }
            int flag=wxysService.delWxysByDjbhs(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "getWxysInfoByIDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取维修验收")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getWxysInfoByIDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Wxys wxys=wxysService.getWxysInfoByIDjbh(djbh);
            return ResultUtil.success(wxys);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getWxysList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bxdh", value = "报修单号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询维修验收列表数据")
    public Msg getWxysList(@RequestParam(value = "djbh",required = false) String djbh,
                           @RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                           @RequestParam(value = "bxdh",required = false) String bxdh,
                           @RequestParam(value = "ksrq",required = false) String ksrq,
                           @RequestParam(value = "jsrq",required = false) String jsrq,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("djbh", djbh);
        param.put("tbdwdm", tbdwdm);
        param.put("bxdh", bxdh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Wxys> list = wxysService.getWxysList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Wxys>(list));
    }

    @RequestMapping(value = "spWxysByDjbh", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批维修验收")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg spWxysByDjbh(@RequestParam(value = "djbhs",required = true) String djbhs,
                             @RequestParam(value = "spzt",required = true) String spzt){
        try {
            String[] djbh=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",spzt);param.put("djbhs",l);
            int flag=wxysService.spWxysByDjbh(param);
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
