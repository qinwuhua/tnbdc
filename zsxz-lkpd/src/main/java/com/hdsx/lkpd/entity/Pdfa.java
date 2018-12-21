package com.hdsx.lkpd.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 路况调查分表
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Pdfa implements Serializable {

    private static final long serialVersionUID = 592104952218466972L;

    private Integer djbh;		//单据编号
    private String famc;		//方案名称
    private String sjsjxx;		//数据时间下限
    private String sjsjsx;		//数据时间上限
    private String tbdw;		//数据时间上限
    private String tbbm;		//数据时间上限
    private String tbsj;		//数据时间上限
    private String tbr;		//数据时间上限
    private String remark;		//备注

}
