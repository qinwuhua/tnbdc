package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Rcyhxckhb {
    private String rcyhxckhbdjbh;
    private String rcyhxckhbyd;
    private String rcyhxckhbgcmc;
    private String rcyhxckhbsgdw;
    private String rcyhxckhbgldw;
    private String rcyhxckhbkhrq;
    private String rcyhxckhbbykkhj;

    private List<Rcyhxckhbmx> rcyhxckhbmxes = new ArrayList<Rcyhxckhbmx>();
}
