package com.hdsx.rcyh.controller;

import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.entity.RcyhSjdj;
import com.hdsx.rcyh.service.AppRcyhSjdjService;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 事件登记
 * @author LiRui
 * @created 2019/2/26 0026
 */

@RestController
@RequestMapping("appRcyhSjdj")
@Api(value = "APP接口 - 事件登记",description = "APP接口 - 事件登记：2019-02-26")
public class AppRcyhSjdjController {

    @Resource
    private AppRcyhSjdjService service;

    /**
     * （单条）事件登记
     * @param bean
     * @return
     */
    @PostMapping("insertSj")
    @ApiOperation("（单条）病害登记")
    public Msg insertSj(@RequestBody RcyhSjdj bean){
        try {
            if (service.insertSj(bean)){
                return ResultUtil.success("（单条）事件已登记！");
            }
            return ResultUtil.error("（单条）事件登记异常！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

    /**
     * （批量）事件登记
     * @param list
     * @return
     */
    @PostMapping("batchInsertSj")
    @ApiOperation("（批量）病害登记")
    public Msg batchInsertSj(@RequestBody List<RcyhSjdj> list){
        try {
            if (service.batchInsertSj(list)){
                return ResultUtil.success("（批量）事件已登记！");
            }
            return ResultUtil.error("（批量）事件登记异常！");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("接口异常！");
        }
    }

}
