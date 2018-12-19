package com.hdsx.lkpd.controller;


import com.hdsx.lkpd.entity.Msg;
import com.hdsx.lkpd.entity.Qmldb;
import com.hdsx.lkpd.service.QmldbService;
import com.hdsx.lkpd.utils.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Api(value = "路况数据导入控制器")
public class LkpdDrController {

    @Resource
    private QmldbService qmldbService;

    @GetMapping("getQmldForLkdc")
    public Msg getQmldForLkdc(Qmldb qmldb){
        List<Qmldb> list = qmldbService.getQmldForLkdc(qmldb);
        return ResultUtil.success(list);
    }

}
