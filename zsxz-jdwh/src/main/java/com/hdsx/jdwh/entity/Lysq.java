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
public class Lysq {
    private String id, djbh, wxdh, xyr, lysm, bz, tbr, tbsj, tbdw, tbbm, tbdwdm;
    private List<Lysqmx> mx;
}
