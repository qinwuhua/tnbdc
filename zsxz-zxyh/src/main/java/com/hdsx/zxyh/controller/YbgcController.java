package com.hdsx.zxyh.controller;

import com.github.pagehelper.PageInfo;
import com.hdsx.zxyh.entity.Msg;
import com.hdsx.zxyh.entity.Ybgc;
import com.hdsx.zxyh.service.YbgcService;
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
 * 隐蔽工程控制器
 */
@RestController
@RequestMapping("ybgc")
@Api(value = "隐蔽工程控制器", description = "隐蔽工程控制器")
public class YbgcController {

    @Resource
    private YbgcService ybgcService;

    @GetMapping("getYbgc")
    @ApiOperation("查询隐蔽工程")
    public Msg getYbgc(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        try {
            return ResultUtil.success(new PageInfo<>(ybgcService.getYbgc(pageNum, pageSize)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @PostMapping("addYbgc")
    @ApiOperation("增加隐蔽工程")
    public Msg addYbgc(@RequestBody Ybgc ybgc) {
        try {
            if (ybgcService.addYbgc(ybgc)>0) {
                return ResultUtil.success("增加隐蔽工程成功");
            } else {
                return ResultUtil.error("增加隐蔽工程失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @DeleteMapping("deleteYbgc")
    @ApiOperation("删除隐蔽工程")
    public Msg deleteYbgc(String[] ids){
        try {
            if (ybgcService.deleteYbgc(ids)>0) {
                return ResultUtil.success("删除隐蔽工程成功");
            } else {
                return ResultUtil.error("删除隐蔽工程失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口异常");
        }
    }

    @PutMapping("updateYbgc")
    @ApiOperation("更新隐蔽工程")
    public Msg updateYbgc(@RequestBody Ybgc ybgc) {
        try {
            if (ybgcService.updateYbgc(ybgc)>0) {
                return ResultUtil.success("更新隐蔽工程成功");
            } else {
                return ResultUtil.error("更新隐蔽工程失败");
            }
        } catch (Exception e) {
            return ResultUtil.error("接口异常");
        }
    }

    @RequestMapping(value = "spYbgc", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批隐蔽工程")
    public Msg spYbgc(@RequestParam(value = "ids",required = true) String ids,
                      @RequestParam(value = "spzt",required = true) String spzt){
        try {
            String[] idss=ids.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<idss.length;i++){
                l.add(idss[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",spzt);param.put("djbhs",l);
            int flag=ybgcService.spYbgc(param);
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
