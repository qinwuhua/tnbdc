package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class SjqsPZ implements Serializable {

    private static final long serialVersionUID = -7760326177097707755L;
    private String id,lxcode,xcfx,qsry, qsxx;
}
