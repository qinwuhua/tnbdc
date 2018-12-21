package com.hdsx.rcyh.controller;

import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.entity.Xccspz;
import com.hdsx.rcyh.service.XccspzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = {"养护管理-巡查次数配置"})
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
                Msg<Integer> integerMsg = new Msg<>();
                integerMsg.setCode(200);
                integerMsg.setMsg("查询成功");
                integerMsg.setData(1);
                return integerMsg;
            }
        }
        Msg<Integer> integerMsg = new Msg<>();
        integerMsg.setCode(400);
        integerMsg.setMsg("查询失败");
        integerMsg.setData(0);
        return integerMsg;
    }

    @ApiOperation(value = "添加一条信息", httpMethod = "POST")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public Msg<Integer> insert(@RequestBody Xccspz xccspz) {
        if (xccspz != null && !"".equals(xccspz)) {
            int insert = xccspzService.insert(xccspz);
            Msg<Integer> integerMsg = new Msg<>();
            integerMsg.setCode(200);
            integerMsg.setMsg("添加成功");
            integerMsg.setData(insert);
            return integerMsg;
        } else {
            Msg<Integer> integerMsg = new Msg<>();
            integerMsg.setCode(400);
            integerMsg.setMsg("添加失败");
            integerMsg.setData(0);
            return integerMsg;
        }
    }

    @ApiOperation(  value = "删除一条信息")
    @ApiImplicitParam(name = "id",value = "主键",dataType = "string",paramType = "path")
    @RequestMapping(name = "delete/{id}",method= RequestMethod.DELETE)
    public Msg<Integer> deletes(@PathVariable("id") String xccsId) {

        if (!"".equals(xccsId)) {
            int delete = xccspzService.delete(xccsId);
            Msg<Integer> integerMsg = new Msg<>();
            integerMsg.setCode(200);
            integerMsg.setMsg("删除成功");
            integerMsg.setData(delete);
            return integerMsg;
        } else {
            Msg<Integer> integerMsg = new Msg<>();
            integerMsg.setCode(400);
            integerMsg.setMsg("删除失败");
            integerMsg.setData(0);
            return integerMsg;
        }

    }

    @ApiOperation(  value = "删除(批量)")
    @ApiImplicitParam(name = "id",value = "主键",dataType = "string",paramType = "path")
    @RequestMapping(name = "delete/{id}",method= RequestMethod.DELETE)
    public Msg<Integer> deletes(@PathVariable("id") String[] xccsId) {
        if (xccsId.length > 0) {
            int deletes = xccspzService.deletes(xccsId);
            Msg<Integer> integerMsg = new Msg<>();
            integerMsg.setCode(200);
            integerMsg.setMsg("删除成功");
            integerMsg.setData(deletes);
            return integerMsg;
        } else {
            Msg<Integer> integerMsg = new Msg<>();
            integerMsg.setCode(400);
            integerMsg.setMsg("删除失败");
            integerMsg.setData(0);
            return integerMsg;
        }
    }

    @ApiOperation(value = "修改", httpMethod = "POST")
    @ApiImplicitParam(name = "id", value = "id", paramType = "path", dataType = "string", required = true)
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Msg<Integer> update(@ModelAttribute Xccspz xccspz) {
        if (xccspz != null && !"".equals(xccspz)) {
            int update = xccspzService.update(xccspz);
            Msg<Integer> integerMsg = new Msg<>();
            integerMsg.setCode(200);
            integerMsg.setMsg("更新成功");
            integerMsg.setData(update);
            return integerMsg;
        } else {
            Msg<Integer> integerMsg = new Msg<>();
            integerMsg.setCode(400);
            integerMsg.setMsg("更新失败");
            integerMsg.setData(0);
            return integerMsg;
        }

    }
}
