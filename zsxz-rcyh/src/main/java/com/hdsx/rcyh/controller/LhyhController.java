package com.hdsx.rcyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.Lhyh;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.entity.Rcqs;
import com.hdsx.rcyh.service.LhyhService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("rcyh/lhyh")
@Api(value = "绿化养护控制器",description = "绿化养护控制器")
public class LhyhController {

    @Resource
    private LhyhService lhyhService;

    @RequestMapping(value = "getLhyhrwList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "lxcode", value = "路线编码(Z817)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "xcfx", value = "行车方向(0301)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取绿化养护任务列表数据")
    public Msg getLhyhrwList(@RequestParam(value = "lxcode",required = false) String lxcode,
                               @RequestParam(value = "xcfx",required = false) String xcfx,
                               @RequestParam(value = "ksrq",required = false) String ksrq,
                               @RequestParam(value = "jsrq",required = false) String jsrq,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("lxcode",lxcode);param.put("xcfx",xcfx);param.put("ksrq",ksrq);param.put("jsrq",jsrq);
        List<Lhyh> list = lhyhService.getLhyhrwList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Lhyh>(list));
    }

    @ApiOperation(value = "添加绿化养护事件")
    @RequestMapping(value = "insertLhyh", method = RequestMethod.POST)
    @ResponseBody
    public Msg insertLhyh(@RequestBody Lhyh lhyh) {
        try {
            if (lhyhService.insertLhyh(lhyh) > 0) {
                return ResultUtil.success("添加信息成功！");
            } else {
                return ResultUtil.error("添加信息失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

}
