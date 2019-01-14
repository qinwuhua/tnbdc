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
public class Bgglbgsqb implements Serializable{

    private static final long serialVersionUID = 3834262618582486202L;
    private String djbh, gcmc, sbdw, htbh, zh, gldw, bgyy, bgnrjfa, bgys, bzdw, bzrq, spzt, bzdwbh;
}
