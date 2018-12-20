
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.lkpd.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**  
 *  
 * @author Baiyy
 * @created 2015年6月25日 下午3:12:11 
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Lmjcb implements Serializable {

	private static final long serialVersionUID = -4371175244456941470L;
	
	private int ldid;			//路段id
	private String lxCode;		//路线编码
	private String qmName;		//千米路段
	private double szhh;		//起点桩号
	private double ezhh;		//止点桩号
	private String fx;			//方向枚举id
	private String fxName;		//方向
	private String page;		
	private String rows;		
	
	private String jcid;		//检测
	private int bbid;			//版本
	private String jclx;		//检测类型
	private int jcbbid;			//沿用之前路面检测数据用版本id
	//检查点1-10
	private double jcd1;
	private double jcd2;
	private double jcd3;
	private double jcd4;
	private double jcd5;
	private double jcd6;
	private double jcd7;
	private double jcd8;
	private double jcd9;
	private double jcd10;
	private double zhi;			//值
	private double pjz;			//平均值
	

}
