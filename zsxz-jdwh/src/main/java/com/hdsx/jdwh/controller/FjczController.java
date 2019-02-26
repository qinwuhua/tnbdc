package com.hdsx.jdwh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.jdwh.entity.Fjcz;
import com.hdsx.jdwh.entity.Msg;
import com.hdsx.jdwh.service.FjczService;
import com.hdsx.jdwh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("jdwh/bjgl")
@Api(value = "废件处置控制器",description = "废件处置控制器")
public class FjczController {

    @Resource
    private FjczService fjczService;

    @RequestMapping(value = "addFjcz", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加废件处置")
    public Msg addFjcz(@RequestBody Fjcz fjcz){
        try {
            int flag=fjczService.addFjcz(fjcz);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "editFjcz", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑废件处置")
    public Msg editFjcz(@RequestBody Fjcz fjcz){
        try {
            int flag=fjczService.editFjcz(fjcz);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "delFjczByDjbhs", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除废件处置")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delFjczByDjbhs(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] id=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<id.length;i++){
                l.add(id[i]);
            }
            int flag=fjczService.delFjczByDjbhs(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "getFjczInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过id获取废件处置")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getFjczInfoByDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Fjcz fjcz=fjczService.getFjczInfoByDjbh(djbh);
            return ResultUtil.success(fjcz);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getFjczList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询废件处置列表数据")
    public Msg getFjczList(@RequestParam(value = "djbh",required = false) String djbh,
                           @RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                           @RequestParam(value = "ksrq",required = false) String ksrq,
                           @RequestParam(value = "jsrq",required = false) String jsrq,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("djbh", djbh);
        param.put("tbdwdm", tbdwdm);
        param.put("ksrq", ksrq);
        param.put("jsrq", jsrq);
        List<Fjcz> list = fjczService.getFjczList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Fjcz>(list));
    }

    @RequestMapping(value = "spFjczByDjbh", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "审批废件处置")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg spFjczByDjbh(@RequestParam(value = "djbhs",required = true) String djbhs,
                            @RequestParam(value = "spzt",required = true) String spzt){
        try {
            String[] djbh=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<djbh.length;i++){
                l.add(djbh[i]);
            }
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("spzt",spzt);param.put("djbhs",l);
            int flag=fjczService.spFjczByDjbh(param);
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
