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
    private Date qsrwdsjsj;
    private String qsrwdsjdd;
    private String qsrwdsjld;
    private String qsrwdfx;
    private String qsrwdzh;
    private String qsrwdlxr;
    private String qsrwdlxdh;
    private String qsrwdlmjbsy;
    private String qsrwdsjsm;
    private String qsrwdstbr;
    private Date qsrwdtbsj;
    private String qsrwdtbdw;
    private String qsrwdtbbm;
    private String qsrwdbz;
    private String qsrwdshzt;
}
