package com.hdsx.zxyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.Gcyssqd;
import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.service.GcysFjylbService;
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
@RequestMapping("zxyh/gcysfj")
@Api(value = "工程验收罚金一览表控制器",description = "工程验收罚金一览表控制器")
public class GcysFjylbController {

    @Resource
    private GcysFjylbService gcysFjylbService;



    @RequestMapping(value = "getGcysFjylbList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
//            @ApiImplicitParam(paramType="query", dataType = "String", name = "dwbh", value = "单位编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "htbh", value = "合同编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "nf", value = "年份", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "yf", value = "月份", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询工程验收罚金一览表数据")
    public Msg getGcysFjylbList(//@RequestParam(value = "dwbh",required = false) String dwbh,
                            @RequestParam(value = "htbh",required = false) String htbh,
                            @RequestParam(value = "nf",required = false) String nf,
                            @RequestParam(value = "yf",required = false) String yf,
                            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
       // param.put("dwbh", dwbh);
        param.put("htbh", htbh);
        param.put("nf", nf);
        param.put("yf", yf);
        List<Map<String,String>> list = gcysFjylbService.getGcysFjylbList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Map<String,String>>(list));
    }



}
