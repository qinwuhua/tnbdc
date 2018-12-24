package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Ydsgjh implements Serializable {
    private static final long serialVersionUID = -867023259393848114L;
    private String id;
    private String dwmc;
    private String dwbh;
    private String dwId;
    private String bmmc;
    private String bmbh;
    private String bmId;
    private String tbr;
    private String tbrId;
    private Date tbrq;
    private String spzt;
    private String file;
    private String wfId;
    private String note;
    private String djbh;
    private String yf;
    private String yhdwmc;
    private String yhdwId;
    private String yhdwbh;
    private String xmfl;
    private String xmflId;

}
