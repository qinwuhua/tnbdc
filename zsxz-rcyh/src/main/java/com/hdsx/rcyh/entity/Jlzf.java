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
public class Jlzf implements Serializable{

    private static final long serialVersionUID = 3834262618582486202L;
    private String pmmtgcspsqs_id, pmmtgcspsqs_dwmc, pmmtgcspsqs_dwbh, pmmtgcspsqs_dwid, pmmtgcspsqs_bmmc, pmmtgcspsqs_bmbh, pmmtgcspsqs_bmid, pmmtgcspsqs_tbr, pmmtgcspsqs_tbrq, pmmtgcspsqs_spzt, pmmtgcspsqs_file, pmmtgcspsqs_djbh, pmmtgcspsqs_cjrq, pmmtgcspsqs_gcmc, pmmtgcspsqs_htbh, pmmtgcspsqs_sqje, pmmtgcspsqs_spsj, pmmtgcspsqs_scyjs, pmmtgcspsqs_spyjs, pmmtgcspsqs_spje, pmmtgcspsqs_cjdw, pmmtgcspsqs_gldw, pmmtgcspsqs_sqrq, pmmtgcspsqs_cbdw, pmmtgcspsqs_spsjjs;
    private String gcjl_dwmc, gcjl_dwbh, gcjl_id, gcjl_dwid, gcjl_bmmc, gcjl_bmbh, gcjl_bmid, gcjl_tbr, gcjl_tbrid, gcjl_tbrq, gcjl_spzt, gcjl_file, gcjl_wfid, gcjl_note, gcjl_djbh, gcjl_code, gcjl_xmmc, gcjl_xmid, gcjl_xmbh, gcjl_htmc, gcjl_htid, gcjl_htbh, gcjl_cjdwmc, gcjl_cjdwbh, gcjl_cjdwid, gcjl_rq, gcjl_bw, gcjl_th, gcjl_zjdbh, gcjl_jtsm, gcjl_flag, gcjl_sfybgc, gcjl_ybgcdh, gcjl_gcmc, gcjl_sqrq, gcjl_yd, gcjl_cbdw, gcjl_qdzh, gcjl_zdzh, gcjl_sl;
    List<Zmb> zmbs;
}
