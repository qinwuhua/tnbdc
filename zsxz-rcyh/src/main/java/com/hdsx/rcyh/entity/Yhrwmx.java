package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Yhrwmx implements Serializable {


    private static final long serialVersionUID = 8172831216082472719L;
    private String yhrwdid;
    private String yhrwddjbh;
    private String yhrwdsjbh;
    private String yhrwdxcdw;
    private String yhrwdcd;
    private String yhrwdxcfx;
    private String yhrwddwgc;
    private String yhrwdbhlx;
    private String yhrwdbhsl;
    private String yhrwdgcllx;
    private String yhrwdzh;
    private String yhrwdbhsm;
    private Date yhrwdsj;
}
