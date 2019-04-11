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
public class Kcgl {
    private String sbmc,sbbm,ggxh,jldw,kcsl,ssck,ssdw;
    private String dcck,drck,dbsl,id;
}
