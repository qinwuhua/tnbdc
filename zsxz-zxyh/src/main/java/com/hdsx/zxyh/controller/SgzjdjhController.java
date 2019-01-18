package com.hdsx.zxyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.entity.Sgzjdjh;
import com.hdsx.zxyh.service.SgzjdjhService;
import com.hdsx.zxyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("sgzjdjh")
@Api(value = "施工总进度计划", description = "施工总进度计划控制器")
public class SgzjdjhController {

    @Resource
    private SgzjdjhService sgzjdjhService;

    @GetMapping("getSgzjdjh")
    @ApiOperation("获取施工总进度计划")
    public Msg getSgzjdjh(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        try {
            return ResultUtil.success(new PageInfo<>(sgzjdjhService.getSgzjdjh(pageNum,pageSize)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @PostMapping("addSgzjdjh")
    @ApiOperation("增加施工总进度计划")
    public Msg addSgzjdjh(@RequestBody Sgzjdjh sgzjdjh) {
        try {
            if (sgzjdjhService.addSgzjdjh(sgzjdjh)>0) {
                return ResultUtil.success("增加施工总进度计划成功");
            } else {
                return ResultUtil.error("增加施工总进度计划失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @PutMapping("updateSgzjdjh")
    @ApiOperation("修改施工总进度计划")
    public Msg updateSgzjdjh(@RequestBody Sgzjdjh sgzjdjh) {
        try {
            if (sgzjdjhService.updateSgzjdjh(sgzjdjh)>0) {
                return ResultUtil.success("修改施工进度计划成功");
            } else {
                return ResultUtil.error("修改施工进度计划失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @DeleteMapping("deleteSgzjdjh")
    @ApiOperation("删除施工总进度计划")
    public Msg deleteSgzjdjh(String[] ids) {
        try {
            if (sgzjdjhService.deleteSgzjdjh(ids)>0) {
                return ResultUtil.success("删除施工总进度计划成功");
            } else {
                return ResultUtil.error("删除施工总进度计划失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }
}
