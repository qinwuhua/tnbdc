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
public class Sjqs implements Serializable{


    private static final long serialVersionUID = 8382443138404406364L;
    private String gis, ksrq, ddrq, jsrq, qsry, qsryid, qsxx, yxzt, id, dwmc, dwbh, dwid, bmmc, bmbh, bhid, tbr, tbrid, tbrq, spzt, fileid, wfid, note,lxcode,xcfx;

}
