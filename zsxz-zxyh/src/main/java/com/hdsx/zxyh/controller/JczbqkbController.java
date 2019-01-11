package com.hdsx.zxyh.controller;

import com.hdsx.zxyh.entity.Jczbqkb;
import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.mapper.JczbqkbMapper;
import com.hdsx.zxyh.service.JczbqkbService;
import com.hdsx.zxyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("jczb")
@Api(value = "进场准备情况控制器", description = "进场准备情况控制器")
public class JczbqkbController {

    @Resource
    private JczbqkbService jczbqkbService;

    @GetMapping("getJczbqkb")
    @ApiOperation("获取进场准备情况")
    public Msg getLyjc(
            @RequestParam(value = "htbh", required = false)String htbh,
            @RequestParam(value = "gldw", required = false)String gldw) {
        try {
            return ResultUtil.success(jczbqkbService.getJczbqkb(htbh, gldw));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @PostMapping("addJczbqkb")
    @ApiOperation("增加履约检查")
    public Msg addJczbqkb(@RequestBody Jczbqkb jczbqkb) {
        try {
            if (jczbqkbService.addJczbqkb(jczbqkb)>0) {
                return ResultUtil.success("增加进场准备成功");
            } else {
                return ResultUtil.error("增加进场准备失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @DeleteMapping("deleteJczbqkb")
    @ApiOperation("删除进场准备情况")
    public Msg deleteJczbqkb(@RequestParam("id") String id){
        try {
            if (jczbqkbService.deleteJczbqkb(id)>0) {
                return ResultUtil.success("删除进场准备成功");
            } else {
                return ResultUtil.error("删除进场准备失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @PutMapping("updateJczbqkb")
    @ApiOperation("更新现场准备")
    public Msg updateJczbqkb(@RequestBody Jczbqkb jczbqkb){
        try {
            if (jczbqkbService.updateJczbqkb(jczbqkb) > 0) {
                return ResultUtil.success("更新现场准备成功");
            } else {
                return ResultUtil.error("更新现场准备失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }
}
