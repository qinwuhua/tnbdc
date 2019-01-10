package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 计量支付
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Gcyssqd implements Serializable{

    private static final long serialVersionUID = 3834262618582486202L;
    private String sqbh, xmmc, sqsj, htbh, sgdw, gldw, htksgq, htjsgq, yslx, sgfyj, jldwyj, gcjsbyj, jyfzbyj, tbr, tbrq, tbdw, tbbm, tbdwbm, tbbmbm;
}
