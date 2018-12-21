package com.hdsx.lkpd.controller;


import com.hdsx.lkpd.entity.Msg;
import com.hdsx.lkpd.entity.Qmldb;
import com.hdsx.lkpd.service.LkpdCxService;
import com.hdsx.lkpd.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取技术状况评定明细表数据")
    public Msg getMxbForLksjcx(@RequestParam("lxcode") String lxcode,
                               @RequestParam("xcfx") String xcfx,
                               @RequestParam("bbid") String bbid,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("lxcode",lxcode);param.put("xcfx",xcfx);param.put("bbid",bbid);param.put("lmlx","1");
        List<Qmldb> list = lkpdCxService.getMxbForLksjcx(param, pageNum, pageSize);

        return ResultUtil.success(list);
    }


    @RequestMapping(value = "getHzbForLksjcx", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "lxcode", value = "路线编码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "xcfx", value = "行车方向", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bbid", value = "版本id", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取技术状况评定汇总表数据")
    public Msg getHzbForLksjcx(@RequestParam("lxcode") String lxcode,
                               @RequestParam("xcfx") String xcfx,
                               @RequestParam("bbid") String bbid,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("lxcode",lxcode);param.put("xcfx",xcfx);param.put("bbid",bbid);param.put("lmlx","1");
        List<Map<String,String>> list = lkpdCxService.getHzbForLksjcx(param, pageNum, pageSize);

        return ResultUtil.success(list);
    }


}
