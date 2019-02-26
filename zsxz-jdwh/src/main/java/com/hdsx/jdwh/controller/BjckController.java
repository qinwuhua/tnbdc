package com.hdsx.jdwh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.jdwh.entity.Bjck;
import com.hdsx.jdwh.entity.Bjckmx;
import com.hdsx.jdwh.entity.Msg;
import com.hdsx.jdwh.service.BjckService;
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
@RequestMapping("jdwh/bjgl")
@Api(value = "备件出库控制器",description = "备件出库控制器")
public class BjckController {

    @Resource
    private BjckService bjckService;

    @RequestMapping(value = "getBjLySqdInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取备件领用申请单信息")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false)
    public Msg getBjLySqdInfo(@RequestParam(value = "tbdwdm",required = false) String tbdwdm){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("tbdwdm",tbdwdm);
            List<Map<String,String>> map=bjckService.getBjLySqdInfo(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }
    }

    @RequestMapping(value = "getBjInfoByLySqd", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取备件列表信息通过申请单号")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "sqdh", value = "申请单号", required = false)
    public Msg getBjInfoByLySqd(@RequestParam(value = "sqdh",required = false) String sqdh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("sqdh",sqdh);
            List<Bjckmx> map=bjckService.getBjInfoByLySqd(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }
    }


    @RequestMapping(value = "addBjck", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加备件出库")
    public Msg addBjck(@RequestBody Bjck bjck){
        try {
            //判断是否大于数量
            for(int i=0;i<bjck.getMx().size();i++){
                Map<String, String> param = new HashMap<String, String>();
                param.put("bjmc",bjck.getMx().get(i).getBjmc());
                param.put("bjbh",bjck.getMx().get(i).getBjbh());
                param.put("ggxh",bjck.getMx().get(i).getGgxh());
                List<Bjckmx> map=bjckService.getBjInfoByLySqd(param);
                if(Double.parseDouble(bjck.getMx().get(i).getCksl()) > Double.parseDouble(String.valueOf(map.get(0).getKcsl()) ) ) {
                    return ResultUtil.error("数量超过已有数量,保存失败");
                }
            }
            int flag=bjckService.addBjck(bjck);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "editBjck", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑备件出库")
    public Msg editBjck(@RequestBody Bjck bjck){
        try {
            //判断是否大于数量
            for(int i=0;i<bjck.getMx().size();i++){
                Map<String, String> param = new HashMap<String, String>();
                param.put("bjmc",bjck.getMx().get(i).getBjmc());
                param.put("bjbh",bjck.getMx().get(i).getBjbh());
                param.put("ggxh",bjck.getMx().get(i).getGgxh());
                param.put("id",bjck.getMx().get(i).getId());
                List<Bjckmx> map=bjckService.getBjInfoByLySqd(param);
                if(Double.parseDouble(bjck.getMx().get(i).getCksl()) > Double.parseDouble(String.valueOf(map.get(0).getKcsl()) ) ) {
                    return ResultUtil.error("数量超过已有数量,保存失败");
                }
            }
            int flag=bjckService.editBjck(bjck);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delBjckBydjbhs", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除备件出库")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delBjckBydjbhs(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] id=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<id.length;i++){
                l.add(id[i]);
            }
            int flag=bjckService.delBjckBydjbhs(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "getBjckInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取备件出库")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getBjckInfoByDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Bjck bjck=bjckService.getBjckInfoByDjbh(djbh);
            return ResultUtil.success(bjck);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getBjckList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询备件出库列表数据")
    public Msg getBjckList(@RequestParam(value = "djbh",required = false) String djbh,
                           @RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                           @RequestParam(value = "ksrq",required = false) String ksrq,
                           @RequestParam(value = "jsrq",required = false) String jsrq,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("djbh", djbh);
        param.put("tbdwdm", tbdwdm);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Bjck> list = bjckService.getBjckList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Bjck>(list));
    }
}
