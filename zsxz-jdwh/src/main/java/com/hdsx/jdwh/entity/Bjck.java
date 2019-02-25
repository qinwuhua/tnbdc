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
public class Bjck {
    private String id, djbh, ywqj, cklx, ckmc, sqdh, lyr, ckjehj, bz, tbr, tbsj, tbdw, tbbm, tbdwdm;
    private List<Bjckmx> mx;
}
