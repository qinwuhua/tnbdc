package com.hdsx.jdwh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 返回数据结构实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Wxys {
    private String id, djbh, bxdh, wxrq, xcwxr, gzms, xcqkms, wxjgms, wxjgqr, qrr, qrsj, bz, tbr, tbsj, tbdw, tbbm, tbdwdm;
    private String sbmc,ggxh,bzrq,bgr,spzt,sgfyj,fzr,txqrr;
}
