package com.hdsx.zxyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.Bggldjsh;
import com.hdsx.zxyh.entity.Gcysjung;
import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.service.BggldjshService;
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
@RequestMapping("zxyh/gcysjung")
@Api(value = "单价审核表控制器",description = "单价审核表控制器")
public class BggldjshController {

    @Resource
    private BggldjshService bggldjshService;

    @RequestMapping(value = "getHtDjshInfoByBm", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取合同详细信息(单价审核表)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false)
    })

    public Msg getHtDjshInfoByBm(@RequestParam(value = "htbh",required = false) String htbh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("htbh", htbh);
            List<Bggldjsh> map=bggldjshService.getHtDjshInfoByBm(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }



    @RequestMapping(value = "addDjshForGcys", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加单价审核表")
    public Msg addDjshForGcys(@RequestBody Bggldjsh bggldjsh){
        try {
            int flag=bggldjshService.addDjshForGcys(bggldjsh);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "editDjshForGcys", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑单价审核表")
    public Msg editDjshForGcys(@RequestBody Bggldjsh bggldjsh){
        try {
            int flag=bggldjshService.editDjshForGcys(bggldjsh);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delDjshForGcys", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除单价审核表")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delDjshForGcys(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] pmmtgcspsqs_djbh=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<pmmtgcspsqs_djbh.length;i++){
                l.add(pmmtgcspsqs_djbh[i]);
            }
            int flag=bggldjshService.delDjshForGcys(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }


    @RequestMapping(value = "getDjshInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取单价审核表")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "结算书编号", required = true)
    public Msg getDjshInfoByDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Bggldjsh jgjs=bggldjshService.getDjshInfoByDjbh(djbh);
            return ResultUtil.success(jgjs);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getDjshList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwbh", value = "单位编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询单价审核表列表数据")
    public Msg getDjshList(@RequestParam(value = "dwbh",required = false) String dwbh,
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
        List<Bggldjsh> list = bggldjshService.getDjshList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Bggldjsh>(list));
    }

    @RequestMapping(value = "spDjshForGcys", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批单价审核表")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "jssbh", value = "单据编号(以“,”隔开)", required = true)
    public Msg spJungForGcys(@RequestParam(value = "jssbh",required = true) String jssbh,
                             @RequestParam(value = "spzt",required = true) String spzt){
        try {
            String[] djbh=jssbh.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",spzt);param.put("djbhs",l);
            int flag=bggldjshService.spDjshForGcys(param);
            if(flag>0)
                return ResultUtil.success("审批成功");
            else
                return ResultUtil.error("审批失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("审批失败，接口异常");
        }

    }


    @RequestMapping(value = "getHtInfoByZmh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过子目号获取所有合同价格")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "zmh", value = "子目编号", required = true)
    public Msg getHtInfoByZmh(@RequestParam(value = "zmh",required = true) String zmh){
        try {
            List<Map<String,String>> list=bggldjshService.getHtInfoByZmh(zmh);
            return ResultUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

}
