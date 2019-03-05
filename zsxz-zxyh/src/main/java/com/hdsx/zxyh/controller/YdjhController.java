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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ydjh")
@Api(value = "月度施工计划", description = "月度计划控制器")
public class YdjhController {

    @Resource
    private YdjhService ydjhService;


    @GetMapping("getZjdHtInfo")
    @ApiOperation("获取已下发总进度合同信息")
    public Msg getZjdHtInfo(
            @RequestParam(value = "tbdwdm",required = false) String tbdwdm
    ){
        try {
            return ResultUtil.success(ydjhService.getZjdHtInfo(tbdwdm));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @GetMapping("getZjdHtCzfs")
    @ApiOperation("获取总进度处置方式")
    public Msg getZjdHtCzfs(
            @RequestParam(value = "htbh",required = true) String htbh
    ){
        try {
            return ResultUtil.success(ydjhService.getZjdHtCzfs(htbh));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }




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
            //判断是否已存在该月度
            int flag=ydjhService.getSfYczYd(ydjh);
            if(flag>0){
                return ResultUtil.error("该月度已经存在，请直接编辑，保存失败");
            }

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


    @RequestMapping(value = "spYdjh", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批月度计划")
    public Msg spYdjh(@RequestParam(value = "ids",required = true) String ids,
                         @RequestParam(value = "zt",required = true) String zt){
        try {
            String[] idss=ids.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<idss.length;i++){
                l.add(idss[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",zt);param.put("djbhs",l);
            int flag=ydjhService.spYdjh(param);
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
