package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 养护任务验收单 - 任务单关联表
 * @author LiRui
 * @created 2019/2/22 0022
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class YhrwysdRwdRelation {

    private String ysdid;
    private String rwdid;

}
