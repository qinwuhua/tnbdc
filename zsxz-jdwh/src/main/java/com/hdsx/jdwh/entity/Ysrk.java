package com.hdsx.jdwh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 返回数据结构实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Ysrk {
    private String id, djbh, ywqj, rklx, ckmc, wxdh, ysfs, ysr, cght, gysmc, rksm, rkjehj, bz, tbr, tbsj, tbdw, tbbm, tbdwdm,cghtbh;
    private List<Ysrkmx> mx;
}
