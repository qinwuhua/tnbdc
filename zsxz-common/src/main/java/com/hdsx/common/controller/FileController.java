package com.hdsx.common.controller;

import com.hdsx.common.entity.FileData;
import com.hdsx.common.entity.Msg;
import com.hdsx.common.service.FileService;
import com.hdsx.common.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@Api(value = "文件信息")
@RequestMapping("common")
public class FileController {

    @Resource
    private FileService fileService;

    @PostMapping(value = "uploadFile")
    @ApiOperation(value = "文件上传信息")
    public Msg uploadFiles(@RequestParam("multipartFile") MultipartFile multipartFile) {
        try {
            HashMap<String, Object> fileMap = fileService.uploadFiles(multipartFile);
            if (fileMap != null){
                return ResultUtil.success(fileMap);
            }else {
                return ResultUtil.error("文件上传失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("接口错误！");
        }
    }

    @PostMapping("getFilesDataById")
    @ApiOperation(value = "根据表单ID查找文件")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "表单主键ID", required = true)
    public Msg getFilesDataById(@RequestParam("id") String id){
        try {
            return ResultUtil.success(fileService.getFilesDataById(id));
        }catch (Exception e){
            return ResultUtil.error("文件查询失败！");
        }
    }

    @DeleteMapping("deleteFilesById")
    @ApiOperation("根据表单ID删除文件")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "表单主键ID", required = true)
    public Msg deleteFilesById(@RequestParam("id")String id){
        try {
            if (fileService.deleteFilesById(id)>0){
                return ResultUtil.success("文件删除成功！");
            }else {
                return ResultUtil.error("文件删除失败！");
            }
        }catch (Exception e){
            return ResultUtil.error("接口出错！");
        }
    }


    @PostMapping("addFileDataToFiles")
    @ApiOperation("保存文件信息")
    @ApiImplicitParam(paramType="query", dataType = "array", name = "fileDataList", value = "文件信息", allowMultiple = true, required = true)
    public Msg addFileDataToFiles(@RequestParam("fileDataList") List<FileData> fileDataList){
        try {
            if (fileService.addFileDataToFiles(fileDataList) > 0){
                return ResultUtil.success("文件添加成功！");
            }else {
                return ResultUtil.error("文件添加失败!");
            }
        }catch (Exception e){
            return ResultUtil.error("接口出错！");
        }
    }

    @PostMapping("updateFileDataToFiles")
    @ApiOperation("编辑文件信息")
    @ApiImplicitParam(paramType="query", dataType = "array", name = "fileDataList", value = "文件信息", allowMultiple = true, required = true)
    public Msg updateFileDataToFiles(@RequestParam("fileDataList") List<FileData> fileDataList){
        try {
            if (fileService.updateFileDataToFiles(fileDataList) > 0){
                return ResultUtil.success("文件更新成功！");
            }else {
                return ResultUtil.error("文件更新失败!");
            }
        }catch (Exception e){
            return ResultUtil.error("接口出错！");
        }
    }
}
