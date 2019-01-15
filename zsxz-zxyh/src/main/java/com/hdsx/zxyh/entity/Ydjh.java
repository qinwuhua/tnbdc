package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 月度计划实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Ydjh {

    // id
    private String id;
    // 单据编号
    private String djbh;
    // 本月计划完成情况
    private String byjhwcqk;
    // 下月计划完成情况
    private String xyjhwcqk;
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

}
