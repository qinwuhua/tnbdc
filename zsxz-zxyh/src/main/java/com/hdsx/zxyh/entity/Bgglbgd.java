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
public class Bgglbgd implements Serializable{

    private static final long serialVersionUID = 3834262618582486202L;
    private String djbh, gcmc, sqrq, bw, htbh, gldw, qdzh, zdzh, sqbbh, bglbh, bgly, bgnr, gjzjje, cbdw, cbdwbh, bzrq, spzt;
    private List<Bgglbgdmx> mx;
}
