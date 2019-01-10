package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 工程支付-工程计量单
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Gczfgcjld {

    private String gcjl_dwmc, gcjl_dwbh, gcjl_id, gcjl_dwid, gcjl_bmmc, gcjl_bmbh, gcjl_bmid, gcjl_tbr, gcjl_tbrid, gcjl_tbrq, gcjl_spzt, gcjl_file, gcjl_wfid, gcjl_note, gcjl_djbh, gcjl_code, gcjl_xmmc, gcjl_xmid, gcjl_xmbh, gcjl_htmc, gcjl_htid, gcjl_htbh, gcjl_cjdwmc, gcjl_cjdwbh, gcjl_cjdwid, gcjl_rq, gcjl_zmh, gcjl_zmmc, gcjl_qzzh, gcjl_bw, gcjl_th, gcjl_zjdbh, gcjl_jtsm, gcjl_flag, gcjl_sfybgc, gcjl_ybgcdh, gcjl_gcmc, gcjl_sqrq, gcjl_yd, gcjl_cbdw, gcjl_qdzh, gcjl_zdzh, gcjl_sl;
    private List<Gczfgcjldmx> mx;

}
