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
public class Fjwx {
    private String id, djbh, wxfs, yjje, czsm, bz, tbr, tbsj, tbdw, tbbm, wxcs, ckmc,tbdwdm;
    private List<Fjwxmx> mx;
}
