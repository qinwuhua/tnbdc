package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FileData implements Serializable {
    private static final long serialVersionUID = 6397720003789934154L;

    private String id;     //附件ID
    private String fileId; //文件Id
    private String name;   //附件名称
    private String depict; //附件描述
    private String path;   //附件路径
    private Date date;     //上传时间
    private String status; //状态
    private String remarks;//备注
    private String dx;     //大小
    private String yName;  //原名称
    private String type;   //类型
    private String mjlx;   //枚举类型

}
