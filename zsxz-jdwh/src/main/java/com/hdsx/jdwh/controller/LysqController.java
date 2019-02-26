package com.hdsx.jdwh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.jdwh.entity.Msg;
import com.hdsx.jdwh.entity.Lysq;
import com.hdsx.jdwh.service.LysqService;
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
@Api(value = "领用申请控制器",description = "领用申请控制器")
public class LysqController {

    @Resource
    private LysqService lysqService;

    @RequestMapping(value = "getBjLyInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取备件信息")
    public Msg getBjLyInfo(){
        try {
            Map<String, String> param = new HashMap<String, String>();
            List<Map<String,String>> map=lysqService.getBjLyInfo(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }
    }

    @RequestMapping(value = "addLysq", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加领用申请")
    public Msg addLysq(@RequestBody Lysq lysq){
        try {
            //判断是否大于数量
            for(int i=0;i<lysq.getMx().size();i++){
                Map<String, String> param = new HashMap<String, String>();
                param.put("bjmc",lysq.getMx().get(i).getBjmc());
                param.put("bjbh",lysq.getMx().get(i).getBjbm());
                param.put("ggxh",lysq.getMx().get(i).getGgxh());
                List<Map<String,String>> map=lysqService.getBjLyInfo(param);
                if(Double.parseDouble(lysq.getMx().get(i).getXysl()) > Double.parseDouble(String.valueOf(map.get(0).get("xysl")) ) ) {
                    return ResultUtil.error("数量超过已有数量,保存失败");
                }
            }
            int flag=lysqService.addLysq(lysq);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }


    @RequestMapping(value = "editLysq", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑领用申请")
    public Msg editLysq(@RequestBody Lysq lysq){
        try {
            //判断是否大于数量
            for(int i=0;i<lysq.getMx().size();i++){
                Map<String, String> param = new HashMap<String, String>();
                param.put("bjmc",lysq.getMx().get(i).getBjmc());
                param.put("bjbh",lysq.getMx().get(i).getBjbm());
                param.put("ggxh",lysq.getMx().get(i).getGgxh());
                int xx=0;
                //param.put("id",lysq.getMx().get(i).getId());
                List<Map<String,String>> map=lysqService.getBjLyInfo(param);
                if(Double.parseDouble(lysq.getMx().get(i).getXysl()) > Double.parseDouble(String.valueOf(map.get(0).get("xysl")) ) ) {
                    return ResultUtil.error("数量超过已有数量,保存失败");
                }
            }

            int flag=lysqService.editLysq(lysq);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }

    @RequestMapping(value = "delLysqBydjbhs", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除领用申请")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delLysqBydjbhs(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] id=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<id.length;i++){
                l.add(id[i]);
            }
            int flag=lysqService.delLysqBydjbhs(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }

    @RequestMapping(value = "getLysqInfoByDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取领用申请")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getLysqInfoByDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Lysq lysq=lysqService.getLysqInfoByDjbh(djbh);
            return ResultUtil.success(lysq);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "getLysqList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ksrq", value = "开始日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "jsrq", value = "结束日期(yyyy/mm/dd)", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询领用申请列表数据")
    public Msg getLysqList(@RequestParam(value = "djbh",required = false) String djbh,
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
        List<Lysq> list = lysqService.getLysqList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Lysq>(list));
    }

    /*




    */


}
