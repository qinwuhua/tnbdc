package com.hdsx.zxyh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.Kgsqd;
import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.service.KgsqdService;
import com.hdsx.zxyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 开工申请控制器
 */
@RestController
@RequestMapping("kgsqd")
@Api(value = "开工申请", description = "开工申请控制器")
public class KgsqdController {

    @Resource
    private KgsqdService kgsqdService;

    @GetMapping("getAll")
    @ApiOperation("获取所有开工申请单")
    public Msg getAll(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        try {
            return ResultUtil.success(new PageInfo<>(kgsqdService.getAll(pageNum, pageSize)));
        }catch (Exception e) {
            return ResultUtil.error("开工申请单请求失败！");
        }
    }

    @PostMapping("addKgsqd")
    @ApiOperation("增加开工申请单")
    public Msg addKgsqd(@RequestBody Kgsqd kgsqd) {
        try {
            if (kgsqdService.addKgsqd(kgsqd)>0) {
                return ResultUtil.success("增加开工申请单成功");
            }else {
                return ResultUtil.error("增加开工申请单失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @PutMapping("updateKgsqd")
    @ApiOperation("更新开工申请单")
    public Msg updateKgsqd(@RequestBody Kgsqd kgsqd) {
        try {
            if (kgsqdService.updateKgsqd(kgsqd)>0) {
                return ResultUtil.success("更新开工申请单成功");
            } else {
                return ResultUtil.error("更新开工申请单失败");
            }
        } catch (Exception e) {
            return ResultUtil.error("接口异常");
        }
    }

    @DeleteMapping("deleteKgsqd")
    @ApiOperation("删除开工申请单")
    public Msg deleteKgsqd(@RequestParam(value = "djbhs") String[] djbhs) {
        try {
            if (kgsqdService.deleteKgsqd(djbhs)>0) {
                return ResultUtil.success("删除开工申请单成功");
            } else {
                return ResultUtil.error("删除开工申请单失败");
            }
        } catch (Exception e) {
            return ResultUtil.error("接口异常");
        }
    }
}
