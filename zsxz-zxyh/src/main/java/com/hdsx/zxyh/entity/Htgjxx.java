package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 合同关键信息
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Htgjxx {

    // 合同编号
    private String htbh;
    // 合同名称
    private String htmc;
    // 合同金额
    private String htje;
    // 合同
    private String htxdf;
    // lb
    private String lb;
    // xlb
    private String xlb;
    // qdrq
    private Date qdrq;
    private String lxbh;
    private String cgxmmc;
    private String khh;
    private String yhzh;
    private String zlbzjbl;
    private String fwxt;
    private String bz;
    private String fj;
    private String tbr;
    private Date lrsj;
    private String tbdw;
    private String tbbm;
    private String jbr;
    private Date qcrq;
    private String jbdw;
    private String jbbm;
}
