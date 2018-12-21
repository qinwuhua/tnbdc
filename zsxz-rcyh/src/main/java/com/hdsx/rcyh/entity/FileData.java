package com.hdsx.rcyh.entity;

import java.io.Serializable;
import java.util.Date;

public class FileData implements Serializable {

    private String id;     //附件ID
    private String name;   //附件名称
    private String depict; //附件描述
    private String path;   //附件路径
    private Date date;     //上传时间
    private String status; //状态
    private String remarks;//备注
    private String dx;     //大小
    private String yname;  //原名称
    private String type;   //类型
    private String mjlx;   //枚举类型

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDx() {
        return dx;
    }

    public void setDx(String dx) {
        this.dx = dx;
    }

    public String getYname() {
        return yname;
    }

    public void setYname(String yname) {
        this.yname = yname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMjlx() {
        return mjlx;
    }

    public void setMjlx(String mjlx) {
        this.mjlx = mjlx;
    }
}
