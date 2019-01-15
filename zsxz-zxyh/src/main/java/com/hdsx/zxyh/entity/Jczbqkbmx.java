package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 进场准备情况明细表实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Jczbqkbmx {

    // mxid
    private String mxid;
    // 进场id
    private String jcid;
    // 合同履约id
    private String htlyid;
    // 合同履约内容
    private String htlynr;
    // 罚金
    private String fj;
}
