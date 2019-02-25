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
public class Rcxj {
    private String id, xjlx, xjzq, jcsj, xjr, xjms, bz, tbr, tbsj, tbdw, tbbm, tbdwdm;
    private List<Rcxjmx> mx;
}
