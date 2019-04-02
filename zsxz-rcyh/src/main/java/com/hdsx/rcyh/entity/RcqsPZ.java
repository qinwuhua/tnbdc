package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class RcqsPZ implements Serializable {

    private static final long serialVersionUID = 2540374207765659247L;
    private String id,lxcode,xcfx,qsry, qsxx;
}
