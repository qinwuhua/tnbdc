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
public class Lkdcfb implements Serializable {

    private static final long serialVersionUID = 592104952218466972L;

    private String fbid;		//调查附表id
    private String dcid;		//调查主表id
    private String lxid;		//调查类型
    private double ljsj;		//累计数据

}
