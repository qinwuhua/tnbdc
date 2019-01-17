package com.hdsx.zxyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.entity.Ydjh;
import com.hdsx.zxyh.service.YdjhService;
import com.hdsx.zxyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("ydjh")
@Api(value = "月度施工计划", description = "月度计划控制器")
public class YdjhController {

    @Resource
    private YdjhService ydjhService;

    @GetMapping("getYdjh")
    @ApiOperation("获取月度计划")
    public Msg getYdjh(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ){
        try {
            return ResultUtil.success(new PageInfo<>(ydjhService.getYdjh(pageNum, pageSize)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @PostMapping("addYdjh")
    @ApiOperation("增加月度计划")
    public Msg addYdjh(@RequestBody Ydjh ydjh) {
        try {
            if (ydjhService.addYdjh(ydjh)>0){
                return ResultUtil.success("增加月度计划成功");
            } else {
                return ResultUtil.error("增加月度计划失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @DeleteMapping("deleteYdjh")
    @ApiOperation("删除月度计划")
    public Msg deleteYdjh(String[] ids) {
        try {
            if (ydjhService.deleteYdjh(ids)>0) {
                return ResultUtil.success("删除月度计划成功");
            } else {
                return ResultUtil.error("删除月度计划失败");
            }
        } catch (Exception e) {
            return ResultUtil.error("接口异常");
        }
    }

    @PutMapping("updateYdjh")
    @ApiOperation("更新月度计划")
    public Msg updateYdjh(@RequestBody Ydjh ydjh) {
        try {
            if (ydjhService.updateYdjh(ydjh) > 0) {
                return ResultUtil.success("更新月度计划成功");
            } else {
                return ResultUtil.error("更新月度计划失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }
}
