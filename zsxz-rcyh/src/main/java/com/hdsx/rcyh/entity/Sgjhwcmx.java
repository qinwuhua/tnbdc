package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Sgjhwcmx implements Serializable {

    private static final long serialVersionUID = 7447671500142419910L;

    private String id;
    private String mid;
    private String xmnr;
    private String qdzh;
    private String zdzh;
    private BigDecimal yjgcl;
    private BigDecimal wcgcl;
    private Date jhkgrq;
    private Date jhjsrq;
    private Date sjksrq;
    private Date sjjsrq;
    private String bz;
}
