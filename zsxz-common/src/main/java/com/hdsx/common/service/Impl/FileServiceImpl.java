package com.hdsx.common.service.Impl;

import com.hdsx.common.entity.FileData;
import com.hdsx.common.mapper.FileMapper;
import com.hdsx.common.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Value("${file.fileSavePath}")
    private String fileSavePath;

    @Resource
    FileMapper fileMapper;

    @Override
    public HashMap<String, Object> uploadFiles(MultipartFile multipartFile) {
        if (multipartFile != null) {
            SimpleDateFormat nyr = new SimpleDateFormat("yyyyMMdd");
            String nyrdate = nyr.format(new Date());
            String filePath = fileSavePath + nyrdate+"/";
            File fileFold = new File(filePath);
            if (!fileFold.exists()) {
                fileFold.mkdirs();
            }
            return this.transferTo(multipartFile,filePath);
        }

/*        List<HashMap<String, Object>> fileList = new ArrayList<>();
        if (multipartFiles != null && multipartFiles.length >0){
            String filePath = fileSavePath + type + "/";
            File fileFold = new File(filePath);
            if (!fileFold.exists()){
                fileFold.mkdirs();
            }
            for (int i = 0; i < multipartFiles.length; i++){
                MultipartFile file = multipartFiles[i];
                HashMap<String, Object> fileMap = this.transferTo(file,filePath);
                fileMap.put("files_id", id);
                if (fileMapper.addFiles(fileMap)){
                    fileList.add(fileMap);
                }
            }
            return fileList;
        }*/
        return null;
    }

    @Override
    public List<HashMap<String, Object>> getFilesDataById(String id) {
        return fileMapper.getFilesDataById(id);
    }

    @Override
    public int deleteFilesById(String id) {
        List<HashMap<String, Object>> fileUrl = fileMapper.getFilesDataById(id);
        for (int i = 0; i < fileUrl.size(); i++){
            File file = new File(String.valueOf(fileUrl.get(i).get("FILES_PATH")));
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }
        return fileMapper.deleteFilesDataById(id);
    }

    public HashMap<String,Object> transferTo(MultipartFile file, String filePath) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        HashMap<String,Object> urlMap = new HashMap<>();
        String fileName = file.getOriginalFilename();
        /*String name = file.getName();*/
        //文件重命名
        String newFileName= "hdsx_" + System.currentTimeMillis() + "_" + fileName;
        /*int size = (int) file.getSize();*/
        /*System.out.println(fileName + "-->" + size);*/
        //获得文件夹
        /*SimpleDateFormat nyr = new SimpleDateFormat("yyyyMMdd");
        String nyrdate = nyr.format(new Date());
        File dest = new File(path +"/" +nyrdate+"/"+ newFileName);

        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdirs();
        }*/
        File dest = new File(filePath + newFileName);
        DecimalFormat df = new DecimalFormat("#.00");
        try {
            file.transferTo(dest); //保存文件
            urlMap.put("files_yname",fileName);
            urlMap.put("files_type","."+fileName.substring(fileName.lastIndexOf(".") + 1));
            urlMap.put("files_name",newFileName);
            urlMap.put("files_path",filePath + newFileName);
            /*urlMap.put("files_path",imageServer+"/" +nyrdate+"/"+ newFileName);*/
            if(file.getSize()/1024<1024){
                urlMap.put("files_dx",df.format((float)file.getSize()/1024)+"KB");
            }else{
                urlMap.put("files_dx",df.format((float)file.getSize()/1024/1024)+"MB");
            }
            urlMap.put("files_mjlx","");
            urlMap.put("remarks","");
            urlMap.put("files_status","0101");
            urlMap.put("files_depict","");
            urlMap.put("id",uuid);
            return urlMap;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addFileDataToFiles(List<FileData> fileDataList) {
        if (fileDataList != null && fileDataList.size() > 0){
            return fileMapper.addFileDataToFiles(fileDataList);
        }
        return 0;
    }

    @Override
    public int updateFileDataToFiles(List<FileData> fileDataList){
        if (fileDataList != null && fileDataList.size() > 0){
            fileMapper.deleteFilesDataById(fileDataList.get(0).getFile_id());
        }
        return fileMapper.addFileDataToFiles(fileDataList);
    }
}
