package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 施工总进度的计划实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Sgzjdjh {
    // 主键
    private String id;
    // 备注
    private String bz;
    // 编制人
    private String bzr;
    // 编制日期
    private String bzrq;
    // 编制单位
    private String bzdw;
    // 编制部门
    private String bzbm;
    // 单据编号
    private String djbh;
    // 合同信息
    private Htxx htxx;
    // 合同关键信息
    private Htgjxx htgjxx;
}
