package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 日常清掃
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Rcqs implements Serializable{

    private static final long serialVersionUID = 3834262618582486202L;
    private String gis, ksrq, ddrq, jsrq, qsry, qsryid, qsxx, yxzt, id, dwmc, dwbh, dwid, bmmc, bmbh, bhid, tbr, tbrid, tbrq, spzt, fileid, wfid, note,lxcode,xcfx;

}
