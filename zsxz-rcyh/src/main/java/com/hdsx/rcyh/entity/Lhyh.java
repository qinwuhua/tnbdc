package com.hdsx.rcyh.entity;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 日常清掃
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Lhyh implements Serializable{

    private static final long serialVersionUID = 3834262618582486202L;
    private String gis, ksrq, jsrq, lhry, lhryid, qxxx, sbzt, id, dwmc, dwbh, dwid, bmmc, bmbh, bmid, tbr, tbrq, spzt, fileid,lxcode,xcfx;

}
