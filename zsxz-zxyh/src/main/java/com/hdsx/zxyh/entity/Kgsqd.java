package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/**
 * 开工申请单
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Kgsqd {

    // 单据编号
    private String djbh;
    // 合同编号
    private String htbh;
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
    private String tbrq;
    // 养护项目信息
    private Yhxmxx yhxmxx;
    // 状态
    private String zt;
}
