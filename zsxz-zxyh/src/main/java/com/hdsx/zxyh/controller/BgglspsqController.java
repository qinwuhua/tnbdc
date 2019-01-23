package com.hdsx.zxyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.Bgglspsqs;
import com.hdsx.zxyh.entity.Msg;
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
@RequestMapping("zxyh/bgglspsq")
@Api(value = "变更管理索赔申请书控制器",description = "变更管理索赔申请书控制器")
public class BgglspsqController {

    @Resource
    private BgglspsqService bgglspsqService;



    @RequestMapping(value = "addSpsqsForBggl", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加索赔申请书数据")
    public Msg addSpsqsForBggl(@RequestBody Bgglspsqs bgglspsqs){
        try {
            int flag=bgglspsqService.addSpsqsForBggl(bgglspsqs);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "editSpsqsForBggl", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑索赔申请书数据")
    public Msg editSpsqsForBggl(@RequestBody Bgglspsqs bgglspsqs){
        try {
            int flag=bgglspsqService.editSpsqsForBggl(bgglspsqs);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delSpsqsForBggl", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除索赔申请书数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "pmmtgcspsqs_djbhs", value = "申请单编号(以“,”隔开)", required = true)
    public Msg delSpsqsForBggl(@RequestParam(value = "pmmtgcspsqs_djbhs",required = true) String pmmtgcspsqs_djbhs){
        try {
            String[] pmmtgcspsqs_djbh=pmmtgcspsqs_djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<pmmtgcspsqs_djbh.length;i++){
                l.add(pmmtgcspsqs_djbh[i]);
            }
            int flag=bgglspsqService.delSpsqsForBggl(l);
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
    @ApiOperation(value = "通过单据编号查询索赔申请书数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "pmmtgcspsqs_djbh", value = "申请单编号", required = true)
    public Msg getSpsqsInfoByDjbh(@RequestParam(value = "pmmtgcspsqs_djbh",required = true) String pmmtgcspsqs_djbh){
        try {
            Bgglspsqs bgglspsqs=bgglspsqService.getSpsqsInfoByDjbh(pmmtgcspsqs_djbh);
            return ResultUtil.success(bgglspsqs);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getSpsqdList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwbh", value = "单位编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "pmmtgcspsqs_htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询索赔申请书列表数据")
    public Msg getSpsqdList(@RequestParam(value = "dwbh",required = false) String dwbh,
                            @RequestParam(value = "pmmtgcspsqs_htbh",required = false) String pmmtgcspsqs_htbh,
                            @RequestParam(value = "ksrq",required = false) String ksrq,
                            @RequestParam(value = "jsrq",required = false) String jsrq,
                            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("dwbh", dwbh);
        param.put("pmmtgcspsqs_htbh", pmmtgcspsqs_htbh);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Bgglspsqs> list = bgglspsqService.getSpsqdList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Bgglspsqs>(list));
    }



    @RequestMapping(value = "spSpsqsForBggl", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批索赔申请书")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg spSpsqsForBggl(@RequestParam(value = "djbhs",required = true) String djbhs,
                              @RequestParam(value = "spzt",required = true) String spzt){
        try {
            String[] djbh=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",spzt);param.put("djbhs",l);
            int flag=bgglspsqService.spSpsqsForBggl(param);
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
