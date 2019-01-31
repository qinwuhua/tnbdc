package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * 月度完成实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Ydwc {
    // id
    private String id;
    // 单据编号
    private String djbh;
    // 月度
    private String yd;
    // 工程名称
    private String gcmc;
    // 合同编号
    private String htbh;
    // 管理单位
    private String gldw;
    // 承包单位
    private String cbdw;
    // 本月计划完成情况
    private String byjhwcqk;
    // 下月主要工作计划
    private String xyzygzjh;
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
    // 月度计划明细
    private List<Ydwcmx> list;
    // 状态
    private String zt;
}
