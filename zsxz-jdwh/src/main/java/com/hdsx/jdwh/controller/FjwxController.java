package com.hdsx.jdwh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.jdwh.entity.Fjwx;
import com.hdsx.jdwh.entity.Msg;
import com.hdsx.jdwh.service.FjwxService;
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
@Api(value = "废件维修控制器",description = "废件维修控制器")
public class FjwxController {

    @Resource
    private FjwxService fjwxService;

    @RequestMapping(value = "getShbjInfByDw", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取损坏备件信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false)
    })

    public Msg getShbjInfByDw(@RequestParam(value = "tbdwdm",required = false) String tbdwdm){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("tbdwdm",tbdwdm);
            List<Map<String,String>> map=fjwxService.getShbjInfByDw(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }
    }

    @RequestMapping(value = "addFjwx", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加废件维修")
    public Msg addFjwx(@RequestBody Fjwx fjwx){
        try {
            //判断是否大于数量
            int flag=fjwxService.addFjwx(fjwx);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "editFjwx", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑废件维修")
    public Msg editFjwx(@RequestBody Fjwx fjwx){
        try {
            //判断是否大于数量
            int flag=fjwxService.editFjwx(fjwx);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delFjwxBydjbhs", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除废件维修")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delFjwxBydjbhs(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] id=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<id.length;i++){
                l.add(id[i]);
            }
            int flag=fjwxService.delFjwxBydjbhs(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "getFjwxInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取废件维修")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getFjwxInfoByDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Fjwx fjwx=fjwxService.getFjwxInfoByDjbh(djbh);
            return ResultUtil.success(fjwx);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getFjwxList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询废件维修列表数据")
    public Msg getFjwxList(@RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("tbdwdm", tbdwdm);
        List<Fjwx> list = fjwxService.getFjwxList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Fjwx>(list));
    }

}
