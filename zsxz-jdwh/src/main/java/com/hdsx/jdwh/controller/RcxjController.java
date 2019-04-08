package com.hdsx.jdwh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.jdwh.entity.Msg;
import com.hdsx.jdwh.entity.Rcxj;
import com.hdsx.jdwh.entity.Rcxjmx;
import com.hdsx.jdwh.service.RcxjService;
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
@Api(value = "日常巡检控制器",description = "日常巡检控制器")
public class RcxjController {

    @Resource
    private RcxjService rcxjService;

   @RequestMapping(value = "getXjType", method = RequestMethod.GET, produces = "application/json")
   @ApiOperation(value = "获取巡检类型")
    public Msg getXjType(){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("xjlx",xjlx);
            List<Rcxjmx> map=rcxjService.getXjType(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "addRcxj", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加日常巡检")
    public Msg addRcxj(@RequestBody Rcxj rcxj){
        try {
            int flag=rcxjService.addRcxj(rcxj);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "editRcxj", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑日常巡检")
    public Msg editRcxj(@RequestBody Rcxj rcxj){
        try {
            int flag=rcxjService.editRcxj(rcxj);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delRcxjByIds", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除日常巡检")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "ids", value = "单据编号(以“,”隔开)", required = true)
    public Msg delRcxjByIds(@RequestParam(value = "ids",required = true) String ids){
        try {
            String[] id=ids.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<id.length;i++){
                l.add(id[i]);
            }
            int flag=rcxjService.delRcxjByIds(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "getRcxjInfoById", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取日常巡检")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "单据编号", required = true)
    public Msg getRcxjInfoById(@RequestParam(value = "id",required = true) String id){
        try {
            Rcxj rcxj=rcxjService.getRcxjInfoById(id);
            return ResultUtil.success(rcxj);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getRcxjList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "单据编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "巡检开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "巡检结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询日常巡检列表数据")
    public Msg getRcxjList(@RequestParam(value = "id",required = false) String id,
                            @RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                           @RequestParam(value = "ksrq",required = false) String ksrq,
                           @RequestParam(value = "jsrq",required = false) String jsrq,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("id", id);
        param.put("tbdwdm", tbdwdm);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Rcxj> list = rcxjService.getRcxjList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Rcxj>(list));
    }


/*

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
*/

}
