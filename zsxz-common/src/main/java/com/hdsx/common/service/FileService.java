package com.hdsx.common.service;

import com.hdsx.common.entity.FileData;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

public interface FileService {

    HashMap<String, Object> uploadFiles(MultipartFile file);

    List<HashMap<String, Object>> getFilesDataById(String id);

    int deleteFilesById(String id);

    int addFileDataToFiles(List<FileData> fileDataList);

    int updateFileDataToFiles(List<FileData> fileDataList);
}
