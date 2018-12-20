package com.hdsx.lkpd.controller;


import com.hdsx.lkpd.entity.Msg;
import com.hdsx.lkpd.entity.Qmldb;
import com.hdsx.lkpd.service.LkpdDrService;
import com.hdsx.lkpd.service.QmldbService;
import com.hdsx.lkpd.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("lkpd/dr")
@Api(value = "路况数据导入控制器")
public class LkpdDrController {

    @Resource
    private LkpdDrService lkpdDrService;



    @RequestMapping(value = "getPciForLksjdr", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ldcode", value = "路段编码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "xcfx", value = "行车方向", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bbid", value = "版本id", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取检测数据导入-PCI")
    public Msg getPciForLksjdr(@RequestParam("ldcode") String ldcode,
                               @RequestParam("xcfx") String xcfx,
                               @RequestParam("bbid") String bbid,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("ldcode",ldcode);param.put("xcfx",xcfx);param.put("bbid",bbid);param.put("lmlx","1");
        param.put("lxid","0101");//这个是设置成PCI的类型
        List<Qmldb> list = lkpdDrService.getLksjdrByDclx(param, pageNum, pageSize);

        return ResultUtil.success(list);
    }

    @RequestMapping(value = "getSciForLksjdr", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取检测数据导入-SCI")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ldcode", value = "路段编码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "xcfx", value = "行车方向", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bbid", value = "版本id", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getSciForLksjdr(@RequestParam("ldcode") String ldcode,
                               @RequestParam("xcfx") String xcfx,
                               @RequestParam("bbid") String bbid,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("ldcode",ldcode);param.put("xcfx",xcfx);param.put("bbid",bbid);param.put("lmlx","1");
        param.put("lxid","02");//这个是设置成SCI的类型
        List<Qmldb> list = lkpdDrService.getLksjdrByDclx(param,pageNum,pageSize);

        return ResultUtil.success(list);
    }

    @RequestMapping(value = "getBciForLksjdr", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取检测数据导入-BCI")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ldcode", value = "路段编码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "xcfx", value = "行车方向", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bbid", value = "版本id", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getBciForLksjdr(@RequestParam("ldcode") String ldcode,
                               @RequestParam("xcfx") String xcfx,
                               @RequestParam("bbid") String bbid,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("ldcode",ldcode);param.put("xcfx",xcfx);param.put("bbid",bbid);param.put("lmlx","1");
        param.put("lxid","03");//这个是设置成BCI的类型
        List<Qmldb> list = lkpdDrService.getLksjdrByDclx(param,pageNum,pageSize);

        return ResultUtil.success(list);
    }

    @RequestMapping(value = "getTciForLksjdr", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取检测数据导入-TCI")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "ldcode", value = "路段编码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "xcfx", value = "行车方向", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bbid", value = "版本id", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getTciForLksjdr(@RequestParam("ldcode") String ldcode,
                               @RequestParam("xcfx") String xcfx,
                               @RequestParam("bbid") String bbid,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("ldcode",ldcode);param.put("xcfx",xcfx);param.put("bbid",bbid);param.put("lmlx","1");
        param.put("lxid","04");//这个是设置成TCI的类型
        List<Qmldb> list = lkpdDrService.getLksjdrByDclx(param,pageNum,pageSize);

        return ResultUtil.success(list);
    }


    @RequestMapping(value = "getRqiForLksjdr", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取检测数据导入-RQI")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "lxcode", value = "路线编码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "xcfx", value = "行车方向", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bbid", value = "版本id", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getRqiForLksjdr(@RequestParam("lxcode") String lxcode,
                               @RequestParam("xcfx") String xcfx,
                               @RequestParam("bbid") String bbid,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("lxcode",lxcode);param.put("xcfx",xcfx);param.put("bbid",bbid);param.put("lmlx","1");
        param.put("jclx","0401");//这个是设置成RQI的检测类型
        List<Qmldb> list = lkpdDrService.getLksjdrByJclx(param,pageNum,pageSize);

        return ResultUtil.success(list);
    }


    @RequestMapping(value = "getRdiForLksjdr", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取检测数据导入-RDI")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "lxcode", value = "路线编码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "xcfx", value = "行车方向", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bbid", value = "版本id", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getRdiForLksjdr(@RequestParam("lxcode") String lxcode,
                               @RequestParam("xcfx") String xcfx,
                               @RequestParam("bbid") String bbid,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("lxcode",lxcode);param.put("xcfx",xcfx);param.put("bbid",bbid);param.put("lmlx","1");
        param.put("jclx","0402");//这个是设置成RDI的检测类型
        List<Qmldb> list = lkpdDrService.getLksjdrByJclx(param,pageNum,pageSize);

        return ResultUtil.success(list);
    }


    @RequestMapping(value = "getSriForLksjdr", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取检测数据导入-SRI")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "lxcode", value = "路线编码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "xcfx", value = "行车方向", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bbid", value = "版本id", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getSriForLksjdr(@RequestParam("lxcode") String lxcode,
                               @RequestParam("xcfx") String xcfx,
                               @RequestParam("bbid") String bbid,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("lxcode",lxcode);param.put("xcfx",xcfx);param.put("bbid",bbid);param.put("lmlx","1");
        param.put("jclx","0403");//这个是设置成SRI的检测类型
        List<Qmldb> list = lkpdDrService.getLksjdrByJclx(param,pageNum,pageSize);

        return ResultUtil.success(list);
    }


    @RequestMapping(value = "getPssiForLksjdr", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取检测数据导入-PSSI")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "lxcode", value = "路线编码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "xcfx", value = "行车方向", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "bbid", value = "版本id", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType="query", dataType = "int", name = "pageSize", value = "每页条数", required = true)
    })
    public Msg getPssiForLksjdr(@RequestParam("lxcode") String lxcode,
                               @RequestParam("xcfx") String xcfx,
                               @RequestParam("bbid") String bbid,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Map<String,String> param=new HashMap<String,String>();
        param.put("lxcode",lxcode);param.put("xcfx",xcfx);param.put("bbid",bbid);param.put("lmlx","1");
        param.put("jclx","0404");//这个是设置成PSSI的检测类型
        List<Qmldb> list = lkpdDrService.getLksjdrByJclx(param,pageNum,pageSize);

        return ResultUtil.success(list);
    }

}
