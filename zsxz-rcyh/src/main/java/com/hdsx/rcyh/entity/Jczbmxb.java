package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Jczbmxb implements Serializable {
    private static final long serialVersionUID = -6629491145943567722L;

    private String id;
    private String mid;
    private String jcnr;
    private BigDecimal fj;
    private String memo;
    private String bh;
}