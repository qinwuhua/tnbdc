package com.hdsx.zxyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.Gcyscbr;
import com.hdsx.zxyh.entity.Gcyssqd;
import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.service.GcysCbrylwtService;
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
@RequestMapping("zxyh/gcyscbr")
@Api(value = "承包人遗留问题控制器",description = "承包人遗留问题控制器")
public class GcysCbrylwtController {

    @Resource
    private GcysCbrylwtService gcysCbrylwtService;



    @RequestMapping(value = "getCbrylwtList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwbh", value = "单位编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "编制开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "编制结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询承包人遗留问题列表数据")
    public Msg getCbrylwtList(@RequestParam(value = "dwbh",required = false) String dwbh,
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
        List<Gcyscbr> list = gcysCbrylwtService.getCbrylwtList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Gcyscbr>(list));
    }


    @RequestMapping(value = "getCbrylwtInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取承包人遗留问题详细信息")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getCbrylwtInfoByDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("djbh", djbh);
            Gcyscbr map=gcysCbrylwtService.getCbrylwtInfoByDjbh(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "addCbrylwtForGcys", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加承包人遗留问题数据")
    public Msg addCbrylwtForGcys(@RequestBody Gcyscbr ccyscbr){
        try {
            int flag=gcysCbrylwtService.addCbrylwtForGcys(ccyscbr);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }


    @RequestMapping(value = "editCbrylwtForGcys", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑承包人遗留问题数据")
    public Msg editCbrylwtForGcys(@RequestBody Gcyscbr ccyscbr){
        try {
            int flag=gcysCbrylwtService.editCbrylwtForGcys(ccyscbr);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }


    @RequestMapping(value = "delCbrylwtForGcys", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除承包人遗留问题数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "sqbhs", value = "申请编号(以“,”隔开)", required = true)
    public Msg delCbrylwtForGcys(@RequestParam(value = "sqbhs",required = true) String sqbhs){
        try {
            String[] djbh=sqbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            int flag=gcysCbrylwtService.delCbrylwtForGcys(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "spCbrylwtForGcys", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批承包人遗留问题")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg spCbrylwtForGcys(@RequestParam(value = "djbhs",required = true) String djbhs,
                               @RequestParam(value = "spzt",required = true) String spzt){
        try {
            String[] djbh=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",spzt);param.put("djbhs",l);
            int flag=gcysCbrylwtService.spCbrylwtForGcys(param);
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
