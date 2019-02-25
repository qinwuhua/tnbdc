package com.hdsx.rcyh.controller;

import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.entity.Yhrwysd;
import com.hdsx.rcyh.service.RcyhXxrwService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日常养护 - 小修任务 - Controller
 * @author LiRui
 * @created 2019/2/22
 */

@RestController
@RequestMapping("rcyhYhrwysd")
@Api(value = "日常养护 - 养护任务验收单",description = "日常养护 - 养护任务验收单接口：2019-02-22")
public class RcyhYhrwysController {

    @Resource
    private RcyhXxrwService service;

    /**
     * 将字符串类型的日期去除“-”，形成“yyyyMMdd”格式
     * @param dateStr
     * @return
     */
    public String dealDateStrToString(String dateStr){
        if(dateStr != null && !"".equals(dateStr)){
            return dateStr.replace("-", "");
        }
        return "";
    }

    /**
     * 将页码，页数放入Map
     * @param pageNum
     * @param pageSize
     */
    public Map dealPageParame(int pageNum, int pageSize){
        Map map = new HashMap();
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        return map;
    }

    @GetMapping("getHtxxList")
    @ApiOperation("获取合同信息List（下拉框） - 用于：添加“养护验收单”时，选择“工程项目”")
    public List<Map> getHtxxList(){
        try {
            return service.getHtxxList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加“养护任务验收单”数据
     * @param yhrwysd
     * @return
     */
    @PostMapping("insertYhrwysd")
    @ApiOperation("（未测试）添加“养护任务验收单”数据")
    public Msg insertYhrwysd(@RequestBody Yhrwysd yhrwysd){
        try {
            if (service.insertYhrwysd(yhrwysd)) {
                return ResultUtil.success("添加成功！");
            }
            return ResultUtil.error("添加失败！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    @GetMapping("getBhListByHtxxID")
    @ApiOperation("根据“合同信息ID - yhhtxxhtbh”和“月度ysdyd”，通过“任务单ID”查询病害列表（目前仅有“养护任务单”）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "yhhtxxhtbh", value = "合同编号（合同的主键）", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ysdyd", value = "月度（格式为：2019-01）", required = true)
    })
    public List<Map> getBhListByHtxxID(
        @RequestParam(value = "yhhtxxhtbh",required = false)String yhhtxxhtbh,
        @RequestParam(value = "ysdyd",required = false)String ysdyd){
        try {
            //yhhtxxhtbh = HT-CS-20180000002
            //ysdyd = 2019-02
            //当参数为上述内容时，有数据
            Map map = new HashMap();
            map.put("yhhtxxhtbh", yhhtxxhtbh);
            map.put("ysdyd", dealDateStrToString(ysdyd));
            return service.getBhListByHtxxID(map);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("getYsdList")
    @ApiOperation("获取验收单数据列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ysdyhdw", value = "养护单位名称"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ysdgldw", value = "管理单位名称"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ysdlx", value = "路线名称"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "stime", value = "开始时间"),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "etime", value = "结束时间"),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getYsdList(
            @RequestParam(value = "ysdyhdw",required = false)String ysdyhdw,
            @RequestParam(value = "ysdgldw",required = false)String ysdgldw,
            @RequestParam(value = "ysdlx",required = false)String ysdlx,
            @RequestParam(value = "stime",required = false) String stime,
            @RequestParam(value = "etime",required = false) String etime,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        try {
            Map map = dealPageParame(pageNum, pageSize);
            map.put("ysdyhdw", ysdyhdw);
            map.put("ysdgldw", ysdgldw);
            map.put("ysdlx", ysdlx);
            map.put("stime", dealDateStrToString(stime));
            map.put("etime", dealDateStrToString(etime));
            return ResultUtil.success(service.getYsdList(map));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败！");
        }
    }

    @GetMapping("updateYhrwysdYS")
    @ApiOperation("根据“养护任务验收单ID”，验收“养护任务验收单”数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query", dataType = "String", name = "ysdid", value = "养护任务验收单ID", required = true),
        @ApiImplicitParam(paramType="query", dataType = "String", name = "ysdysyj", value = "养护任务验收单ID", required = true),
    })
    public Msg updateYhrwysdYS(
            @RequestParam(value = "ysdid",required = false)String ysdid,
            @RequestParam(value = "ysdysyj",required = false)String ysdysyj
    ){
        try {
            Map parMap = new HashMap();
            parMap.put("ysdid", ysdid);
            parMap.put("ysdysyj", ysdysyj);
            if (service.updateYhrwysdYS(parMap)) {
                return ResultUtil.success("验收成功！");
            }
            return ResultUtil.error("验收失败！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

}
