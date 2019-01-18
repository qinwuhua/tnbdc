package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 履约检查明细实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Lyjcmx {

    //id
    private String mxid;
    // 履约检查id
    private String lyjcid;
    // 合同履约id
    private String htlyid;
    // 合同履约名称
    private String htlynr;
    // 罚金
    private String fj;
}
