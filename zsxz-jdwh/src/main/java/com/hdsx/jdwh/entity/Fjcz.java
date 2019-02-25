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
public class Fjcz {
    private String id, djbh, czr, bz, tbr, tbsj, tbdw, tbbm, ckmc, czje, fyje, czsj, czsm, tbdwdm, spzt;
    private List<Fjczmx> mx;
    private List<Fjczfymx> fymx;
}
