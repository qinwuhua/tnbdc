package com.hdsx.lkpd.controller;


import com.hdsx.lkpd.entity.Msg;
import com.hdsx.lkpd.entity.Qmldb;
import com.hdsx.lkpd.service.LkpdDrService;
import com.hdsx.lkpd.service.QmldbService;
import com.hdsx.lkpd.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@Api(value = "路况数据导入控制器")
public class LkpdDrController {

    @Resource
    private QmldbService qmldbService;
    @Resource
    private LkpdDrService lkpdDrService;

    @GetMapping("getQmldForLkdc")
    public Msg getQmldForLkdc(Qmldb qmldb){
        List<Qmldb> list = qmldbService.getQmldForLkdc(qmldb);
        return ResultUtil.success(list);
    }

    /**
     *
     * @param ldcode 路段编码
     * @param xcfx  行车方向
     * @param bbid  版本id
     * @param lmlx  路面类型
     * @return  msg
     */
    @RequestMapping(value = "getPciForLksjdr", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "获取检测数据导入-PCI")
    public Msg getPciForLksjdr(@RequestParam("ldcode") String ldcode,
                               @RequestParam("xcfx") String xcfx,
                               @RequestParam("bbid") String bbid,
                               @RequestParam("lmlx") String lmlx){
        Map<String,String> param=new HashMap<String,String>();
        param.put("ldcode",ldcode);param.put("xcfx",xcfx);param.put("bbid",bbid);param.put("lmlx",lmlx);
        //这个是设置成PCI的类型
        param.put("lxid","01");
        List<Qmldb> list = lkpdDrService.getLksjdrBylx(param);

        return ResultUtil.success(list);
    }

}
