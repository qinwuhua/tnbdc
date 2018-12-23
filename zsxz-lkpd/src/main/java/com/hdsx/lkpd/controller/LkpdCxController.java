package com.hdsx.lkpd.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.lkpd.entity.Msg;
import com.hdsx.lkpd.entity.Pdfa;
import com.hdsx.lkpd.entity.Qmldb;
import com.hdsx.lkpd.service.LkpdCxService;
import com.hdsx.lkpd.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("lkpd/cx")
@Api(value = "路况数据导入控制器")
public class LkpdCxController {

    @Resource
    private LkpdCxService lkpdCxService;

    @RequestMapping(value = "getMxbForLksjcx", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "lxcode", value = "路线编码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "xcfx", value = "行车方向", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bbid", value = "版本id", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "szhh", value = "起点桩号", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ezhh", value = "止点桩号", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取技术状况评定明细表数据")
    public Msg getMxbForLksjcx(@RequestParam("lxcode") String lxcode,
                               @RequestParam("xcfx") String xcfx,
                               @RequestParam("bbid") String bbid,
                               @RequestParam("szhh") String szhh,
                               @RequestParam("ezhh") String ezhh,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("lxcode",lxcode);param.put("xcfx",xcfx);param.put("bbid",bbid);param.put("lmlx","1");param.put("szhh",szhh);param.put("ezhh",ezhh);
        List<Qmldb> list = lkpdCxService.getMxbForLksjcx(param, pageNum, pageSize);

        return ResultUtil.success(new PageInfo<>(list));
    }


    @RequestMapping(value = "getHzbForLksjcx", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "lxcode", value = "路线编码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "xcfx", value = "行车方向", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bbid", value = "版本id", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "szhh", value = "起点桩号", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ezhh", value = "止点桩号", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取技术状况评定汇总表数据")
    public Msg getHzbForLksjcx(@RequestParam("lxcode") String lxcode,
                               @RequestParam("xcfx") String xcfx,
                               @RequestParam("bbid") String bbid,
                               @RequestParam("szhh") String szhh,
                               @RequestParam("ezhh") String ezhh,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("lxcode",lxcode);param.put("xcfx",xcfx);param.put("bbid",bbid);param.put("lmlx","1");param.put("szhh",szhh);param.put("ezhh",ezhh);
        List<Map<String,String>> list = lkpdCxService.getHzbForLksjcx(param, pageNum, pageSize);

        return ResultUtil.success(new PageInfo<>(list));
    }

    @RequestMapping(value = "getDjbhForLksjcx", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取技术状况评定单据编号")
    public Msg getDjbhForLksjcx(){

        Map djbh = lkpdCxService.getDjbhForLksjcx();
        return ResultUtil.success(djbh);

    }

    @RequestMapping(value = "addFaForLksjcx", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加路况评定方案数据")
    public Msg addFaForLksjcx(@RequestBody Pdfa pdfa){
        try {
            //查询该单据编号是否已存在，若存在则不能添加
            Integer djbh=lkpdCxService.getIsFaDataByDjbh(pdfa.getDjbh());
            if(djbh>0){
                return ResultUtil.error("保存失败，该单据编号已存在");
            }else{
                int flag=lkpdCxService.addFaForLksjcx(pdfa);
                if(flag>0)
                    return ResultUtil.success("保存成功");
                else
                    return ResultUtil.error("保存失败");
            }

        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "getFaForLksjcx", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "famc", value = "方案名称", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "sjsjsx", value = "数据时间上限", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "sjsjxx", value = "数据时间下限", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取技术状况评定方案数据")
    public Msg getFaForLksjcx(@RequestParam(value = "famc",required = false) String famc,
                              @RequestParam(value = "sjsjsx",required = false) String sjsjsx,
                              @RequestParam(value = "sjsjxx",required = false) String sjsjxx,
                              @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("famc",famc);param.put("sjsjsx",sjsjsx);param.put("sjsjxx",sjsjxx);
        List<Pdfa> list = lkpdCxService.getFaForLksjcx(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<>(list));
    }

    @RequestMapping(value = "editFaForLksjcx", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑路况评定方案数据")
    public Msg editFaForLksjcx(@RequestBody Pdfa pdfa){
        try {
                int flag=lkpdCxService.editFaForLksjcx(pdfa);
                if(flag>0)
                    return ResultUtil.success("保存成功");
                else
                    return ResultUtil.error("保存失败");

        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delFaForLksjcx", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除路况评定方案数据(通过单据编号字符串，逗号隔开)")
    public Msg delFaForLksjcx(@RequestParam(value = "djbhs") String djbhs){
        try {
            System.out.println(djbhs);
            List<Long> l = new ArrayList<Long>();
            String[] djbh=djbhs.split(",");
            for (int i=0;i<djbh.length;i++){
                l.add(Long.parseLong(djbh[i]));
            }
            int flag=lkpdCxService.delFaForLksjcx(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败，没有该编号的数据");

        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }


    @RequestMapping(value = "createMxbDataForLksjcx", method = RequestMethod.POST, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "lxcode", value = "路线编码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "szhh", value = "起点桩号", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ezhh", value = "止点桩号", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bbid", value = "版本id", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "pdsj", value = "评定时间", required = true)
    })
    @ApiOperation(value = "生成明细表数据")
    public Msg createMxbDataForLksjcx(@RequestParam(value = "lxcode",required = true) String lxcode,
                                      @RequestParam(value = "bbid",required = true) String bbid,
                                      @RequestParam("szhh") String szhh,
                                      @RequestParam("ezhh") String ezhh,
                                      @RequestParam("pdsj") String pdsj
                                      ){
        Map<String,String> param=new HashMap<String,String>();
        param.put("lxcode",lxcode);param.put("bbid",bbid);param.put("szhh",szhh);param.put("ezhh",ezhh);param.put("pdsj",pdsj);
        try {
            boolean bl=lkpdCxService.createMxbDataForLksjcx(param);

            return ResultUtil.success("生成数据成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("生成数据失败，接口异常");
        }

    }

}
