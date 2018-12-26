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
public class Jgjs implements Serializable{

    private static final long serialVersionUID = 3834262618582486202L;
    private String pmmtjgjss_id, pmmtjgjss_dwmc, pmmtjgjss_dwbh, pmmtjgjss_dwid, pmmtjgjss_bmmc, pmmtjgjss_bmbh, pmmtjgjss_bmid, pmmtjgjss_tbr, pmmtjgjss_spzt, pmmtjgjss_file, pmmtjgjss_djbh, pmmtjgjss_bzrq, pmmtjgjss_gcmc, pmmtjgjss_htbh, pmmtjgjss_cbdw, pmmtjgjss_gldw, pmmtjgjss_jldw, pmmtjgjss_htje, pmmtjgjss_bz, pmmtjgjss_gzjhtje, pmmtjgjss_gzjjlje, pmmtjgjss_gzjjsje, pmmtjgjss_htzdje, pmmtjgjss_jlzdje, pmmtjgjss_jgjszdje, pmmtjgjss_spfy, pmmtjgjss_fj, pmmtjgjss_zlbzj, pmmtjgjss_ljzfgck, pmmtjgjss_yzfkk, pmmtjgjss_yzfkkdx, pmmtjgjss_jssbh;
    List<Jgjsmx> zmbs;
}
