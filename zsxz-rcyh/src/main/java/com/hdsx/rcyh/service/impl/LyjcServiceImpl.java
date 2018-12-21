package com.hdsx.rcyh.service.impl;

import com.hdsx.rcyh.entity.Lyjc;
import com.hdsx.rcyh.entity.Lyjcmxb;
import com.hdsx.rcyh.mapper.LyjcMapper;
import com.hdsx.rcyh.service.LyjcService;
import com.hdsx.rcyh.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class LyjcServiceImpl implements LyjcService {

    @Resource
    LyjcMapper lyjcMapper;

    @Value("${file.fileSavePath}")
    private String fileSavePath;

    @Value("${file.fileUrl}")
    private String fileUrl;

    @Override
    public List<HashMap<String, Object>> getLyjcAll() {
        return lyjcMapper.getLyjcAll();
    }

    @Override
    public List<HashMap<String, Object>> getDjsjHtxx() {
        return lyjcMapper.getDjsjHtxx();
    }

    @Override
    public List<HashMap<String, Object>> getDjsjLyjcmx() {
        return lyjcMapper.getDjsjLyjcmx();
    }

    @Override
    public List<HashMap<String, String>> addLyjc(Lyjc lyjc) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        List<HashMap<String, String>> fileList = new ArrayList<>();
        if (lyjc.getMultipartFiles() != null && lyjc.getMultipartFiles().size() > 0){
            File fileFold = new File(fileSavePath);
            if (!fileFold.exists()){
                fileFold.mkdirs();
            }
            for (int i = 0; i < lyjc.getMultipartFiles().size(); i++){
                MultipartFile file = lyjc.getMultipartFiles().get(i);
                HashMap<String, String> fileMap = FileUtil.transferTo(file,fileSavePath);
                fileMap.put("files_id", uuid);
                if (lyjcMapper.addFiles(fileMap)){
                    fileList.add(fileMap);
                }
            }
            lyjc.setId(uuid);
            lyjcMapper.addLyjc(lyjc);
            for (Lyjcmxb lyjcmxb : lyjc.getLyjcmxb()){
                String id = "LYJC_" + System.currentTimeMillis();
                lyjcmxb.setId(id);
                lyjcmxb.setMid(uuid);
                lyjcMapper.addLyjcmxb(lyjcmxb);
            }
            return fileList;
        }else {
            return null;
        }
    }

    @Override
    public boolean deleteLyjc(String id) {
        List<HashMap<String, Object>> fileUrl = lyjcMapper.getFilesDataById(id);
        for (int i = 0; i < fileUrl.size(); i++){
            File file = new File(fileSavePath + fileUrl.get(i).get("FILES_NAME"));
            if (file.isFile() && file.exists()) {
                file.delete();
            }else{
                return false;
            }
        }
        if (lyjcMapper.deleteFilesDataById(id)){
            if (lyjcMapper.deleteLyjcmxbById(id)){
                if (lyjcMapper.deleteLyjcById(id)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<HashMap<String, String>> updateLyjc(Lyjc lyjc) {
        List<HashMap<String, Object>> fileUrl = lyjcMapper.getFilesDataById(lyjc.getId());
        for (int i = 0; i < fileUrl.size(); i++){
            File file = new File(fileSavePath + fileUrl.get(i).get("FILES_NAME"));
            if (file.isFile() && file.exists()) {
                file.delete();
            }else{
                return null;
            }
        }
        if (lyjcMapper.deleteFilesDataById(lyjc.getId())){
            if (lyjcMapper.deleteLyjcmxbById(lyjc.getId())){
                List<HashMap<String, String>> fileList = new ArrayList<>();
                if (lyjc.getMultipartFiles() != null && lyjc.getMultipartFiles().size() > 0){
                    File fileFold = new File(fileSavePath);
                    if (!fileFold.exists()){
                        fileFold.mkdirs();
                    }
                    for (int i = 0; i < lyjc.getMultipartFiles().size(); i++){
                        MultipartFile file = lyjc.getMultipartFiles().get(i);
                        HashMap<String, String> fileMap = FileUtil.transferTo(file,fileSavePath);
                        fileMap.put("files_id", lyjc.getId());
                        if (lyjcMapper.addFiles(fileMap)){
                            fileList.add(fileMap);
                        }
                    }
                    for (Lyjcmxb lyjcmxb : lyjc.getLyjcmxb()){
                        String id = "LYJC_" + System.currentTimeMillis();
                        lyjcmxb.setId(id);
                        lyjcmxb.setMid(lyjc.getId());
                        lyjcMapper.addLyjcmxb(lyjcmxb);
                    }
                    lyjcMapper.updateLyjc(lyjc);
                    return fileList;
                }else {
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public List<HashMap<String, Object>> getLyjcbmxById(String id) {
        return lyjcMapper.getLyjcbmxById(id);
    }
}
