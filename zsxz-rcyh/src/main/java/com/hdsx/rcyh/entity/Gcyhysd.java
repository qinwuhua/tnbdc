package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Gcyhysd implements Serializable {

    private static final long serialVersionUID = 3689792312573100249L;

    private String id;
    private String sqbh;
    private String sqrq;
    private String djbh;
    private String htbh;
    private String htmc;
    private BigDecimal htje;
    private String ysrq;
    private String sgdw;
    private String gldw;
    private String cjysry;
    private String gcnr;
    private String sgfyj;
    private String jldwyj;
    private String yzysxzyj;
    private String gcjsbyj;
    private String yslx;
    private String jyfzbyj;
    private String tbrid;
    private String tbr;
    private String tbrq;
    private String tbbm;
    private String tbdw;
    private String spzt;
}
