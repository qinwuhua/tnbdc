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
import java.net.InetAddress;
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

    @Value("${file.fileUrl}")
    private String fileUrl;

    @Resource
    FileMapper fileMapper;

    @Override
    public HashMap<String, Object> uploadFiles(MultipartFile multipartFile) {
        if (multipartFile != null) {
            SimpleDateFormat nyr = new SimpleDateFormat("yyyyMMdd");
            String nyrdate = nyr.format(new Date());
            String filePath = fileSavePath + nyrdate+"/"; //文件服务器访问路径
            String fileHttpUrl = fileUrl + nyrdate+"/"; //文件HTTP访问路径
            File fileFold = new File(filePath);
            if (!fileFold.exists()) {
                fileFold.mkdirs();
            }
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            HashMap<String,Object> urlMap = new HashMap<>();
            String fileName = multipartFile.getOriginalFilename();
            //文件重命名
            String newFileName= "hdsx_" + System.currentTimeMillis() + "_" + fileName;
            File dest = new File(filePath + newFileName);
            DecimalFormat df = new DecimalFormat("#.00");
            try {
                multipartFile.transferTo(dest); //保存文件
                urlMap.put("file_yname",fileName);
                urlMap.put("file_type","."+fileName.substring(fileName.lastIndexOf(".") + 1));
                urlMap.put("file_name",newFileName);
                urlMap.put("file_path", fileHttpUrl + newFileName);
                if(multipartFile.getSize()/1024<1024){
                    urlMap.put("file_dx",df.format((float)multipartFile.getSize()/1024)+"KB");
                }else{
                    urlMap.put("file_dx",df.format((float)multipartFile.getSize()/1024/1024)+"MB");
                }
                urlMap.put("file_mjlx","");
                urlMap.put("remarks","");
                urlMap.put("file_status","0101");
                urlMap.put("file_depict","");
                urlMap.put("id",uuid);
                urlMap.put("file_date",nyrdate);
                return urlMap;
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return urlMap;
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
    public List<FileData> getFilesDataById(String id) {
        return fileMapper.getFilesDataById(id);
    }


    @Override
    public int deleteFilesByFid(String[] ids) {
        for(String id : ids){
            List<FileData> fileUrl = fileMapper.getFilesDataById(id);
            for (int i = 0; i < fileUrl.size(); i++){
                File file = new File(fileSavePath+fileUrl.get(i).getFile_date()+File.separator+fileUrl.get(i).getFile_name());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            }
        }
        return fileMapper.deleteFilesByFid(ids);
    }


    @Override
    public int addFileDataToFiles(List<FileData> fileDataList) {
        if (fileDataList != null && fileDataList.size() > 0){
            return fileMapper.addFileDataToFiles(fileDataList);
        }
        return 0;
    }

}
