package com.hdsx.rcyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.*;
import com.hdsx.rcyh.service.JlzfService;
import com.hdsx.rcyh.utils.ResultUtil;
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
@RequestMapping("rcyh/jlzf")
@Api(value = "计量支付控制器",description = "计量支付控制器")
public class JlzfController {

    @Resource
    private JlzfService jlzfService;

    @RequestMapping(value = "addSpsqsForJlzf", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加计量支付-索赔申请书数据")
    public Msg addSpsqsForJlzf(@RequestBody Jlzf jlzf){
        try {
            int flag=jlzfService.addSpsqsForJlzf(jlzf);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "editSpsqsForJlzf", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑计量支付-索赔申请书数据")
    public Msg editSpsqsForJlzf(@RequestBody Jlzf jlzf){
        try {
            int flag=jlzfService.editSpsqsForJlzf(jlzf);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delSpsqsForJlzf", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除计量支付-索赔申请书数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "pmmtgcspsqs_djbhs", value = "申请单编号(以“,”隔开)", required = true)
    public Msg delSpsqsForJlzf(@RequestParam(value = "pmmtgcspsqs_djbhs",required = true) String pmmtgcspsqs_djbhs){
        try {
            String[] pmmtgcspsqs_djbh=pmmtgcspsqs_djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<pmmtgcspsqs_djbh.length;i++){
                l.add(pmmtgcspsqs_djbh[i]);
            }
            int flag=jlzfService.delSpsqsForJlzf(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }


    @RequestMapping(value = "getSpsqsInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过申请单编号查询计量支付-索赔申请书数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "pmmtgcspsqs_djbh", value = "申请单编号", required = true)
    public Msg getSpsqsInfoByDjbh(@RequestParam(value = "pmmtgcspsqs_djbh",required = true) String pmmtgcspsqs_djbh){
        try {
            Jlzf jlzf=jlzfService.getSpsqsInfoByDjbh(pmmtgcspsqs_djbh);
            return ResultUtil.success(jlzf);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getSpsqdList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "pmmtgcspsqs_htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询计量支付-索赔申请书列表数据")
    public Msg getSpsqdList(@RequestParam(value = "pmmtgcspsqs_htbh",required = false) String pmmtgcspsqs_htbh,
                             @RequestParam(value = "ksrq",required = false) String ksrq,
                             @RequestParam(value = "jsrq",required = false) String jsrq,
                             @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("pmmtgcspsqs_htbh", pmmtgcspsqs_htbh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Jlzf> list = jlzfService.getSpsqdList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Jlzf>(list));
    }

    @RequestMapping(value = "getHtInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取合同信息")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false)
    public Msg getHtInfoByBm(@RequestParam(value = "htbh",required = false) String htbh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("htbh", htbh);
            List<Map<String,String>> map=jlzfService.getHtInfoByBm(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getHtXxInfoByBm", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取合同详细信息(工程计量单模块使用)")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false)
    public Msg getHtXxInfoByBm(@RequestParam(value = "htbh",required = false) String htbh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("htbh", htbh);
            List<Jlzf> map=jlzfService.getHtXxInfoByBm(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getHtCwInfoByBm", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取合同详细信息(中期财务证书)")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false)
    public Msg getHtCwInfoByBm(@RequestParam(value = "htbh",required = false) String htbh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("htbh", htbh);
            List<Jlzf_zqcwzf> map=jlzfService.getHtCwInfoByBm(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }



    @RequestMapping(value = "addGcjldForJlzf", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加计量支付-工程计量单数据")
    public Msg addGcjldForJlzf(@RequestBody Jlzf jlzf){
        try {
            int flag=jlzfService.addGcjldForJlzf(jlzf);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }


    @RequestMapping(value = "editGcjldForJlzf", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑计量支付-工程计量单数据")
    public Msg editGcjldForJlzf(@RequestBody Jlzf jlzf){
        try {
            int flag=jlzfService.editGcjldForJlzf(jlzf);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "getGcjldInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取计量支付-工程计量单详细信息")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getGcjldInfoByDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("djbh", djbh);
            Jlzf map=jlzfService.getGcjldInfoByDjbh(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getGcjldList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "gcjl_htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询计量支付-工程计量单列表数据")
    public Msg getGcjldList(@RequestParam(value = "gcjl_htbh",required = false) String gcjl_htbh,
                            @RequestParam(value = "ksrq",required = false) String ksrq,
                            @RequestParam(value = "jsrq",required = false) String jsrq,
                            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("gcjl_htbh", gcjl_htbh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Jlzf> list = jlzfService.getGcjldList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Jlzf>(list));
    }
    @RequestMapping(value = "getGcjldHzList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "gcjl_htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询计量支付-工程计量单汇总列表数据")
    public Msg getGcjldHzList(@RequestParam(value = "gcjl_htbh",required = false) String gcjl_htbh,
                            @RequestParam(value = "ksrq",required = false) String ksrq,
                            @RequestParam(value = "jsrq",required = false) String jsrq,
                            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("gcjl_htbh", gcjl_htbh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Zmzb> list = jlzfService.getGcjldHzList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Zmzb>(list));
    }

    @RequestMapping(value = "delGcjldForJlzf", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除计量支付-工程计量单数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delGcjldForJlzf(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] djbh=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            int flag=jlzfService.delGcjldForJlzf(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "delGcjldMxById", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "通过明细id删除计量支付-工程计量单数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "gcjlmx_id", value = "明细id(以“,”隔开)", required = true)
    public Msg delGcjldMxById(@RequestParam(value = "gcjlmx_id",required = true) String gcjlmx_id){
        try {

            int flag=jlzfService.delGcjldMxById(gcjlmx_id);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }


    //以下是计工日审批表

    @RequestMapping(value = "addJrgspForJlzf", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加计量支付-计日工审批数据")
    public Msg addJrgspForJlzf(@RequestBody Jlzf_jrgsp jrgsp){
        try {
            int flag=jlzfService.addJrgspForJlzf(jrgsp);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }


    @RequestMapping(value = "editJrgspForJlzf", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑计量支付-计日工审批数据")
    public Msg editJrgspForJlzf(@RequestBody Jlzf_jrgsp jrgsp){
        try {
            int flag=jlzfService.editJrgspForJlzf(jrgsp);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delJgrspForJlzf", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除计量支付-计日工审批数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delJgrspForJlzf(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] djbh=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            int flag=jlzfService.delJgrspForJlzf(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "delJgrspMxById", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "通过明细id删除计量支付-计日工审批明细数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "jrgmx_id", value = "明细id(以“,”隔开)", required = true)
    public Msg delJgrspMxById(@RequestParam(value = "jrgmx_id",required = true) String jrgmx_id){
        try {

            int flag=jlzfService.delJgrspMxById(jrgmx_id);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "getJgrspList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询计量支付-计日工审批列表数据")
    public Msg getJgrspList(@RequestParam(value = "htbh",required = false) String htbh,
                              @RequestParam(value = "ksrq",required = false) String ksrq,
                              @RequestParam(value = "jsrq",required = false) String jsrq,
                              @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("htbh", htbh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Jlzf_jrgsp> list = jlzfService.getJgrspList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Jlzf_jrgsp>(list));
    }

    @RequestMapping(value = "getJgrspInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取计量支付-计日工审批详细信息")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getJgrspInfoByDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("djbh", djbh);
            Jlzf_jrgsp map=jlzfService.getJgrspInfoByDjbh(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "spJgrspForJlzf", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批计量支付-计日工审批数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg spJgrspForJlzf(@RequestParam(value = "djbhs",required = true) String djbhs,
                              @RequestParam(value = "spzt",required = true) String spzt){
        try {
            String[] djbh=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",spzt);param.put("djbhs",l);
            int flag=jlzfService.spJgrspForJlzf(param);
            if(flag>0)
                return ResultUtil.success("审批成功");
            else
                return ResultUtil.error("审批失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("审批失败，接口异常");
        }

    }

//以下是中期证书接口
    @RequestMapping(value = "addZqcwzfForJlzf", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加计量支付-中(终)期财务支付证书数据")
    public Msg addZqcwzfForJlzf(@RequestBody Jlzf_zqcwzf zqcwzf){
        try {
            int flag=jlzfService.addZqcwzfForJlzf(zqcwzf);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }


    @RequestMapping(value = "editZqcwzfForJlzf", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑计量支付-中(终)期财务支付证书数据")
    public Msg editZqcwzfForJlzf(@RequestBody Jlzf_zqcwzf jrgsp){
        try {
            int flag=jlzfService.editZqcwzfForJlzf(jrgsp);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delZqcwzfForJlzf", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除计量支付-中(终)期财务支付证书数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "zfqhs", value = "支付期号(以“,”隔开)", required = true)
    public Msg delZqcwzfForJlzf(@RequestParam(value = "zfqhs",required = true) String zfqhs){
        try {
            String[] zfqh=zfqhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<zfqh.length;i++){
                l.add(zfqh[i]);
            }
            int flag=jlzfService.delZqcwzfForJlzf(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "delZqcwzfMxById", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "通过明细id删除计量支付-中(终)期财务支付证书明细数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "zqzfmx_id", value = "明细id(以“,”隔开)", required = true)
    public Msg delZqcwzfMxById(@RequestParam(value = "zqzfmx_id",required = true) String zqzfmx_id){
        try {

            int flag=jlzfService.delZqcwzfMxById(zqzfmx_id);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "getZqcwzfList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询计量支付-中(终)期财务支付证书列表数据")
    public Msg getZqcwzfList(@RequestParam(value = "htbh",required = false) String htbh,
                            @RequestParam(value = "ksrq",required = false) String ksrq,
                            @RequestParam(value = "jsrq",required = false) String jsrq,
                            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("htbh", htbh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Jlzf_zqcwzf> list = jlzfService.getZqcwzfList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Jlzf_zqcwzf>(list));
    }

    @RequestMapping(value = "getZqcwzfInfoByZfqh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过支付期号获取计量支付-中(终)期财务支付证书详细信息")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "zfqh", value = "支付期号", required = true)
    public Msg getZqcwzfInfoByZfqh(@RequestParam(value = "zfqh",required = true) String zfqh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("zfqh", zfqh);
            Jlzf_zqcwzf map=jlzfService.getZqcwzfInfoByZfqh(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

//清单期中（终）支付报表

    @RequestMapping(value = "getZqcwzfReport", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false)
    })
    @ApiOperation(value = "查询计量支付-清单期中（终）支付报表")
    public Msg getZqcwzfReport(@RequestParam(value = "htbh",required = false) String htbh,
                             @RequestParam(value = "ksrq",required = false) String ksrq,
                             @RequestParam(value = "jsrq",required = false) String jsrq) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("htbh", htbh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Jlzf_zqcwzfmx> list = jlzfService.getZqcwzfReport(param);
        return ResultUtil.success(list);
    }

    //计量支付汇总表
    @RequestMapping(value = "getZqcwzfHzbReport", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false)
    })
    @ApiOperation(value = "查询计量支付-计量支付汇总表")
    public Msg getZqcwzfHzbReport(@RequestParam(value = "htbh",required = false) String htbh,
                               @RequestParam(value = "ksrq",required = false) String ksrq,
                               @RequestParam(value = "jsrq",required = false) String jsrq) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("htbh", htbh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Map<String,String>> list = jlzfService.getZqcwzfHzbReport(param);
        return ResultUtil.success(list);
    }


}
