package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Qsrwd implements Serializable {


    private static final long serialVersionUID = 8553655881572466117L;
    private String qsrwdid;
    private String qsrwddjbh;
    private String qsrwdxxly;
    private String qsrwdsjlx;
    private String qsrwdsjsj;
    private String qsrwdsjdd;
    private String qsrwdsjld;
    private String qsrwdfx;
    private String qsrwdzh;
    private String qsrwdlxr;
    private String qsrwdlxdh;
    private String qsrwdlmjbsy;
    private String qsrwdlxjbsy;//“路面结冰撒盐”，PDM中的字段为上面那个，但是数据库是现在这个
    private String qsrwdsjsm;
    private String qsrwdtbr;
    private String qsrwdtbsj;
    private String qsrwdtbdw;
    private String qsrwdtbbm;
    private String qsrwdbz;
    private String qsrwdshzt;

    private String bhid;//清扫单对应的病害/事件/巡查上报ID：用于添加“清扫任务单”的时候查询病害信息用于添加
    private String qsrwdqszt;//清扫单的清扫状态字段：关联枚举表

}
