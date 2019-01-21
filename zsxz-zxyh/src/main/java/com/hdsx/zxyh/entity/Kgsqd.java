package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;


/**
 * 开工申请单
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Kgsqd {

    // 单据编号
    private String djbh;
    // 工程项目
    private String gcxm;
    // 合同编号
    private String htbh;
    // 承包单位
    private String cbdw;
    // 管理单位
    private String gldw;
    // 合同名称
    private String htmc;
    // 路线名称
    private String lxmc;
    // 上下行
    private String fx;
    // 起点桩号
    private String qdzh;
    // 止点桩号
    private String zdzh;
    // 爆破阻断位置
    private String bpzdwz;
    // 主线卡方向
    private String zxkfx;
    // 是否限流
    private String isxl;
    // 是否封道口
    private String isfd;
    // 现场负责人
    private String xcfzr;
    // 联系电话
    private String lxdh;
    // 施工准备情况说明
    private String sgzbqksm;
    // 审批意见
    private String spyj;
    // 填报单位
    private String tbdw;
    // 填报日期
    private Date tbrq;
    // 状态
    private String zt;

    // 工程主要内容
    private String gczynr;
    // 申请开工日期
    private Date sqkgrq;
    // 预计完工日期
    private Date yjwgrq;
}
