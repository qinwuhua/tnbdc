package com.hdsx.rcyh.entity;

import org.springframework.web.multipart.MultipartFile;

public class Test {

    private String id;
    private MultipartFile[] files;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
