package com.hdsx.zxyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.entity.Ydjh;
import com.hdsx.zxyh.entity.Ydwc;
import com.hdsx.zxyh.service.YdjhService;
import com.hdsx.zxyh.service.YdwcService;
import com.hdsx.zxyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ydwc")
@Api(value = "月度完成情况", description = "月度完成控制器")
public class YdwcController {

    @Resource
    private YdwcService ydwcService;

    @GetMapping("getYdjhHtInfo")
    @ApiOperation("获取月度计划已下发合同信息")
    public Msg getYdjhHtInfo(
            @RequestParam(value = "tbdwdm",required = false) String tbdwdm
    ){
        try {
            return ResultUtil.success(ydwcService.getYdjhHtInfo(tbdwdm));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }


    @GetMapping("getZbInfoByHtAndYd")
    @ApiOperation("获取子表信息通过合同编号和月度")
    public Msg getZbInfoByHtAndYd(
            @RequestParam(value = "htbh",required = true) String htbh,
            @RequestParam(value = "yd",required = true) String yd
    ){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("htbh",htbh);param.put("yd",yd);
            return ResultUtil.success(ydwcService.getZbInfoByHtAndYd(param));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @GetMapping("getYdwc")
    @ApiOperation("获取月度完成")
    public Msg getYdjh(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ){
        try {
            return ResultUtil.success(new PageInfo<>(ydwcService.getYdwc(pageNum, pageSize)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @PostMapping("addYdwc")
    @ApiOperation("增加月度施工完成")
    public Msg addYdjh(@RequestBody Ydwc ydwc) {
        try {
            if (ydwcService.addYdwc(ydwc)>0){
                return ResultUtil.success("增加月度计划成功");
            } else {
                return ResultUtil.error("增加月度计划失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @DeleteMapping("deleteYdwc")
    @ApiOperation("删除月度施工完成")
    public Msg deleteYdjh(String[] ids) {
        try {
            if (ydwcService.deleteYdwc(ids)>0) {
                return ResultUtil.success("删除月度计划成功");
            } else {
                return ResultUtil.error("删除月度计划失败");
            }
        } catch (Exception e) {
            return ResultUtil.error("接口异常");
        }
    }

    @PutMapping("updateYdwc")
    @ApiOperation("更新月度施工完成")
    public Msg updateYdjh(@RequestBody Ydwc ydwc) {
        try {
            if (ydwcService.updateYdwc(ydwc) > 0) {
                return ResultUtil.success("更新月度计划成功");
            } else {
                return ResultUtil.error("更新月度计划失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }


    @RequestMapping(value = "spYdwc", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批月度完成")
    public Msg spYdwc(@RequestParam(value = "ids",required = true) String ids,
                      @RequestParam(value = "zt",required = true) String zt){
        try {
            String[] idss=ids.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<idss.length;i++){
                l.add(idss[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",zt);param.put("djbhs",l);
            int flag=ydwcService.spYdwc(param);
            if(flag>0)
                return ResultUtil.success("审批成功");
            else
                return ResultUtil.error("审批失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("审批失败，接口异常");
        }

    }

}
