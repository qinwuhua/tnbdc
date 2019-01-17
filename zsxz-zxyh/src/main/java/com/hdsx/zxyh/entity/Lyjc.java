package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 履约检查实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Lyjc {

    // 主键id
    private String id;
    // 合同编号
    private String htbh;
    // 项目名称
    private String xmmc;
    // 施工单位
    private String sgdw;
    // 管理单位
    private String gldw;
    // 合同金额
    private String htje;
    // 合计金额
    private String hjje;
    // 检测日期
    private String jcrq;
    // 检测人
    private String jcr;
    // 履约检查明细
    private List<Lyjcmx> list;
}
