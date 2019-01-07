package com.hdsx.zxyh.entity;

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
public class Gczfzqcwzf implements Serializable{

    private static final long serialVersionUID = 3834262618582486202L;
    private String zqcwzf_gcmc,zqcwzf_cbdw,zqcwzf_id, zqcwzf_dwmc, zqcwzf_dwbh, zqcwzf_dwid, zqcwzf_bmmc, zqcwzf_bmbh, zqcwzf_bmid, zqcwzf_tbr, zqcwzf_tbrid, zqcwzf_tbrq, zqcwzf_spzt, zqcwzf_fille, zqcwzf_wfid, zqcwzf_note, zqcwzf_djbh, zqcwzf_zfqh, zqcwzf_xmmc, zqcwzf_xmid, zqcwzf_xmbh, zqcwzf_htmc, zqcwzf_htid, zqcwzf_htbh, zqcwzf_cjdwmc, zqcwzf_cjdwid, zqcwzf_cjdwbh, zqcwzf_jzrq, zqcwzf_flag, zqcwzf_gldw, zqcwzf_jldw;
    List<Gczfzqcwzfmx> mx;
}
