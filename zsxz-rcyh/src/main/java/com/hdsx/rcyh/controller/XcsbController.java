package com.hdsx.rcyh.controller;

import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.entity.Qdxc;
import com.hdsx.rcyh.entity.Xcsb;
import com.hdsx.rcyh.service.XcsbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = {"养护管理-巡查上报"})
public class XcsbController {
    @Resource
    private XcsbService xcsbService;

    @ApiOperation(value = "根据id查询信息", httpMethod = "GET")
    @RequestMapping(value = "/queryOne/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public Msg<Integer> QyeryOne(@PathVariable("id") String rwmxId) {
        if (!"".equals(rwmxId)) {
            List<Xcsb> xcsbs = xcsbService.QueryOne(rwmxId);
            if (xcsbs.size() > 0) {
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
    public  Msg<Integer> insert(@RequestBody Xcsb xcsb) {
        if (xcsb != null && !"".equals(xcsb)) {
            int insert = xcsbService.insert(xcsb);
            Msg<Integer> integerMsg = new Msg<>();
            integerMsg.setCode(200);
            integerMsg.setMsg("添加成功");
            integerMsg.setData(insert);
            return integerMsg;
        } else {
            int insert = xcsbService.insert(xcsb);
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
    public Msg<Integer> delete(@PathVariable("id") String  rwmxId) {
        if (!"".equals(rwmxId)) {
            int delete = xcsbService.delete(rwmxId);
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


    @ApiOperation(value="删除（批量）")
    @RequestMapping(value="deletes",method= RequestMethod.DELETE)
    public Msg<Integer> deletes (@PathVariable("ids") String [] rwmxId) {
        if (rwmxId.length > 0) {
            int deletes = xcsbService.deletes(rwmxId);
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
}
