package com.hdsx.rcyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.Jlzf;
import com.hdsx.rcyh.entity.Msg;
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
    @ApiOperation(value = "通过生清单编号查询计量支付-索赔申请书数据")
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
//    @ApiImplicitParam(paramType="query", dataType = "String", name = "pmmtgcspsqs_djbh", value = "申请单编号", required = true)
    public Msg getHtInfoByBm(/*@RequestParam(value = "bmbm",required = false) String bmbm*/){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("bmbm", "");
            List<Map<String,String>> map=jlzfService.getHtInfoByBm(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getHtXxInfoByBm", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取合同详细信息(包括子目)")
//    @ApiImplicitParam(paramType="query", dataType = "String", name = "pmmtgcspsqs_djbh", value = "申请单编号", required = true)
    public Msg getHtXxInfoByBm(/*@RequestParam(value = "bmbm",required = false) String bmbm*/){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("bmbm", "");
            List<Jlzf> map=jlzfService.getHtXxInfoByBm(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }





    @RequestMapping(value = "addGcjldForJlzf", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加计量支付-工程计量单数据(子目表数据是获取子目明细表，传入合同号获取)")
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
    @ApiOperation(value = "编辑计量支付-工程计量单数据(子目表数据是获取子目明细表，传入合同号和单据编号获取)")
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


    //以下是计工日审批表


}
