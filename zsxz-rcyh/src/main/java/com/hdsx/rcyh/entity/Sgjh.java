package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Sgjh implements Serializable {
    private static final long serialVersionUID = -867023259393848114L;
    private String id;
    private String dwmc;
    private String dwbh;
    private String dwid;
    private String bmmc;
    private String bmbh;
    private String bmid;
    private String tbr;
    private String tbrid;
    private Date tbrq;
    private String spzt;
    private String file;
    private String wfid;
    private String note;
    private String djbh;
    private Date yf;
    private String yhdwmc;
    private String yhdwid;
    private String yhdwbh;
    private String xmfl;
    private String xmflid;
    private String bz;
    private String htmc;
    private String tbdw;
    private String tbbm;
    private String gldw;
    private String htid;
    private String htbh;
    private List<Sgjhsbmx> sgjhsbmx;
}
