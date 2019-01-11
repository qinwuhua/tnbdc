package com.hdsx.zxyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.Gcysjung;
import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.service.GcysjungService;
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
@Api(value = "竣工决算控制器",description = "竣工决算控制器")
public class GcysjungController {

    @Resource
    private GcysjungService gcysjungService;


    @RequestMapping(value = "getHtJungInfoByBm", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取合同详细信息(竣工决算)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "zmids", value = "子目id（以逗号隔开）", required = false)
    })

    public Msg getHtJungInfoByBm(@RequestParam(value = "htbh",required = false) String htbh,
                                  @RequestParam(value = "zmids",required = false) String zmids){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("htbh", htbh);
            if(zmids !=null && !"".equals(zmids)){
                zmids="'"+zmids.replaceAll(",","','")+"'";
            }
            param.put("zmid", zmids);
            List<Gcysjung> map=gcysjungService.getHtJungInfoByBm(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "addJungForGcys", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加竣工决算书")
    public Msg addJungForGcys(@RequestBody Gcysjung jgjs){
        try {
            int flag=gcysjungService.addJungForGcys(jgjs);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "editJungForGcys", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑竣工决算书")
    public Msg editJungForGcys(@RequestBody Gcysjung jgjs){
        try {
            int flag=gcysjungService.editJungForGcys(jgjs);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delJungForGcys", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除竣工决算书")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "jssbhs", value = "决算书编号(以“,”隔开)", required = true)
    public Msg delJungForGcys(@RequestParam(value = "jssbhs",required = true) String jssbhs){
        try {
            String[] pmmtgcspsqs_djbh=jssbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<pmmtgcspsqs_djbh.length;i++){
                l.add(pmmtgcspsqs_djbh[i]);
            }
            int flag=gcysjungService.delJungForGcys(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }


    @RequestMapping(value = "getJungInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过结算书编号获取竣工决算书")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "jssbh", value = "结算书编号", required = true)
    public Msg getJungInfoByDjbh(@RequestParam(value = "jssbh",required = true) String jssbh){
        try {
            Gcysjung jgjs=gcysjungService.getJungInfoByDjbh(jssbh);
            return ResultUtil.success(jgjs);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getJungList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwbh", value = "单位编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询竣工决算书列表数据")
    public Msg getJungList(@RequestParam(value = "dwbh",required = false) String dwbh,
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
        List<Gcysjung> list = gcysjungService.getJungList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Gcysjung>(list));
    }

    @RequestMapping(value = "spJungForGcys", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批竣工决算")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "jssbh", value = "结算书编号(以“,”隔开)", required = true)
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
            int flag=gcysjungService.spJungForGcys(param);
            if(flag>0)
                return ResultUtil.success("审批成功");
            else
                return ResultUtil.error("审批失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("审批失败，接口异常");
        }

    }
    
    

    /*






    @RequestMapping(value = "getJiaogInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过结算书编号获取交工结算书")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "pmmtjgjss_jssbh", value = "结算书编号", required = true)
    public Msg getJiaogInfoByDjbh(@RequestParam(value = "pmmtjgjss_jssbh",required = true) String pmmtjgjss_jssbh){
        try {
            Gcysjung jgjs=gcysjungService.getJiaogInfoByDjbh(pmmtjgjss_jssbh);
            return ResultUtil.success(jgjs);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getJiaogList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询交工结算书列表数据")
    public Msg getJiaogList(@RequestParam(value = "dwbh",required = false) String dwbh,
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
        List<Gcysjung> list = gcysjungService.getJiaogList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Gcysjung>(list));
    }

    @RequestMapping(value = "spJiaogForGcys", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批交工结算")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "jssbh", value = "结算书编号(以“,”隔开)", required = true)
    public Msg spJiaogForGcys(@RequestParam(value = "jssbh",required = true) String jssbh,
                              @RequestParam(value = "spzt",required = true) String spzt){
        try {
            String[] djbh=jssbh.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",spzt);param.put("djbhs",l);
            int flag=gcysjungService.spJiaogForGcys(param);
            if(flag>0)
                return ResultUtil.success("审批成功");
            else
                return ResultUtil.error("审批失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("审批失败，接口异常");
        }

    }*/

}
