package com.hdsx.rcyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.entity.Xccspz;
import com.hdsx.rcyh.service.XccspzService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(description = "养护管理-巡查次数配置")
@RequestMapping("/xccspz")
public class XccspzController {
    @Resource
    private XccspzService xccspzService;

    @ApiOperation(value = "根据id查询信息", httpMethod = "GET")
    @RequestMapping(value = "/queryOne/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public Msg<Integer> QueryOne(@PathVariable("id") String xccsId) {
        if (!"".equals(xccsId)) {
            List<Xccspz> xccspzs = xccspzService.QueryOne(xccsId);
            if (xccspzs.size() > 0) {
                Msg<Integer> integerMsg = new Msg<Integer>();
                integerMsg.setCode(200);
                integerMsg.setMsg("查询成功");
                integerMsg.setData(1);
                return integerMsg;
            }
        }
        Msg<Integer> integerMsg = new Msg<Integer>();
        integerMsg.setCode(400);
        integerMsg.setMsg("查询失败");
        integerMsg.setData(0);
        return integerMsg;
    }
    @GetMapping("getXccspzAll")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询巡查次数配置表所有信息")
    public Msg getXccspzAll(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            return ResultUtil.success(new PageInfo<>(xccspzService.getXccspzAll(pageNum,pageSize)));
        }catch (Exception e){
            return ResultUtil.error("查询失败！");
        }

    }

    @ApiOperation(value = "添加一条信息", httpMethod = "POST")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public Msg insert(@RequestBody Xccspz xccspz) {
        try {
            if (xccspzService.insert(xccspz)>0){
                return ResultUtil.success("添加信息成功！");
            }else {
                return ResultUtil.error("添加信息失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！！");
        }
    }

    @ApiOperation(  value = "删除一条信息")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "xccsId", value = "主键ID", required = true)
    @RequestMapping(value = "delete",method= RequestMethod.DELETE)
    public Msg delete(@RequestParam("xccsId") String xccsId) {
        try {
             return ResultUtil.success(xccspzService.delete(xccsId));
            }
        catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败！");
        }

    }
/*    @ApiOperation("删除(批量)")
    @RequestMapping(value = "deletes",method= RequestMethod.DELETE)
    public Msg<Integer> deletes(@PathVariable("id") String[] xccsId) {
        if (xccsId.length > 0) {
            int deletes = xccspzService.deletes(xccsId);
            Msg<Integer> integerMsg = new Msg<Integer>();
            integerMsg.setCode(200);
            integerMsg.setMsg("删除成功");
            integerMsg.setData(deletes);
            return integerMsg;
        } else {
            Msg<Integer> integerMsg = new Msg<Integer>();
            integerMsg.setCode(400);
            integerMsg.setMsg("删除失败");
            integerMsg.setData(0);
            return integerMsg;
        }
    }*/

    @ApiOperation(value = "修改", httpMethod = "POST")
    @ApiImplicitParam(name = "id", value = "id", paramType = "path", dataType = "string", required = true)
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Msg<Integer> update(@RequestBody Xccspz xccspz) {
        if (xccspz != null && !"".equals(xccspz)) {
            int update = xccspzService.update(xccspz);
            Msg<Integer> integerMsg = new Msg<Integer>();
            integerMsg.setCode(200);
            integerMsg.setMsg("更新成功");
            integerMsg.setData(update);
            return integerMsg;
        } else {
            Msg<Integer> integerMsg = new Msg<Integer>();
            integerMsg.setCode(400);
            integerMsg.setMsg("更新失败");
            integerMsg.setData(0);
            return integerMsg;
        }

    }
}
