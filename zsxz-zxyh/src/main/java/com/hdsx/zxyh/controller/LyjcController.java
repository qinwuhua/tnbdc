package com.hdsx.zxyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.Lyjc;
import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.service.LyjcService;
import com.hdsx.zxyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("lyjc")
@Api(value = "履约检查", description = "履约检查控制器")
public class LyjcController {

    @Resource
    private LyjcService lyjcService;

    @GetMapping("getLyjc")
    @ApiOperation("获取履约检查")
    public Msg getLyjc(
            @RequestParam(value = "htbh", required = false)String htbh,
            @RequestParam(value = "gldw", required = false)String gldw,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        try {
            return ResultUtil.success(new PageInfo<>(lyjcService.getLyjc(htbh, gldw, pageNum, pageSize)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @PostMapping("addLyjc")
    @ApiOperation("增加履约检查")
    public Msg addLyjc(@RequestBody Lyjc lyjc) {
        try {
            if (lyjcService.addLyjc(lyjc)>0) {
                return ResultUtil.success("增加履约成功");
            } else {
                return ResultUtil.error("增加履约失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @DeleteMapping("deleteLyjc")
    @ApiOperation("删除履约检查")
    public Msg deleteLyjc(String[] ids){
        try {
            if (lyjcService.deleteLyjc(ids)>0) {
                return ResultUtil.success("删除履约检查成功");
            } else {
                return ResultUtil.error("删除履约检查失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @PutMapping("updateLyjc")
    @ApiOperation("更新履约检查")
    public Msg updateLyjc(@RequestBody Lyjc lyjc){
        try {
            if (lyjcService.updateLyjc(lyjc) > 0) {
                return ResultUtil.success("更新履约检查成功");
            } else {
                return ResultUtil.error("更新履约检查失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

}
