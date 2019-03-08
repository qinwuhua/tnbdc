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
public class Zmb implements Serializable{

    private static final long serialVersionUID = 3834262618582486202L;
    private String gcjlmx_id, gcjl_id, gcjlmx_mid, gcjlmx_zmh, gcjlmx_zmmc, gcjlmx_jldw, gcjlmx_jldwid, gcjlmx_htsl, gcjlmx_jlsl, gcjlmx_htdj, gcjlmx_jlje, gcjlmx_kkje, gcjlmx_zje, gcjlmx_htje, gcjlmx_djbh, gcjlmx_zmid,gcjlmx_htbh,gcjlmx_wcsl,gcjlmx_blx;

}
