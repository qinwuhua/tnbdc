package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 隐蔽工程检查验明细实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Ybgcmx {

    // id
    private String id;
    // 隐蔽id
    private String ybid;
    // 子目号
    private String zmh;
    // 子目名称
    private String zmmc;
    // 单位
    private String dw;
    // 数量
    private String sl;
}
