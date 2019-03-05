package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 工程现场质量检查实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Gcxczljc {

    // id
    private String id;
    // 单据编号
    private String djbh;
    // 检查日期
    private Date jcrq;
    // 工程名称
    private String gcmc;
    // 合同编号
    private String htbh;
    // 检查形式
    private String jcxs;
    // 工程部位
    private String gcbw;
    // 管理单位
    private String gldw;
    // 承包单位
    private String cbdw;
    // 工程内容
    private String gcnr;
    // 现场检查情况
    private String xcjcqk;
    // 是否整改
    private String iszg;
    // 整改意见
    private String zgyj;
    // 整改情况
    private String zgqk;
    // 复查
    private String fc;
    // 编制单位
    private String bzdw;
    // 编制日期
    private Date bzrq;

    private String spzt;
}
