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
public class Wxfkjsmx {
    private String id, xh, wxfydh, bz, pdjbh,zcmc,jsje,fysm;
}
