package com.hdsx.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@Accessors(chain = true)
@NoArgsConstructor
public class HtxxLyjc implements Serializable {

    private static final long serialVersionUID = 4777738084460104089L;

    private String bh;
    private String mid;
    private String jcnr;
    private BigDecimal bl;
    private String memo;
    private String fj;

}
