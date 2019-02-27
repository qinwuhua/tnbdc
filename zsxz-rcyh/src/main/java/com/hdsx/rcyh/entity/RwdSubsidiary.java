package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 养护/清扫任务单子表
 * @author LiRui
 * @created 2019/2/27 0027
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class RwdSubsidiary {

    private String id;
    private String rwdid;
    private String sjid;
    private String ryid;
    private String rymc;
    private String zpsj;
    private String wxsj;
    private String wxzt;
    private String sslx;

}
