package com.hdsx.rcyh.service.impl;

import com.hdsx.rcyh.entity.Lyjc;
import com.hdsx.rcyh.mapper.LyjcMapper;
import com.hdsx.rcyh.service.LyjcService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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
    public boolean addLyjc(Lyjc lyjc) {
        if (lyjc.getMultipartFiles() != null && lyjc.getMultipartFiles().size() > 0){
            File fileFold = new File(fileSavePath);
            if (!fileFold.exists()){
                fileFold.mkdirs();
            }
            for (int i = 0; i < lyjc.getMultipartFiles().size(); i++){
                MultipartFile file = lyjc.getMultipartFiles().get(i);
                saveFile(file);
                //TODO 把保存的信息存入到FILES表中
                /*lyjcMapper.addFiles();*/
            }
            //TODO 文件保存后就把信息添加到SGDWLYLCB
            /*lyjcMapper.addLyjc(lyjc);*/
            System.out.println("把信息添加到SGDWLYLCB");
        }else {
            return false;
        }
        return false;
    }

    private boolean saveFile(MultipartFile file) {
        if (!file.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File filePath = new File(fileSavePath + fileName);
            try {
                file.transferTo(filePath);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
