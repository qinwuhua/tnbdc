package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * 养护任务验收单 - Bean
 * @author LiRui
 * @created 2019/2/22 0022
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Yhrwysd {

    private String rn;

    private String ysdid;
    private String ysdhtbh;
    private String ysdhtmc;
    private String ysdyd;
    private String ysdtbrq;
    private String ysdyszt;
    private String ysdlx;
    private String ysdyhdw;
    private String ysdgldw;
    private String ysdtbdw;
    private String ysdysyj;

    private String ysdysztname;//验收状态名称
    private String rwdidArrStr;//其下任务单ID的字符串：ID1,ID2,ID3，用于：添加关联关系

    List<Map> bhList;

}
