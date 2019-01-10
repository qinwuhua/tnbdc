package com.hdsx.zxyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.Gcyssqd;
import com.hdsx.zxyh.entity.Gczfgcjld;
import com.hdsx.zxyh.entity.Gczfzqcwzf;
import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.service.GcysSqdService;
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
@RequestMapping("zxyh/gcyssqd")
@Api(value = "工程验收申请单控制器",description = "工程验收申请单控制器")
public class GcysSqdController {

    @Resource
    private GcysSqdService gcysSqdService;



    @RequestMapping(value = "getGcyssqdList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwbh", value = "单位编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "申请开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "申请结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询工程验收申请单列表数据")
    public Msg getGcyssqdList(@RequestParam(value = "dwbh",required = false) String dwbh,
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
        List<Gcyssqd> list = gcysSqdService.getGcyssqdList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Gcyssqd>(list));
    }


    @RequestMapping(value = "getGcyssqdInfoBySqbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过申请编号获取工程验收申请单详细信息")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "sqbh", value = "申请编号", required = true)
    public Msg getGcyssqdInfoBySqbh(@RequestParam(value = "sqbh",required = true) String sqbh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("sqbh", sqbh);
            Gcyssqd map=gcysSqdService.getGcyssqdInfoBySqbh(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "addGcyssqdForGcys", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加工程验收申请单数据")
    public Msg addGcyssqdForGcys(@RequestBody Gcyssqd gcyssqd){
        try {
            int flag=gcysSqdService.addGcyssqdForGcys(gcyssqd);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }


    @RequestMapping(value = "editGcyssqdForGcys", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑工程验收申请单数据")
    public Msg editGcyssqdForGcys(@RequestBody Gcyssqd gcyssqd){
        try {
            int flag=gcysSqdService.editGcyssqdForGcys(gcyssqd);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }


    @RequestMapping(value = "delGcyssqdForGcys", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除工程验收申请单数据")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "sqbhs", value = "申请编号(以“,”隔开)", required = true)
    public Msg delGcyssqdForGcys(@RequestParam(value = "sqbhs",required = true) String sqbhs){
        try {
            String[] djbh=sqbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            int flag=gcysSqdService.delGcyssqdForGcys(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }


}
