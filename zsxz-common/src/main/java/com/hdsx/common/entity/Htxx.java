package com.hdsx.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Htxx implements Serializable {

    private String id;
    private String htbh;
    private String htmc;
    private String xmsglx;
    private String xmgldw;
    private String htjehs;

    private String gj_htbh;
    private String gj_htmc;
    private BigDecimal gj_htje;
    private String gj_htxdf;
    private String gj_lb;
    private String gj_xlb;
    private Date gj_qdrq;
    private String gj_lxbh;
    private String gj_cgxmmc;
    private String gj_khh;
    private String gj_yhzh;
    private String gj_zlbzjbl;
    private String gj_fwxt;
    private String gj_bz;
    private String gj_fj;
    private String gj_tbr;
    private Date gj_lrsj;
    private String gj_tbdw;
    private String gj_tbbm;
    private String gj_jbr;
    private Date gj_qcrq;
    private String gj_jbdw;
    private String gj_jbbm;

    private String yh_htbh;
    private String yh_htmc;
    private String yh_lxmc;
    private String yh_cd;
    private String yh_qszh;
    private String yh_zzzh;
    private String yh_dwgc;
    private String yh_gcgl;
    private Date yh_htkgrq;
    private Date yh_htwgrq;
    private String yh_htgq;
    private Date yh_sjkgrq;
    private Date yh_sjwgrq;
    private String yh_zgspdw;
    private String yh_wh;
    private Date yh_sprq;
    private String yh_lljdbm;
    private String yh_sglx;
    private String yh_gldw;
    private String yh_cbdw;
    private String yh_jldw;
    private String yh_xmlxr;
    private String yh_lxdh;
    private String yh_xmjs;

    private List<HtxxLyjc> lyjcs;
    private List<Zmht> zmhts;

}
