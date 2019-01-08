package com.hdsx.yjqx.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Yjqx implements Serializable {
    private static final long serialVersionUID = -4112671964798850496L;
    private String id;
    private String djbh;
    private String gcmc;
    private String qxld;
    private String fx;
    private String qdzh;
    private String zdzh;
    private String dllc;
    private String fygs;
    private String ql;
    private String sd;
    private String lxr;
    private String lxfs;
    private String gcfl;
    private String gcms;
    private String gldwbh;
    private String gldwmc;
    private String sgdwbh;
    private String sgdwmc;
    private String bzdwbh;
    private String bzdwmc;
    private String bzrq;
    private String tbrid;
    private String tbr;
    private String tbrq;
    private String htbh;
    private String spzt;
}
