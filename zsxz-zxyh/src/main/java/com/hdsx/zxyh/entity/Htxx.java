package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 合同信息
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Htxx {
    // 主键id
    private String id;
    // 合同编号
    private String htbh;
    // 合同名称
    private String htmc;
    // 项目施工路线
    private String xmsglx;
    // 项目管理单位
    private String xmgldw;
    // 合同金额
    private String htjehs;
}
