package com.hdsx.jdwh.controller;


import com.github.pagehelper.PageInfo;
import com.hdsx.jdwh.entity.Gzbx;
import com.hdsx.jdwh.entity.Msg;
import com.hdsx.jdwh.entity.Wxdj;
import com.hdsx.jdwh.service.WxdjService;
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
@RequestMapping("jdwh/xjwx")
@Api(value = "维修登记控制器",description = "维修登记控制器")
public class WxdjController {

    @Resource
    private WxdjService wxdjService;

    @RequestMapping(value = "getBxdInfo", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取报修单信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query", dataType = "String", name = "ssdwdm", value = "单位代码", required = false),
        @ApiImplicitParam(paramType="query", dataType = "String", name = "bxdh", value = "报修单号", required = false)
    })

    public Msg getBxdInfo(@RequestParam(value = "ssdwdm",required = false) String ssdwdm,
                          @RequestParam(value = "bxdh",required = false) String bxdh){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("ssdwdm",ssdwdm);param.put("bxdh",bxdh);
            List<Wxdj> map=wxdjService.getBxdInfo(param);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }

    @RequestMapping(value = "addWxdj", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加维修登记")
    public Msg addWxdj(@RequestBody Wxdj wxdj){
        try {
            int flag=wxdjService.addWxdj(wxdj);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "editWxdj", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "编辑维修登记")
    public Msg editWxdj(@RequestBody Wxdj wxdj){
        try {
            int flag=wxdjService.editWxdj(wxdj);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }

    }


    @RequestMapping(value = "delWxdjByDjbhs", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除维修登记")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbhs", value = "单据编号(以“,”隔开)", required = true)
    public Msg delWxdjByDjbhs(@RequestParam(value = "djbhs",required = true) String djbhs){
        try {
            String[] id=djbhs.split(",");
            List<String> l = new ArrayList<String>();
            for (int i=0;i<id.length;i++){
                l.add(id[i]);
            }
            int flag=wxdjService.delWxdjByDjbhs(l);
            if(flag>0)
                return ResultUtil.success("删除成功");
            else
                return ResultUtil.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("删除失败，接口异常");
        }

    }


    @RequestMapping(value = "getWxdjInfoByIDjbh", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "通过单据编号获取维修登记")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "djbh", value = "单据编号", required = true)
    public Msg getWxdjInfoByIDjbh(@RequestParam(value = "djbh",required = true) String djbh){
        try {
            Wxdj wxdj=wxdjService.getWxdjInfoByIDjbh(djbh);
            return ResultUtil.success(wxdj);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }

    }


    @RequestMapping(value = "getWxdjList", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "tbdwdm", value = "单位代码", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bxdh", value = "报修单号", required = false),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询维修登记列表数据")
    public Msg getWxdjList(@RequestParam(value = "tbdwdm",required = false) String tbdwdm,
                           @RequestParam(value = "bxdh",required = false) String bxdh,
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("tbdwdm", tbdwdm);
        param.put("bxdh", bxdh);
        List<Wxdj> list = wxdjService.getWxdjList(param, pageNum, pageSize);
        return ResultUtil.success(new PageInfo<Wxdj>(list));
    }


    /*






*/

}
