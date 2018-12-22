package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.Jczb;
import com.hdsx.rcyh.entity.Jczbmxb;
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
    public List<HashMap<String, Object>> getLyjcAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = lyjcMapper.getLyjcAll();
        return list;
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
            if (lyjc.getLyjcmxb() != null && lyjc.getLyjcmxb().size() > 0){
                for (Lyjcmxb lyjcmxb : lyjc.getLyjcmxb()){
                    String id = "LYJC_" + System.currentTimeMillis();
                    lyjcmxb.setId(id);
                    lyjcmxb.setMid(uuid);
                    lyjcMapper.addLyjcmxb(lyjcmxb);
                }
            }
            return fileList;
        }else {
            return null;
        }
    }

    @Override
    public boolean deleteLyjc(String id) {
        List<HashMap<String, String>> fileUrl = lyjcMapper.getFilesDataById(id);
        for (int i = 0; i < fileUrl.size(); i++){
            File file = new File(fileSavePath + fileUrl.get(i).get("FILES_NAME"));
            if (file.isFile() && file.exists()) {
                file.delete();
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
        List<HashMap<String, String>> fileList = new ArrayList<>();
        List<HashMap<String, String>> fileUrl = lyjcMapper.getFilesDataById(lyjc.getId());
        if (lyjc.getMultipartFiles() != null && lyjc.getMultipartFiles().size() > 0) {
            for (int i = 0; i < fileUrl.size(); i++){
                File file = new File(fileSavePath + fileUrl.get(i).get("FILES_NAME"));
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            }
            if (lyjcMapper.deleteFilesDataById(lyjc.getId())){
                if (lyjcMapper.deleteLyjcmxbById(lyjc.getId())){
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
                        }else {
                            return null;
                        }
                    }
                }else{
                    return null;
                }
            }else {
                return null;
            }
        }else {
            fileList = fileUrl;
        }
        if (lyjc.getLyjcmxb()!=null && lyjc.getLyjcmxb().size() > 0){
            for (Lyjcmxb lyjcmxb : lyjc.getLyjcmxb()){
                String id = "LYJC_" + System.currentTimeMillis();
                lyjcmxb.setId(id);
                lyjcmxb.setMid(lyjc.getId());
                lyjcMapper.addLyjcmxb(lyjcmxb);
            }
        }
        lyjcMapper.updateLyjc(lyjc);
        return fileList;
    }

    @Override
    public List<HashMap<String, Object>> getLyjcbmxById(String id) {
        return lyjcMapper.getLyjcbmxById(id);
    }

    @Override
    public List<HashMap<String, Object>> getJczbAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = lyjcMapper.getJczbAll();
        return list;
    }

    @Override
    public List<HashMap<String, String>> addJczb(Jczb jczb) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        List<HashMap<String, String>> fileList = new ArrayList<>();
        if (jczb.getMultipartFiles() != null && jczb.getMultipartFiles().size() > 0){
            File fileFold = new File(fileSavePath);
            if (!fileFold.exists()){
                fileFold.mkdirs();
            }
            for (int i = 0; i < jczb.getMultipartFiles().size(); i++){
                MultipartFile file = jczb.getMultipartFiles().get(i);
                HashMap<String, String> fileMap = FileUtil.transferTo(file,fileSavePath);
                fileMap.put("files_id", uuid);
                if (lyjcMapper.addFiles(fileMap)){
                    fileList.add(fileMap);
                }
            }
            jczb.setId(uuid);
            lyjcMapper.addJczb(jczb);
            if (jczb.getJczbmxb() != null && jczb.getJczbmxb().size() > 0){
                for (Jczbmxb jczbmxb : jczb.getJczbmxb()){
                    String id = "JCZB_" + System.currentTimeMillis();
                    jczbmxb.setId(id);
                    jczbmxb.setMid(uuid);
                    lyjcMapper.addJczbmxb(jczbmxb);
                }
            }
            return fileList;
        }else {
            return null;
        }
    }

    @Override
    public boolean deleteJczb(String id) {
        List<HashMap<String, String>> fileUrl = lyjcMapper.getFilesDataById(id);
        for (int i = 0; i < fileUrl.size(); i++){
            File file = new File(fileSavePath + fileUrl.get(i).get("FILES_NAME"));
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
        if (lyjcMapper.deleteFilesDataById(id)){
            if (lyjcMapper.deleteJczbmxbById(id)){
                if (lyjcMapper.deleteJczbById(id)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<HashMap<String, String>> updateJczb(Jczb jczb) {
        List<HashMap<String, String>> fileList = new ArrayList<>();
        List<HashMap<String, String>> fileUrl = lyjcMapper.getFilesDataById(jczb.getId());
        if (jczb.getMultipartFiles() != null && jczb.getMultipartFiles().size() > 0) {
            for (int i = 0; i < fileUrl.size(); i++){
                File file = new File(fileSavePath + fileUrl.get(i).get("FILES_NAME"));
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            }
            if (lyjcMapper.deleteFilesDataById(jczb.getId())){
                if (lyjcMapper.deleteJczbmxbById(jczb.getId())){
                    File fileFold = new File(fileSavePath);
                    if (!fileFold.exists()){
                        fileFold.mkdirs();
                    }
                    for (int i = 0; i < jczb.getMultipartFiles().size(); i++){
                        MultipartFile file = jczb.getMultipartFiles().get(i);
                        HashMap<String, String> fileMap = FileUtil.transferTo(file,fileSavePath);
                        fileMap.put("files_id", jczb.getId());
                        if (lyjcMapper.addFiles(fileMap)){
                            fileList.add(fileMap);
                        }else {
                            return null;
                        }
                    }
                }else{
                    return null;
                }
            }else {
                return null;
            }
        }else {
            fileList = fileUrl;
        }
        if (jczb.getJczbmxb()!=null && jczb.getJczbmxb().size() > 0){
            for (Jczbmxb jczbmxb : jczb.getJczbmxb()){
                String id = "JCZB" + System.currentTimeMillis();
                jczbmxb.setId(id);
                jczbmxb.setMid(jczb.getId());
                lyjcMapper.addJczbmxb(jczbmxb);
            }
        }
        lyjcMapper.updateJczb(jczb);
        return fileList;
    }

    @Override
    public List<HashMap<String, Object>> getJczbmxById(String id) {
        return lyjcMapper.getJczbmxById(id);
    }

    @Override
    public List<HashMap<String,String>> getFilesDataById(String id){
        return lyjcMapper.getFilesDataById(id);
    }

}
