package com.hdsx.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Zmht implements Serializable {
    private String id;
    private String htbh;
    private String htmc;
    private String zmh;
    private String zmmc;
    private String jldw;
    private String sl;
    private String dj;
    private String je;
}
