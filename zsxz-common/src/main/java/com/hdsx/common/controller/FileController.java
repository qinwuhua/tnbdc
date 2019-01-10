package com.hdsx.common.controller;

import com.hdsx.common.entity.Msg;
import com.hdsx.common.entity.Xtfile;
import com.hdsx.common.service.FileService;
import com.hdsx.common.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@Api(value = "文件信息")
@RequestMapping("common")
public class FileController {

    @Resource
    private FileService fileService;

    @PostMapping(value = "uploadFile")
    @ApiOperation(value = "文件上传信息")
    public Msg uploadFiles(@RequestParam("file") MultipartFile file) {
        try {
            HashMap<String, Object> fileMap = fileService.uploadFiles(file);
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

    @GetMapping("getFilesDataById")
    @ApiOperation(value = "根据关联表单ID查找文件")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "id", value = "表单关联ID", required = true)
    public Msg getFilesDataById(@RequestParam("id") String id){
        try {
            return ResultUtil.success(fileService.getFilesDataById(id));
        }catch (Exception e){
            return ResultUtil.error("文件查询失败！");
        }
    }

    @DeleteMapping("deleteFilesDataById")
    @ApiOperation("根据关联表单ID删除文件")
    @ApiImplicitParam(paramType="query", dataType = "String", name = "ids", value = "表单关联ID", required = true)
    public Msg deleteFilesByFid(@RequestParam("ids")String[] ids){
        try {
            if (fileService.deleteFilesByFid(ids)>0){
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
    public Msg addFileDataToFiles(@RequestBody Xtfile xtfile){
        try {
            if (fileService.addFileDataToFiles(xtfile.getDataList()) > 0){
                return ResultUtil.success("文件添加成功！");
            }else {
                return ResultUtil.error("文件添加失败!");
            }
        }catch (Exception e){
            return ResultUtil.error("接口出错！");
        }
    }

}
