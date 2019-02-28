package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Sgjhsbmx implements Serializable {
    private static final long serialVersionUID = -872388034305483382L;
    private String id;
    private String mid;
    private String xmnr;
    private String qdzh;
    private String zdzh;
    private BigDecimal yjgcl;
    private String jhksrq;
    private String jhjsrq;
    private String bz;
    private String zmh;
}
