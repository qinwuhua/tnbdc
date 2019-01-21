package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * 隐蔽工程检查验收实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Ybgc {

    // id
    private String id;
    //单据编号
    private String djbh;
    //合同编号
    private String htbh;
    //工程名称
    private String htmc;
    //隐检日期
    private Date yjrq;
    //隐检项目
    private String yjxm;
    //隐检部位
    private String yjbw;
    //隐蔽工程内容
    private String ybgcnr;
    //检查结论
    private String jcjl;
    //质量问题
    private String zlwt;
    //编制单位
    private String bzdw;
    //编制日期
    private Date bzrq;
    // 子目合同信息
    private List<Ybgcmx> ybgcmxList;
}
