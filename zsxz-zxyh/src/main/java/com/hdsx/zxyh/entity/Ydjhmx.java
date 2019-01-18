package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 月度计划明细实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Ydjhmx {

    // id
    private String mxid;
    // 月度id
    private String ydid;
    // 起点桩号
    private String qdzh;
    // 止点桩号
    private String zdzh;
    // 结构工程
    private String jggc;
    // 方向
    private String fx;
    // 处置方式
    private String czfs;
    // 处置车道
    private String czcd;
    // 计划工程量
    private String jhgcl;
    // 计划开始日期
    private String jhksrq;
    // 计划完成日期
    private String jhwcrq;
    // 实际工程量
    private String sjgcl;
    // 实际开始日期
    private String sjksrq;
    // 实际完成日期
    private String sjwcrq;
}
