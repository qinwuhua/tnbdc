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
public class Fjrk {
    private String id, djbh, wxdh, tkr, tksm, bz, tbr, tbsj, tbdw, tbbm, ywqj, ckmc, tbdwdm;
    private List<Fjrkmx> mx;
}
