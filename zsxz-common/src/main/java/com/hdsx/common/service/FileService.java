package com.hdsx.common.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

public interface FileService {

    List<HashMap<String, Object>> uploadFiles(String id, MultipartFile[] multipartFiles, String type);

    List<HashMap<String, Object>> getFilesDataById(String id);

    boolean deleteFilesById(String id);

    List<HashMap<String, Object>> updateFiles(String id, MultipartFile[] multipartFiles, String type);
}
