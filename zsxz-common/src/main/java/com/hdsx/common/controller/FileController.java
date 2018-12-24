package com.hdsx.common.controller;

import com.hdsx.common.entity.Msg;
import com.hdsx.common.service.FileService;
import com.hdsx.common.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@Api(value = "文件信息")
@RequestMapping("common")
public class FileController {

    @Resource
    private FileService fileService;

    @PostMapping("uploadFiles")
    @ApiOperation(value = "文件上传信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "表单主键ID", required = true),
            @ApiImplicitParam(paramType="formData", dataType = "MultipartFile", name = "multipartFiles", value = "附件", allowMultiple = true, required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "type", value = "文件类型", required = true)
    })
    public Msg uploadFiles(@RequestParam("id") String id,
                           @RequestParam("multipartFiles") MultipartFile[] multipartFiles,
                           @RequestParam("type") String type) {
        try {
            return ResultUtil.success(fileService.uploadFiles(id, multipartFiles, type));
        } catch (Exception e) {
            return ResultUtil.error("文件上传失败！");
        }
    }

    @PostMapping("getFilesDataById")
    @ApiOperation(value = "根据外键ID查找文件")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "表单主键ID", required = true)
    public Msg getFilesDataById(@RequestParam("id") String id){
        try {
            return ResultUtil.success(fileService.getFilesDataById(id));
        }catch (Exception e){
            return ResultUtil.error("文件查询失败！");
        }
    }

    @DeleteMapping("deleteFilesById")
    @ApiOperation("根据外键ID删除文件")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "表单主键ID", required = true)
    public Msg deleteFilesById(@RequestParam("id")String id){
        if (fileService.deleteFilesById(id)){
            return ResultUtil.success("文件删除成功！");
        }else {
            return ResultUtil.error("文件删除失败！");
        }
    }

    @PutMapping("updateFilesById")
    @ApiOperation("根据根据外键ID更新文件")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "表单主键ID", required = true),
            @ApiImplicitParam(paramType="formData", dataType = "MultipartFile", name = "multipartFiles", value = "附件", allowMultiple = true, required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "type", value = "文件类型", required = true)
    })
    public Msg updateFiles(@RequestParam("id")String id,
                              @RequestParam("multipartFiles") MultipartFile[] multipartFiles,
                              @RequestParam("type") String type){
        try {
            return ResultUtil.success(fileService.updateFiles(id, multipartFiles, type));
        } catch (Exception e) {
            return ResultUtil.error("文件更新失败！");
        }
    }
}
