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
public class Rcxjmx {
    private String mx_id, mx_xh, mx_jcx, mx_jcjg, mx_bz, mx_pid,jclx;
}
