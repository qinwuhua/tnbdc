package com.hdsx.rcyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.entity.Xcsb;
import com.hdsx.rcyh.service.XcsbService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(description = "养护管理-巡查上报")
@RequestMapping("/xcsb")
public class XcsbController {
    @Resource
    private XcsbService xcsbService;

    @GetMapping("getXcsb")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询巡查上报信息")
    public Msg getXcsb(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        try {
            return ResultUtil.success(new PageInfo<>(xcsbService.getXcsb(pageNum,pageSize)));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }
    }

    @ApiOperation(value = "添加巡查数据")
    @ResponseBody
    @RequestMapping(value = "insertXcsb", method = RequestMethod.POST)
    public Msg insertXcsb(@RequestBody Xcsb xcsb) {
        try {
            if (xcsbService.insertXcsb(xcsb) > 0) {
                return ResultUtil.success("添加成功");
            } else {
                return ResultUtil.error("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }
}
