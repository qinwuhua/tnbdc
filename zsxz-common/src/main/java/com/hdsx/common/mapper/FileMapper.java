package com.hdsx.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface FileMapper {

     boolean addFiles(HashMap<String, Object> fileMap);

     List<HashMap<String, Object>> getFilesDataById(String id);

     boolean deleteFilesDataById(String id);
}
