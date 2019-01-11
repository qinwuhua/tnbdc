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
public class Gcysjung implements Serializable{

    private static final long serialVersionUID = 3834262618582486202L;
    private String jssbh, gcmc, htbh, cbdw, jldw, gldw, htje, jiesje, zbj, zlqxkk, juesje, wcht, jshzf, gcnr, ysyj, remark, bzdw, bzdwbh, bzrq, spzt;
    List<Gcysjungmx> mx;
}
