package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 施工总进度的计划实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Sgzjdjh {
    // id
    private String id;
    // 单据编号
    private String djbh;
    // 工程名称
    private String gcmc;
    // 合同名称
    private String htmc;
    // 管理单位
    private String gldw;
    // 合同开工日期
    private Date htkgrq;
    // 合同竣工日期
    private Date htjgrq;
    // 计划工期
    private String jhgq;
    // 承包单位
    private String cbdw;
    // 备注
    private String bz;
    // 编制人
    private String bzr;
    // 编制日期
    private Date bzrq;
    // 编制单位
    private String bzdw;
    // 编制部门
    private String bzbm;
}
