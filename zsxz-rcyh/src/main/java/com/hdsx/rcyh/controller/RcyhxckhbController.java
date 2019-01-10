package com.hdsx.rcyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.entity.Rcyhxckhb;
import com.hdsx.rcyh.entity.Rcyhxckhbmx;
import com.hdsx.rcyh.service.RcyhxckhbService;
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
@Api(description = "日常养护-日常养护巡查考核表")
@RequestMapping("/rcyhxckhb")
public class RcyhxckhbController {
    @Resource
    private RcyhxckhbService rcyhxckhbService;
    @ApiOperation(value = "主表添加一条信息", httpMethod = "POST")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public Msg insert(@RequestBody Rcyhxckhb rcyhxckhb) {
        try {
            return ResultUtil.success(rcyhxckhbService.insert(rcyhxckhb));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("添加失败！");
        }
    }
/*    @ApiOperation(value = "子表添加一条信息", httpMethod = "POST")
    @RequestMapping(value = "insertzb", method = RequestMethod.POST)
    @ResponseBody
    public Msg insertzb(@RequestBody Rcyhxckhbmx rcyhxckhbmx) {
        try {
            return ResultUtil.success(rcyhxckhbService.insertzb(rcyhxckhbmx));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("添加失败！");
        }
    }*/

    @ApiOperation(value = "删除一条信息")
    @ApiImplicitParam(name = "rcyhxckhbdjbh", value = "主键", dataType = "string", paramType = "query", required = true)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public Msg<Integer> delete(@RequestParam("rcyhxckhbdjbh") String rcyhxckhbdjbh) {
        try {
            System.out.println("1111111" + rcyhxckhbService.delete(rcyhxckhbdjbh));
            return ResultUtil.success(rcyhxckhbService.delete(rcyhxckhbdjbh));
        } catch (Exception e) {
            return ResultUtil.error("删除失败！");
        }
    }

    @ApiOperation(value = "删除子表一条信息")
    @ApiImplicitParam(name = "rcyhxckhbid", value = "主键", dataType = "string", paramType = "query", required = true)
    @RequestMapping(value = "deletezb", method = RequestMethod.DELETE)
    public Msg<Integer> deletezb(@RequestParam("rcyhxckhbid") String rcyhxckhbid) {
        try {
            return ResultUtil.success(rcyhxckhbService.deletezb(rcyhxckhbid));
        } catch (Exception e) {
            return ResultUtil.error("删除失败！");
        }
    }

    @ApiOperation(value = "修改", httpMethod = "POST")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Msg<Integer> update(@RequestBody Rcyhxckhb rcyhxckhb) {
        try {
            return ResultUtil.success(rcyhxckhbService.update(rcyhxckhb));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("修改失败！");
        }

    }

/*    @ApiOperation(value = "修改子表", httpMethod = "POST")
    @RequestMapping(value = "/updatezb", method = {RequestMethod.POST})
    public Msg<Integer> updatezb(@RequestBody Rcyhxckhbmx rcyhxckhbmx) {
        try {
            return ResultUtil.success(rcyhxckhbService.updatezb(rcyhxckhbmx));
        } catch (Exception e) {
            return ResultUtil.error("修改失败！");
        }

    }*/

    @RequestMapping(value = "getRcyhxckhbList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "rcyhxckhbyd", value = "月度", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "rcyhxckhbgldw", value = "管理单位", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取养护任务单审核列表数据")
    public Msg getRcyhxckhbList(@RequestParam(value = "rcyhxckhbyd", required = false) String rcyhxckhbyd,
                                @RequestParam(value = "rcyhxckhbgldw", required = false) String rcyhxckhbgldw,
                                @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("rcyhxckhbyd",rcyhxckhbyd);param.put("rcyhxckhbgldw",rcyhxckhbgldw);
        List<Rcyhxckhb> list = rcyhxckhbService.getRcyhxckhbList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<>(list));
    }


}
