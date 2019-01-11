package com.hdsx.zxyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.Gczfgcjld;
import com.hdsx.zxyh.entity.Gczfzqcwzf;
import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.service.GczfService;
import com.hdsx.zxyh.utils.ResultUtil;
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
@RequestMapping("zxyh/gczf")
@Api(value = "工程支付控制器",description = "工程支付控制器")
public class GczfController {

    @Resource
    private GczfService gczfService;


    @RequestMapping(value = "getHtXxInfoByBm", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取合同详细信息(工程计量单模块使用)")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false)
    public Msg getHtXxInfoByBm(@RequestParam(value = "htbh",required = false) String htbh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("htbh", htbh);
            List<Gczfgcjld> map=gczfService.getHtXxInfoByBm(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }
    @RequestMapping(value = "getGcjldList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwbh", value = "单位编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "gcjl_htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询工程计量单列表数据")
    public Msg getGcjldList(@RequestParam(value = "dwbh",required = false) String dwbh,
                            @RequestParam(value = "gcjl_htbh",required = false) String gcjl_htbh,
                            @RequestParam(value = "ksrq",required = false) String ksrq,
                            @RequestParam(value = "jsrq",required = false) String jsrq,
                            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("dwbh", dwbh);
        param.put("gcjl_htbh", gcjl_htbh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Gczfgcjld> list = gczfService.getGcjldList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Gczfgcjld>(list));
    }

    @RequestMapping(value = "getGcjldInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取工程计量单详细信息")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getGcjldInfoByDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("djbh", djbh);
            Gczfgcjld map=gczfService.getGcjldInfoByDjbh(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "addGcjldForGczf", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加工程计量单数据")
    public Msg addGcjldForGczf(@RequestBody Gczfgcjld gczfgcjld){
        try {
            int flag=gczfService.addGcjldForGczf(gczfgcjld);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }


    @RequestMapping(value = "editGcjldForGczf", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑工程计量单数据")
    public Msg editGcjldForGczf(@RequestBody Gczfgcjld gczfgcjld){
        try {
            int flag=gczfService.editGcjldForGczf(gczfgcjld);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }


    @RequestMapping(value = "delGcjldForGczf", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除工程计量单数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delGcjldForGczf(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] djbh=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            int flag=gczfService.delGcjldForGczf(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "spGcjldForGczf", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批工程计量单")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg spGcjldForGczf(@RequestParam(value = "djbhs",required = true) String djbhs,
                              @RequestParam(value = "spzt",required = true) String spzt){
        try {
            String[] djbh=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",spzt);param.put("djbhs",l);
            int flag=gczfService.spGcjldForGczf(param);
            if(flag>0)
                return ResultUtil.success("审批成功");
            else
                return ResultUtil.error("审批失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("审批失败，接口异常");
        }

    }



    //---------------------------------以下是中期财务证书
    @RequestMapping(value = "getHtCwInfoByBm", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取合同详细信息(中期财务证书)")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false)
    public Msg getHtCwInfoByBm(@RequestParam(value = "htbh",required = false) String htbh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("htbh", htbh);
            List<Gczfzqcwzf> map=gczfService.getHtCwInfoByBm(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }



    @RequestMapping(value = "getZqcwzfList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwbh", value = "单位编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询中(终)期财务支付证书列表数据")
    public Msg getZqcwzfList(@RequestParam(value = "dwbh",required = false) String dwbh,
                             @RequestParam(value = "htbh",required = false) String htbh,
                             @RequestParam(value = "ksrq",required = false) String ksrq,
                             @RequestParam(value = "jsrq",required = false) String jsrq,
                             @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("dwbh", dwbh);
        param.put("htbh", htbh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Gczfzqcwzf> list = gczfService.getZqcwzfList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Gczfzqcwzf>(list));
    }

    @RequestMapping(value = "getZqcwzfInfoByZfqh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过支付期号获取中(终)期财务支付证书详细信息")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "zfqh", value = "支付期号", required = true)
    public Msg getZqcwzfInfoByZfqh(@RequestParam(value = "zfqh",required = true) String zfqh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("zfqh", zfqh);
            Gczfzqcwzf map=gczfService.getZqcwzfInfoByZfqh(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }


    @RequestMapping(value = "addZqcwzfForGczf", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加中(终)期财务支付证书数据")
    public Msg addZqcwzfForGczf(@RequestBody Gczfzqcwzf gczfzqcwzf){
        try {
            int flag=gczfService.addZqcwzfForGczf(gczfzqcwzf);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }


    @RequestMapping(value = "editZqcwzfForGczf", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑中(终)期财务支付证书数据")
    public Msg editZqcwzfForGczf(@RequestBody Gczfzqcwzf gczfzqcwzf){
        try {
            int flag=gczfService.editZqcwzfForGczf(gczfzqcwzf);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delZqcwzfForGczf", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除中(终)期财务支付证书数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "zfqhs", value = "支付期号(以“,”隔开)", required = true)
    public Msg delZqcwzfForGczf(@RequestParam(value = "zfqhs",required = true) String zfqhs){
        try {
            String[] zfqh=zfqhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<zfqh.length;i++){
                l.add(zfqh[i]);
            }
            int flag=gczfService.delZqcwzfForGczf(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "spZqcwzfForGczf", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批中期财务支付证书")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "zfbhs", value = "支付期号(以“,”隔开)", required = true)
    public Msg spZqcwzfForGczf(@RequestParam(value = "zfbhs",required = true) String zfbhs,
                               @RequestParam(value = "spzt",required = true) String spzt){
        try {
            String[] djbh=zfbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",spzt);param.put("djbhs",l);
            int flag=gczfService.spZqcwzfForGczf(param);
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
