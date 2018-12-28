package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Lhyhpfb {
    private String lhyhdjbh;
    private String lhyhyd;
    private String lhyhgcmc;
    private String lhyhsgdw;
    private String lhyhgldw;
    private String lhyhkhrq;
    private String lhyhfzzj;

    List<Lhyhpfbmx> lhyhpfbmxes = new ArrayList<>();
}
