package com.hdsx.rcyh.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 日常养护 - 小修任务返回值
 * @author LiRui
 * @created 2019/2/21 0021
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class RcyhXxrwResultBean<T> {

    private Integer totle;
    private T rows;

}
