package com.hdsx.jdwh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.jdwh.entity.Fjwxjs;
import com.hdsx.jdwh.entity.Msg;
import com.hdsx.jdwh.service.FjwxjsService;
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
@Api(value = "废件维修结算控制器",description = "废件维修结算控制器")
public class FjwxjsController {

    @Resource
    private FjwxjsService fjwxjsService;

    @RequestMapping(value = "getFjwxdInfByDw", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取废件维修单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false)
    })
    public Msg getFjwxdInfByDw(@RequestParam(value = "tbdwdm",required = false) String tbdwdm){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("tbdwdm",tbdwdm);
            List<Map<String,String>> map=fjwxjsService.getFjwxdInfByDw(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }
    }

    @RequestMapping(value = "getFjwxdBjInfByDw", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取废件维修单下备件信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "维修单号", required = false)
    })
    public Msg getFjwxdBjInfByDw(@RequestParam(value = "djbh",required = false) String djbh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("djbh",djbh);
            List<Map<String,String>> map=fjwxjsService.getFjwxdBjInfByDw(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }
    }

    @RequestMapping(value = "addFjwxjs", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加废件维修结算")
    public Msg addFjwxjs(@RequestBody Fjwxjs fjwxjs){
        try {
            int flag=fjwxjsService.addFjwxjs(fjwxjs);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "editFjwxjs", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑废件维修结算")
    public Msg editFjwxjs(@RequestBody Fjwxjs fjwxjs){
        try {
            int flag=fjwxjsService.editFjwxjs(fjwxjs);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "delFjwxjsByids", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除废件维修结算")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "ids", value = "id(以“,”隔开)", required = true)
    public Msg delFjwxjsByids(@RequestParam(value = "ids",required = true) String ids){
        try {
            String[] id=ids.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<id.length;i++){
                l.add(id[i]);
            }
            int flag=fjwxjsService.delFjwxjsBydjbhs(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "getFjwxjsInfoById", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过id获取废件维修结算")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "id", required = true)
    public Msg getFjwxjsInfoById(@RequestParam(value = "id",required = true) String id){
        try {
            Fjwxjs fjwxjs=fjwxjsService.getFjwxjsInfoById(id);
            return ResultUtil.success(fjwxjs);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getFjwxjsList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询废件维修结算列表数据")
    public Msg getFjwxjsList(@RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                             @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("tbdwdm", tbdwdm);
        List<Fjwxjs> list = fjwxjsService.getFjwxjsList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Fjwxjs>(list));
    }

}
