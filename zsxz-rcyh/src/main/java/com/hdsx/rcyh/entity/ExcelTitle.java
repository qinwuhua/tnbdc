package com.hdsx.rcyh.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ExcelTitle implements Serializable {

    private static final long serialVersionUID = -6939452716097926868L;

    private String name;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
}
