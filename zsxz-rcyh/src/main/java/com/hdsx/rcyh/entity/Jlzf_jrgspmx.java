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
public class Jlzf_jrgspmx implements Serializable{

    private static final long serialVersionUID = 3834262618582486202L;
    private String jrgmx_id, jrgmx_mid, jrgmx_xmh, jrgmx_xmmc, jrgmx_jldw, jrgmx_sl, jrgmx_dj, jrgmx_je, jrgmx_yt, jrgmx_rq, jrgmx_djbh;
}
