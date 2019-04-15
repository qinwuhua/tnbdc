package com.tnbdc.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor//无参构造函数
@Accessors(chain = true)
public class Users implements Serializable {
    private String id;
    private String username;//用户名
    private String password;//密码
    private String sat;//盐
    private String sex;//性别
    private String csrq;//出生日期
    private String zdrq;//诊断日期
    private String zd1xtnb;//诊断1型糖尿病
    private String sjycd;//受教育程度
    private String lxdh;//联系电话
    private String email;//邮箱
    private String userlv;//用户级别
    private String name;//姓名

}
