package com.hdsx.rcyh.entity;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class LhyhPZ implements Serializable {

    private static final long serialVersionUID = 1669430306929781657L;
    private String id,lxcode,xcfx,lhry, qxxx;
}
