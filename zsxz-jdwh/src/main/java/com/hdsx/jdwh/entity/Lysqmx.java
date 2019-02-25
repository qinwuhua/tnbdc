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
public class Lysqmx {
    private String id, xh, bjmc, bjbm, ggxh, jldw, xysl, bz,pdjbh;
}
