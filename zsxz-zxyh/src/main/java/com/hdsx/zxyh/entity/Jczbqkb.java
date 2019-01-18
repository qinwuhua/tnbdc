package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 进场准备情况表实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Jczbqkb {

    // 主键id
    private String id;
    // 合同编号
    private String htbh;
    // 检查日期
    private String jcrq;
    // 检查人
    private String jcr;

    // 项目名称
    private String xmmc;
    // 施工单位
    private String sgdw;
    // 管理单位
    private String gldw;
    // 合同金额
    private String htje;
    // 罚金合计
    private String fjhj;

    // 履约检查明细
    private List<Jczbqkbmx> list;
}
