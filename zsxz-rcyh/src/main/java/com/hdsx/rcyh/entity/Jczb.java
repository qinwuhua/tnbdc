package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Jczb implements Serializable {
    private static final long serialVersionUID = -6575182104354129775L;

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
    private String xmmc;
    private String gldw;
    private BigDecimal htje;
    private String bz;
    private String htmc;
    private BigDecimal wyfj;
    private String jcr;
    private List<Jczbmxb> jczbmxb;
}
