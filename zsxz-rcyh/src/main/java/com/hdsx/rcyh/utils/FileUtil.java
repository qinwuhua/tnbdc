package com.hdsx.rcyh.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.UUID;

public class FileUtil {

    /**
     * 获取文件扩展名（文件类型）
     * @param name
     * @return
     */
    private static String getFileExtension(String name) {
        return name.substring(name.lastIndexOf("."));
    }

    /**
     *
     * @param file
     * @param path 文件路径
     * @return
     */
    public static HashMap<String,String> transferTo(MultipartFile file, String path) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        HashMap<String,String> urlMap = new HashMap<>();
        String fileName = file.getOriginalFilename();
        /*String name = file.getName();*/
        //文件重命名
        String newFileName= "hdsx"+ System.currentTimeMillis() + "_" + fileName;
        /*int size = (int) file.getSize();*/
        /*System.out.println(fileName + "-->" + size);*/
        //获得文件夹
        /*SimpleDateFormat nyr = new SimpleDateFormat("yyyyMMdd");
        String nyrdate = nyr.format(new Date());
        File dest = new File(path +"/" +nyrdate+"/"+ newFileName);

        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdirs();
        }*/
        File dest = new File(path + newFileName);
        DecimalFormat df = new DecimalFormat("#.00");
        try {
            file.transferTo(dest); //保存文件
            urlMap.put("files_yname",fileName);
            urlMap.put("files_type","."+fileName.substring(fileName.lastIndexOf(".") + 1));
            urlMap.put("files_name",newFileName);
            urlMap.put("files_path",path + file.getOriginalFilename());
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

/*    public void delUrlFiles(String files_path) {
        File file = new File(replace(files_path, imageConfigUrl, fileUploadPath + "//"));
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            boolean r = file.delete();

        }
    }*/
}
