package com.hdsx.rcyh.controller;

import com.hdsx.rcyh.entity.ExcelData;
import com.hdsx.rcyh.entity.ExcelTitle;
import com.hdsx.rcyh.entity.Msg;
import com.hdsx.rcyh.service.TestService;
import com.hdsx.rcyh.utils.ExcelExport;
import com.hdsx.rcyh.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@Api(value = "测试类")
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("test")
    @ApiOperation(value = "测试方法")
    public Msg test(){
        try {
            return ResultUtil.success(testService.test());
        }catch (Exception e){
            return ResultUtil.error("请求失败！");
        }
    }

    @GetMapping("excel")
    @ApiOperation(value = "测试导出EXCEL")
    public Msg exportExcel(HttpServletResponse response){
        List<HashMap<String, Object>> queryData = testService.exportExcel();
        ExcelData excelData = new ExcelData();
        excelData.setTitleName("测试报表");
        excelData.setSheetName("测试报表");
        excelData.setFileName("测试报表");
        excelData.setRowSum(5);
        excelData.setDataList(queryData);
        List<ExcelTitle> excelTitles = new ArrayList<>();
        excelTitles.add(new ExcelTitle("序号",1,1,0,0));
        excelTitles.add(new ExcelTitle("名称",1,1,1,1));
        excelTitles.add(new ExcelTitle("类型",1,1,2,2));
        excelTitles.add(new ExcelTitle("检查员",1,1,3,3));
        excelData.setTitles(excelTitles);
        try {
            ExcelExport.excel_export(excelData,response);
        }catch (Exception e){
            return ResultUtil.error("导出失败！");
        }
        return ResultUtil.success(queryData);
    }


}
