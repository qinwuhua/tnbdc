package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Yhrwd implements Serializable {

    private static final long serialVersionUID = 6077344075476254265L;
    private String yhrwddjbh;
    private String yhrwdlx;
    private String yhrwdrq;
    private String yhrwdyd;
    private String yhrwdyhdw;
    private String yhrwdgydw;
    private String yhrwdrwdshzt;
    private String yhrwdyszt;

    private List<Yhrwmx> yhrwmxes = new ArrayList<Yhrwmx>();
}
