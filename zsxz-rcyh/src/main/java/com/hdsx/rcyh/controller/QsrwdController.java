package com.hdsx.rcyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.entity.Qsrwd;
import com.hdsx.rcyh.entity.Yhrwd;
import com.hdsx.rcyh.service.QsrwdService;
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
@Api(value = "养护管理-清扫任务单审核")
@RequestMapping("/qsrwdsh")
public class QsrwdController {
    @Resource
    private QsrwdService qsrwdService;
    @ApiOperation(value = "主表添加一条信息", httpMethod = "POST")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public Msg insert(@RequestBody Qsrwd qsrwd) {
        try {
            System.out.println("1111111" + qsrwdService.insert(qsrwd));
            return ResultUtil.success(qsrwdService.insert(qsrwd));
        } catch (Exception e) {
            return ResultUtil.error("查询失败！");
        }
    }

    @ApiOperation(value = "删除一条信息")
    @ApiImplicitParam(name = "qsrwdid", value = "主键", dataType = "string", paramType = "path")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public Msg<Integer> delete(@RequestParam("qsrwdid") String qsrwdid) {
        try {
            System.out.println("1111111" + qsrwdService.delete(qsrwdid));
            return ResultUtil.success(qsrwdService.delete(qsrwdid));
        } catch (Exception e) {
            return ResultUtil.error("查询失败！");
        }
    }

    @ApiOperation(value = "修改", httpMethod = "POST")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Msg<Integer> update(@RequestBody Qsrwd qsrwd) {
        try {
            return ResultUtil.success(qsrwdService.update(qsrwd));
        } catch (Exception e) {
            return ResultUtil.error("查询失败！");
        }

    }

    @RequestMapping(value = "getYhrwdshList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "qsrwdsjlx", value = "时间类型", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "qsrwdtbdw", value = "填报单位", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "qsrwdtbbm", value = "填报部门", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取养护任务单审核列表数据")
    public Msg getQsrwdList(@RequestParam(value = "qsrwdsjlx", required = false) String qsrwdsjlx,
                             @RequestParam(value = "qsrwdtbdw", required = false) String qsrwdtbdw,
                             @RequestParam(value = "qsrwdtbbm", required = false) String qsrwdtbbm,
                             @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String,String> param=new HashMap<String,String>();
        param.put("qsrwdsjlx",qsrwdsjlx);param.put("qsrwdtbdw",qsrwdtbdw);param.put("qsrwdtbbm",qsrwdtbbm);
        List<Qsrwd> list = qsrwdService.getQsrwdList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Qsrwd>(list));
    }
}
