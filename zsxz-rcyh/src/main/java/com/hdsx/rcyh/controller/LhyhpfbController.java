package com.hdsx.rcyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.Lhyhpfb;
import com.hdsx.rcyh.entity.Lhyhpfbmx;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.service.LhyhpfbService;
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
@Api(value = "日常养护-绿化养护评分表")
@RequestMapping("/lhyhpfb")
public class LhyhpfbController {
    @Resource
    private LhyhpfbService lhyhpfbService;

    @ApiOperation(value = "主表添加一条信息", httpMethod = "POST")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public Msg insert(@RequestBody Lhyhpfb lhyhpfb) {
        try {
            return ResultUtil.success(lhyhpfbService.insert(lhyhpfb));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("添加失败！");
        }
    }
/*    @ApiOperation(value = "子表添加一条信息", httpMethod = "POST")
    @RequestMapping(value = "insertzb", method = RequestMethod.POST)
    @ResponseBody
    public Msg insertzb(@RequestBody Lhyhpfbmx lhyhpfbmx) {
        try {
            return ResultUtil.success(lhyhpfbService.insertzb(lhyhpfbmx));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("添加失败！");
        }
    }*/

    @ApiOperation(value = "删除一条信息")
    @ApiImplicitParam(name = "lhyhdjbh", value = "主键", dataType = "string", paramType = "query", required = true)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public Msg<Integer> delete(@RequestParam("lhyhdjbh") String lhyhdjbh) {
        try {
            System.out.println("1111111" + lhyhpfbService.delete(lhyhdjbh));
            return ResultUtil.success(lhyhpfbService.delete(lhyhdjbh));
        } catch (Exception e) {
            return ResultUtil.error("删除失败！");
        }
    }

    @ApiOperation(value = "删除子表一条信息")
    @ApiImplicitParam(name = "lhyhid", value = "主键", dataType = "string", paramType = "query", required = true)
    @RequestMapping(value = "deletezb", method = RequestMethod.DELETE)
    public Msg<Integer> deletezb(@RequestParam("lhyhid") String lhyhid) {
        try {
            return ResultUtil.success(lhyhpfbService.deletezb(lhyhid));
        } catch (Exception e) {
            return ResultUtil.error("删除失败！");
        }
    }

    @ApiOperation(value = "修改", httpMethod = "POST")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Msg<Integer> update(@RequestBody Lhyhpfb lhyhpfb) {
        try {
            return ResultUtil.success(lhyhpfbService.update(lhyhpfb));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("修改失败！");
        }

    }

/*    @ApiOperation(value = "修改子表", httpMethod = "POST")
    @RequestMapping(value = "/updatezb", method = {RequestMethod.POST})
    public Msg<Integer> updatezb(@RequestBody Lhyhpfbmx lhyhpfbmx) {
        try {
            return ResultUtil.success(lhyhpfbService.updatezb(lhyhpfbmx));
        } catch (Exception e) {
            return ResultUtil.error("修改失败！");
        }

    }*/

    @RequestMapping(value = "getLhyhrwList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "lhyhyd", value = "月度", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "lhyhgldw", value = "管理单位", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取养护任务单审核列表数据")
    public Msg getLhyhrwList(@RequestParam(value = "lhyhyd", required = false) String lhyhyd,
                             @RequestParam(value = "lhyhgldw", required = false) String lhyhgldw,
                             @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String,String> param=new HashMap<String,String>();
        param.put("lhyhyd",lhyhyd);param.put("lhyhgldw",lhyhgldw);
        List<Lhyhpfb> list = lhyhpfbService.getLhyhrwList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<>(list));
    }





    @ApiOperation(value = "修改子表状态", httpMethod = "POST")
    @RequestMapping(value = "/updatezt", method = {RequestMethod.POST})
    public Msg updateshzt(@RequestParam(value = "lhyhid")String lhyhid,
                          @RequestParam(value = "lhyhzt")String lhyhzt) {
        try {
            return ResultUtil.success(lhyhpfbService.updatezt(lhyhid, lhyhzt));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("修改失败！");
        }

    }
}
