package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 计量支付
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Jlzf_jrgsp implements Serializable{

    private static final long serialVersionUID = 3834262618582486202L;
    private String jrgsp_htbh,jrgsp_id, jrgsp_dwmc, jrgsp_dwbh, jrgsp_dwid, jrgsp_bmmc, jrgsp_bmbh, jrgsp_bmid, jrgsp_tbr, jrgsp_tbrid, jrgsp_tbrq, jrgsp_spzt, jrgsp_file, jrgsp_wfid, jrgsp_note, jrgsp_djbh, jrgsp_xmmc, jrgsp_xmbh, jrgsp_xmid, jrgsp_cbdwmc, jrgsp_cbdwid, jrgsp_cbdwbh, jrgsp_hjje, jrgsp_gcmc;
    List<Jlzf_jrgspmx> jlzf_jrgspmx;
}
