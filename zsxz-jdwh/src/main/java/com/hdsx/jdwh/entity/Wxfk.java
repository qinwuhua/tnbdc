package com.hdsx.jdwh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 返回数据结构实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Wxfk {
    private String id, djbh, jsje, ssht, dfdw, fysm, bz, tbr, tbsj, tbdw, tbbm, tbdwdm,dfdwid,sshtbh;
    private String ssyh,zhm,yhzh,htje,ljjsje,ljzfje;
    private List<Wxfkjsmx> jsmx;
    private List<Wxfkfpmx> fpmx;
}
