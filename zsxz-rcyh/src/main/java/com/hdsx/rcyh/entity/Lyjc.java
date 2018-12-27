package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 履约检查字段
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Lyjc implements Serializable{

    private static final long serialVersionUID = 3834262618582486202L;

    private String id;
    private String dwmc;
    private String dwbh;
    private String dwid;
    private String bmmc;
    private String bmbh;
    private String bmid;
    private String tbr;
    private String tbrid;
    private String tbrq;
    private String spzt;
    private String wfid;
    private String htbh;
    private String jcrq;
    private String sgdw;
    private BigDecimal fjhj;
    private String gldw;
    private String jcr;
    private BigDecimal htje;
    private String bz;
    private String htmc;
    private List<Lyjcmxb> lyjcmxb;
}
