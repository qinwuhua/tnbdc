package com.hdsx.jdwh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.jdwh.entity.Fjrk;
import com.hdsx.jdwh.entity.Fjrkmx;
import com.hdsx.jdwh.entity.Msg;
import com.hdsx.jdwh.service.FjrkService;
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
@Api(value = "废件入库控制器",description = "废件入库控制器")
public class FjrkController {

    @Resource
    private FjrkService fjrkService;

    @RequestMapping(value = "getWxdhInfByDw", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取维修单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "wxdjbh", value = "维修单据编号", required = false)
    })

    public Msg getWxdhInfByDw(@RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                              @RequestParam(value = "wxdjbh",required = false) String wxdjbh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("tbdwdm",tbdwdm);
            param.put("djbh",wxdjbh);
            List<Map<String,String>> map=fjrkService.getWxdhInfByDw(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }
    }

    @RequestMapping(value = "addFjrk", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加废件入库")
    public Msg addFjrk(@RequestBody Fjrk fjrk){
        try {
            //判断是否大于数量
            int flag=fjrkService.addFjrk(fjrk);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "editFjrk", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑废件入库")
    public Msg editFjrk(@RequestBody Fjrk fjrk){
        try {
            //判断是否大于数量
            int flag=fjrkService.editFjrk(fjrk);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delFjrkBydjbhs", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除废件入库")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delFjrkBydjbhs(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] id=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<id.length;i++){
                l.add(id[i]);
            }
            int flag=fjrkService.delFjrkBydjbhs(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "getFjrkInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取废件入库")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getFjrkInfoByDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Fjrk fjrk=fjrkService.getFjrkInfoByDjbh(djbh);
            return ResultUtil.success(fjrk);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getFjrkList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询废件入库列表数据")
    public Msg getFjrkList(@RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("tbdwdm", tbdwdm);
        List<Fjrk> list = fjrkService.getFjrkList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Fjrk>(list));
    }
}
