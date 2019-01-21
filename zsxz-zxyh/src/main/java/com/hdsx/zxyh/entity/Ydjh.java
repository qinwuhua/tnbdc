package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

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
    //月度
    private String yd;
    // 本月计划完成情况
    private String byjhwcqk;
    // 下月计划完成情况
    private String xyjhwcqk;
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
    // 合同信息
    private Htgjxx htgjxx;
    // 月度计划明细
    private List<Ydjhmx> ydjhmxList;
    // 上报状态
    private String sbzt;
    // 批复状态
    private String pfzt;

}
