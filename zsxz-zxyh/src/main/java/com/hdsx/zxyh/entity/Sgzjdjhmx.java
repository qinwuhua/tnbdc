package com.hdsx.zxyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 施工总进度的计划实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Sgzjdjhmx {
    private String id;
    private String zmmc;
    private String kssj;
    private String jssj;
    private String pdjbh;

}
