package com.hdsx.jdwh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.jdwh.entity.Kcgl;
import com.hdsx.jdwh.entity.Msg;
import com.hdsx.jdwh.entity.Ysrk;
import com.hdsx.jdwh.service.KcglService;
import com.hdsx.jdwh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;


@RestController
@RequestMapping("jdwh/kcgl")
@Api(value = "库存管理控制器",description = "库存管理控制器")
public class KcglController {

    @Resource
    private KcglService kcglService;


    @RequestMapping(value = "getCkBjAll", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "sbmc", value = "设备名称", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ssck", value = "所属仓库", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取库存所有备件")
    public Msg getCkBjAll(@RequestParam(value = "sbmc",required = false) String sbmc,
                          @RequestParam(value = "ssck",required = false) String ssck,
                          @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("sbmc",sbmc);param.put("ssck",ssck);
        List<Kcgl> list = kcglService.getCkBjAll(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Kcgl>(list));
    }

    @RequestMapping(value = "getCkAll", method = RequestMethod.GET, produces = "application/json")

    @ApiOperation(value = "获取所有仓库信息")
    public Msg getCkAll() {
        List<Kcgl> list = kcglService.getCkAll();
        return ResultUtil.success(list);
    }


    @RequestMapping(value = "getCkBjAllByCkmc", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ssck", value = "所属仓库", required = false)
    })
    @ApiOperation(value = "获取库存所有备件")
    public Msg getCkBjAllByCkmc(
                          @RequestParam(value = "ssck",required = true) String ssck
                          ) {
        Map<String, String> param = new HashMap<String, String>();param.put("ssck",ssck);
        List<Kcgl> list = kcglService.getCkBjAllByCkmc(param);
        return ResultUtil.success(list);
    }


    @RequestMapping(value = "dbBj", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "调拨备件")
    public Msg dbBj(@RequestBody Kcgl kcgl){
        try {

            //查询调出库库存是否充足
            double tcsl=kcglService.getTcsl(kcgl);
            if(tcsl<Double.parseDouble(kcgl.getDbsl())){
                return ResultUtil.error("保存失败，库存数量不足");
            }
            //记录日志
            int k=kcglService.jldbrz(kcgl);

            //调出仓库出库
            String uuid1 = UUID.randomUUID().toString().replaceAll("-","");
            kcgl.setId(uuid1);
            String uuid2 = UUID.randomUUID().toString().replaceAll("-","");
            int l = kcglService.dbBjCk(kcgl);
            //调入仓库出库
            kcgl.setId(uuid2);
            int m = kcglService.dbBjRk(kcgl);


/*

            //调出库减去调入数量
            //查询该备件的编码等基本信息
            Kcgl kcgl1=kcglService.getBjJbInfo(kcgl);
            kcgl.setSbbm(kcgl1.getSbbm());kcgl.setRkdj(kcgl1.getRkdj());kcgl.setBjzt(kcgl1.getBjzt());
            String uuid1 = UUID.randomUUID().toString().replaceAll("-","");
            String uuid2 = UUID.randomUUID().toString().replaceAll("-","");
            kcgl.setId(uuid1);
            kcgl.setSsck(kcgl.getDcck());
            kcgl.setKcsl("-"+kcgl.getDbsl());
            int l=kcglService.dbBj(kcgl);
            kcgl.setSsck(kcgl.getDrck());
            kcgl.setKcsl(kcgl.getDbsl());
            kcgl.setId(uuid2);
            int m=kcglService.dbBj(kcgl);*/
            if(l>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    /*@RequestMapping(value = "getCkInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取仓库信息")
    public Msg getCkInfo(){
        try {
            Map<String, String> param = new HashMap<String, String>();
            List<Map<String,String>> map=ysrkService.getCkInfo(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }
    }

    @RequestMapping(value = "getWxdhInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取维修单号")
    public Msg getWxdhInfo(){
        try {
            Map<String, String> param = new HashMap<String, String>();
            List<Map<String,String>> map=ysrkService.getWxdhInfo(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }
    }

    @RequestMapping(value = "getHtBjInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取合同备件信息")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = true)
    public Msg getHtBjInfo(@RequestParam(value = "htbh",required = true) String htbh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("htbh",htbh);
            List<Map<String,String>> map=ysrkService.getHtBjInfo(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }
    }

    @RequestMapping(value = "getWxBjInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取维修备件信息")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "wxdh", value = "维修单号", required = true)
    public Msg getWxBjInfo(@RequestParam(value = "wxdh",required = true) String wxdh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("wxdh",wxdh);
            List<Map<String,String>> map=ysrkService.getWxBjInfo(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }
    }

    @RequestMapping(value = "addYsrk", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加验收入库")
    public Msg addYsrk(@RequestBody Ysrk ysrk){
        try {
            int flag=ysrkService.addYsrk(ysrk);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "editYsrk", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑验收入库")
    public Msg editYsrk(@RequestBody Ysrk ysrk){
        try {
            int flag=ysrkService.editYsrk(ysrk);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delYsrkBydjbhs", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除验收入库")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delYsrkBydjbhs(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] id=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<id.length;i++){
                l.add(id[i]);
            }
            int flag=ysrkService.delYsrkBydjbhs(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }


    @RequestMapping(value = "getYsrkInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取验收入库")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getYsrkInfoByDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Ysrk ysrk=ysrkService.getYsrkInfoByDjbh(djbh);
            return ResultUtil.success(ysrk);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getYsrkList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "rklx", value = "入库类型", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询验收入库列表数据")
    public Msg getYsrkList(@RequestParam(value = "djbh",required = false) String djbh,
                           @RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                           @RequestParam(value = "rklx",required = false) String rklx,
                           @RequestParam(value = "ksrq",required = false) String ksrq,
                           @RequestParam(value = "jsrq",required = false) String jsrq,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("djbh", djbh);
        param.put("tbdwdm", tbdwdm);
        param.put("rklx", rklx);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Ysrk> list = ysrkService.getYsrkList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Ysrk>(list));
    }
*/

}
