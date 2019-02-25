package com.hdsx.rcyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.entity.Qdxc;
import com.hdsx.rcyh.service.YhxcService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@Api(description = "养护巡查-巡查")
@RequestMapping("/yhxc")
public class YhxcController {

    @Resource
    private YhxcService yhxcService;
    @ApiOperation(value = "添加巡查数据")
    @ResponseBody
    @RequestMapping(value = "insertYhxc", method = RequestMethod.POST)
    public Msg insertYhxc(@RequestBody Qdxc qdxc) {
        try {
            if (yhxcService.insertYhxc(qdxc) > 0) {
                return ResultUtil.success("添加成功");
            } else {
                return ResultUtil.error("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @RequestMapping(value = "selectJdlx", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "cphm", value = "巡查车辆", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "kssj", value = "时间", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取巡查监督路线")
    public Msg selectJdlx(@RequestParam(value = "cphm", required = false) String cphm,
                          @RequestParam(value = "kssj", required = false) String kssj,
                          @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("cphm", cphm);
        param.put("kssj", kssj);
        List<Qdxc> list = yhxcService.selectJdlx(param,pageNum,pageSize);
        return ResultUtil.success(new PageInfo<Qdxc>(list));
    }

}
