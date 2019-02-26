package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 日常养护 - 事件登记 - Bean
 * @author LiRui
 * @created 2019/2/26 0026
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class RcyhSjdj implements Serializable {

    private String id;
    private String mid;
    private String dwmc;
    private String dwbh;
    private String dwid;
    private String bmmc;
    private String bmbh;
    private String bmid;
    private String tbr;
    private String tbrid;
    private String tbrq;
    private String note;
    private String sjdh;
    private String gps;
    private String sjlx;
    private String sjsm;
    private String jjd;
    private String tp;
    private String sp;
    private String zh;
    private String fxsj;
    private String shlx;
    private String bhlx;
    private int bhsl;
    private String khnr;
    private String cd;
    private String czfs;
    private String xcfx;
    private String bhsm;
    private String gcllx;
    private String dwgc;
    private String xxly;
    private String lxr;
    private String lxdh;
    private String sjdd;
    private String sjld;
    private String cph;
    private String cllx;
    private String zmh;
    private String zmmc;

}
