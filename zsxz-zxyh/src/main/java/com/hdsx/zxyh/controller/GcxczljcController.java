package com.hdsx.zxyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.Gcxczljc;
import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.service.GcxczljcService;
import com.hdsx.zxyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工程现场质量检查控制器
 */
@RestController
@RequestMapping("gcxcjc")
@Api(value = "工程现场质量检查控制器", description = "工程现场质量检查控制器")
public class GcxczljcController {

    @Resource
    private GcxczljcService gcxczljcService;

    @GetMapping("getGcxczljc")
    @ApiOperation("获取工程现场质量检查")
    public Msg getGcxczljc(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ){
        try {
            return ResultUtil.success(new PageInfo<>(gcxczljcService.getGcxczljc(pageNum, pageSize)));
        } catch (Exception e) {
            return ResultUtil.error("接口异常");
        }
    }

    @PostMapping("addGcxczljc")
    @ApiOperation("增加工程现场质量检查")
    public Msg addGcxczljc(@RequestBody Gcxczljc gcxczljc) {
        try {
            if (gcxczljcService.addGcxczljc(gcxczljc)>0) {
                return ResultUtil.success("工程现场质量检查增加成功");
            } else {
                return ResultUtil.error("工程现场质量检查增加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @PutMapping("updateGcxczljc")
    @ApiOperation("更新工程现场质量检查")
    public Msg updateGcxczljc(@RequestBody Gcxczljc gcxczljc) {
        try {
            if (gcxczljcService.updateGcxczljc(gcxczljc)>0) {
                return ResultUtil.success("更新工程现场质量检查成功");
            } else {
                return ResultUtil.error("更新工程现场质量检查失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @DeleteMapping("deleteGcxczljc")
    @ApiOperation("删除工程现场质量检查")
    public Msg deleteGcxczljc(String[] ids) {
        try {
            if (gcxczljcService.deleteGcxczljc(ids)>0){
                return ResultUtil.success("删除工程现场质量检查成功");
            } else {
                return ResultUtil.error("删除工程现场质量检查失败");
            }
        } catch (Exception e) {
            return ResultUtil.error("接口异常");
        }
    }


    @RequestMapping(value = "spGcxczljc", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批工程现场质量检查")
    public Msg spGcxczljc(@RequestParam(value = "ids",required = true) String ids,
                      @RequestParam(value = "spzt",required = true) String spzt){
        try {
            String[] idss=ids.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<idss.length;i++){
                l.add(idss[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",spzt);param.put("djbhs",l);
            int flag=gcxczljcService.spGcxczljc(param);
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
