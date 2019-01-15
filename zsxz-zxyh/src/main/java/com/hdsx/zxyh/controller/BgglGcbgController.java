package com.hdsx.zxyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.*;
import com.hdsx.zxyh.service.BgglGcbgService;
import com.hdsx.zxyh.service.BgglspsqService;
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
@RequestMapping("zxyh/bgglgcbg")
@Api(value = "变更管理工程变更控制器",description = "变更管理工程变更控制器")
public class BgglGcbgController {

    @Resource
    private BgglGcbgService bgglGcbgService;

    @RequestMapping(value = "addBgsqbForBggl", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加工程变更申请表数据")
    public Msg addBgsqbForBggl(@RequestBody Bgglbgsqb bgglbgsqb){
        try {
            int flag=bgglGcbgService.addBgsqbForBggl(bgglbgsqb);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "editBgsqbForBggl", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑工程变更申请表数据")
    public Msg editBgsqbForBggl(@RequestBody Bgglbgsqb bgglbgsqb){
        try {
            int flag=bgglGcbgService.editBgsqbForBggl(bgglbgsqb);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delBgsqbForBggl", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除工程变更申请表数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "申请单编号(以“,”隔开)", required = true)
    public Msg delBgsqbForBggl(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] pmmtgcspsqs_djbh=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<pmmtgcspsqs_djbh.length;i++){
                l.add(pmmtgcspsqs_djbh[i]);
            }
            int flag=bgglGcbgService.delBgsqbForBggl(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "getBgsqbInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取工程变更申请表数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "申请单编号", required = true)
    public Msg getBgsqbInfoByDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Bgglbgsqb bgglbgsqb=bgglGcbgService.getBgsqbInfoByDjbh(djbh);
            return ResultUtil.success(bgglbgsqb);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getBgsqbList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwbh", value = "单位编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询工程变更申请表数据")
    public Msg getBgsqbList(@RequestParam(value = "dwbh",required = false) String dwbh,
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
        List<Bgglbgsqb> list = bgglGcbgService.getBgsqbList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Bgglbgsqb>(list));
    }


    @RequestMapping(value = "spBgsqbForBggl", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批工程变更申请表")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg spBgsqbForBggl(@RequestParam(value = "djbhs",required = true) String djbhs,
                              @RequestParam(value = "spzt",required = true) String spzt){
        try {
            String[] djbh=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",spzt);param.put("djbhs",l);
            int flag=bgglGcbgService.spBgsqbForBggl(param);
            if(flag>0)
                return ResultUtil.success("审批成功");
            else
                return ResultUtil.error("审批失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("审批失败，接口异常");
        }

    }

    @RequestMapping(value = "getBglBgsqbInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "选择已下发的变更申请表（变更令模块）")
    public Msg getBglBgsqbInfo(){
        try {
            Bgglbgl bgglbgl=bgglGcbgService.getBglBgsqbInfo();
            return ResultUtil.success(bgglbgl);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }


    @RequestMapping(value = "addBglForBggl", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加工程变更令数据")
    public Msg addBglForBggl(@RequestBody Bgglbgl bgglbgl){
        try {
            int flag=bgglGcbgService.addBglForBggl(bgglbgl);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "editBglForBggl", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑工程变更令数据")
    public Msg editBglForBggl(@RequestBody Bgglbgl bgglbgl){
        try {
            int flag=bgglGcbgService.editBglForBggl(bgglbgl);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delBglForBggl", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除工程变更令数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "bglbhs", value = "变更令编号(以“,”隔开)", required = true)
    public Msg delBglForBggl(@RequestParam(value = "bglbhs",required = true) String bglbhs){
        try {
            String[] pmmtgcspsqs_djbh=bglbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<pmmtgcspsqs_djbh.length;i++){
                l.add(pmmtgcspsqs_djbh[i]);
            }
            int flag=bgglGcbgService.delBglForBggl(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }


    @RequestMapping(value = "getBglInfoByBglbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过变更令编号获取工程变令数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "bglbh", value = "变更令编号", required = true)
    public Msg getBglInfoByBglbh(@RequestParam(value = "bglbh",required = true) String bglbh){
        try {
            Bgglbgl bgglbgsqb=bgglGcbgService.getBglInfoByBglbh(bglbh);
            return ResultUtil.success(bgglbgsqb);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getBglList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwbh", value = "单位编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询工程变更令列表数据")
    public Msg getBglList(@RequestParam(value = "dwbh",required = false) String dwbh,
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
        List<Bgglbgl> list = bgglGcbgService.getBglList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Bgglbgl>(list));
    }


    @RequestMapping(value = "spBglForBggl", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批工程变更令")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "bglbhs", value = "变更令编号(以“,”隔开)", required = true)
    public Msg spBglForBggl(@RequestParam(value = "bglbhs",required = true) String bglbhs,
                              @RequestParam(value = "spzt",required = true) String spzt){
        try {
            String[] djbh=bglbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",spzt);param.put("djbhs",l);
            int flag=bgglGcbgService.spBglForBggl(param);
            if(flag>0)
                return ResultUtil.success("审批成功");
            else
                return ResultUtil.error("审批失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("审批失败，接口异常");
        }

    }



    @RequestMapping(value = "addBgdForBggl", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加工程变更单数据")
    public Msg addBgdForBggl(@RequestBody Bgglbgd bgglbgd){
        try {
            int flag=bgglGcbgService.addBgdForBggl(bgglbgd);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "editBgdForBggl", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑工程变更单数据")
    public Msg editBgdForBggl(@RequestBody Bgglbgd bgglbgd){
        try {
            int flag=bgglGcbgService.editBgdForBggl(bgglbgd);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delBgdForBggl", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除工程变更单数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delBgdForBggl(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] pmmtgcspsqs_djbh=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<pmmtgcspsqs_djbh.length;i++){
                l.add(pmmtgcspsqs_djbh[i]);
            }
            int flag=bgglGcbgService.delBgdForBggl(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }



    @RequestMapping(value = "getBgdInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取工程变更单数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getBgdInfoByDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Bgglbgd bgglbgsqb=bgglGcbgService.getBgdInfoByDjbh(djbh);
            return ResultUtil.success(bgglbgsqb);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getBgdList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwbh", value = "单位编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询工程变更单列表数据")
    public Msg getBgdList(@RequestParam(value = "dwbh",required = false) String dwbh,
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
        List<Bgglbgd> list = bgglGcbgService.getBgdList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Bgglbgd>(list));
    }


    @RequestMapping(value = "spBgdForBggl", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批工程变更令")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg spBgdForBggl(@RequestParam(value = "djbhs",required = true) String djbhs,
                            @RequestParam(value = "spzt",required = true) String spzt){
        try {
            String[] djbh=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",spzt);param.put("djbhs",l);
            int flag=bgglGcbgService.spBgdForBggl(param);
            if(flag>0)
                return ResultUtil.success("审批成功");
            else
                return ResultUtil.error("审批失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("审批失败，接口异常");
        }

    }



    @RequestMapping(value = "getHtBgdInfoByBm", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取合同详细信息(工程变更单)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "zmids", value = "子目id（以逗号隔开）", required = false)
    })
    public Msg getHtBgdInfoByBm(@RequestParam(value = "htbh",required = false) String htbh,
                                 @RequestParam(value = "zmids",required = false) String zmids){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("htbh", htbh);
            if(zmids !=null && !"".equals(zmids)){
                zmids="'"+zmids.replaceAll(",","','")+"'";
            }
            param.put("zmid", zmids);
            List<Bgglbgd> map=bgglGcbgService.getHtBgdInfoByBm(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

}
