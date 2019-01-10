package com.hdsx.common.mapper;

import com.hdsx.common.entity.FileData;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface FileMapper {

     int addFileDataToFiles(List<FileData> fileDataList);

     List<FileData> getFilesDataById(String id);

     int deleteFilesByFid(String[] id);

}
