package com.hdsx.rcyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.Lhyh;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.entity.Xccspz;
import com.hdsx.rcyh.entity.Yhrwd;
import com.hdsx.rcyh.service.YhrwdshService;
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
@Api(value = "养护管理-养护任务单审核")
@RequestMapping("/yhrwdsh")
public class YhrwdshContrller {
    @Resource
    private YhrwdshService yhrwdshService;

    @ApiOperation(value = "查询养护单位", httpMethod = "GET")
    @RequestMapping(value = "/queryyhdw", method = {RequestMethod.GET})
    public Msg queryyhdw() {
        try {
            System.out.println("1111111" + yhrwdshService.queryyhdw());
            return ResultUtil.success(yhrwdshService.queryyhdw());
        } catch (Exception e) {
            return ResultUtil.error("查询失败！");
        }
    }

    @ApiOperation(value = "查询养护单位", httpMethod = "GET")
    @RequestMapping(value = "/querygldw/", method = {RequestMethod.GET})
    public Msg querygldw() {
        try {
            System.out.println("1111111" + yhrwdshService.querygldw());
            return ResultUtil.success(yhrwdshService.querygldw());
        } catch (Exception e) {
            return ResultUtil.error("查询失败！");
        }
    }

    @ApiOperation(value = "主表添加一条信息", httpMethod = "POST")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public Msg insert(@RequestBody Yhrwd yhrwd) {
        try {
            System.out.println("1111111" + yhrwdshService.insert(yhrwd));
            return ResultUtil.success(yhrwdshService.insert(yhrwd));
        } catch (Exception e) {
            return ResultUtil.error("查询失败！");
        }
    }

    @ApiOperation(value = "删除一条信息")
    @ApiImplicitParam(name = "yhrwddjbh", value = "主键", dataType = "string", paramType = "path")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public Msg<Integer> delete(@RequestParam("yhrwddjbh") String yhrwddjbh) {
        try {
            System.out.println("1111111" + yhrwdshService.delete(yhrwddjbh));
            return ResultUtil.success(yhrwdshService.delete(yhrwddjbh));
        } catch (Exception e) {
            return ResultUtil.error("查询失败！");
        }
    }

    @ApiOperation(value = "修改", httpMethod = "POST")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Msg<Integer> update(@RequestBody Yhrwd yhrwd) {
        try {
            return ResultUtil.success(yhrwdshService.update(yhrwd));
        } catch (Exception e) {
            return ResultUtil.error("查询失败！");
        }

    }

    @RequestMapping(value = "getYhrwdshList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yhrwdlx", value = "路线", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yhrwdyd", value = "月度", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yhrwdyhdw", value = "养护单位", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yhrwdgydw", value = "管理单位", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取养护任务单审核列表数据")
    public Msg getLhyhrwList(@RequestParam(value = "yhrwdlx", required = false) String yhrwdlx,
                             @RequestParam(value = "yhrwdyd", required = false) String yhrwdyd,
                             @RequestParam(value = "yhrwdyhdw", required = false) String yhrwdyhdw,
                             @RequestParam(value = "yhrwdgydw", required = false) String yhrwdgydw,
                             @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String,String> param=new HashMap<String,String>();
        param.put("yhrwdlx",yhrwdlx);param.put("yhrwdyd",yhrwdyd);param.put("yhrwdyhdw",yhrwdyhdw);param.put("yhrwdgydw",yhrwdgydw);
        List<Yhrwd> list = yhrwdshService.getYhrwdshList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Yhrwd>(list));
    }
}
