package com.hdsx.jdwh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 返回数据结构实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Wxfy {
    private String id, djbh, wxdh, jsje, ssht, dfdw, fysm, bz, tbr, tbsj, tbdw, tbbm, spzt, tbdwdm, dfdwid;
    private String sbmc, dwmc, ssyh, zhm, yhzh;
}
