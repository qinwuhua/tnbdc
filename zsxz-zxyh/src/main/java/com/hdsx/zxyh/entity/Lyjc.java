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
    // 检测日期
    private String jcrq;
    // 检测人
    private String jcr;
    // 合同信息
    private Htxx htxx;
    // 履约检查明细
    private List<Lyjcmx> list;
}
