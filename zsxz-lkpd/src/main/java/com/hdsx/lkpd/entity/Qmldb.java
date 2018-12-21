package com.hdsx.lkpd.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Qmldb implements Serializable {

        private static final long serialVersionUID = -1038585893737541092L;

        private String bmCode;
        private int ldid;			//路段id
        private String ldCode;
        private String lxCode;		//路线编码
        private String lxName;		//路线名
        private double szhh;		//起点桩号
        private double ezhh;		//止点桩号
        private int cd;				//长度
        private double lmkd;		//路面宽度
        private int bbid;			//版本编号
        private int lmlx;			//路面类型（1沥青路面，2水泥路面，3砂石路面）
        private int isgs;		//是否是高速或一级公路
        private String fx;			//方向（0301上行，0302下行，0303全幅）
        private String fxName;
        private String ldName;		//前面路段名，类似K340-K350

        private String rows;
        private String page;

        //路况调查
        private String dcid;		//调查主表id
        private String lxid;		//调查类型id
        private int dcbbid;			//调查版本id
        private String dcsj;		//调查时间
        private String dcry;		//调查人员
        private List<Lkdcfb> lkdcfb = new ArrayList<Lkdcfb>();//路况评定附表
        private double a0;			//沥青15.00，水泥10.66，砂石10.10
        private double a1;			//沥青0.412，水泥0.461，砂石0.487
        private double pci;
        private double tci;
        private double sci;
        private double bci;

        //路面检测
        private String jcbbid;		//路面检测版本id
        //路面行驶质量rqi
        private double iri;
        private double rqi;
        //路面车辙rdi
        private double rd;
        private double rdi;
        //路面抗滑性能sri
        private double sfc;
        private double sri;
        //路面结构强度pssi
        private double ssi;
        private double pssi;
        private double pqi;
        private double mqi;

        //路况评定
        private int pdbbid;

        //区段划分用
        private double jl;			//龟裂
        private double kl;			//块状裂缝
        private double dtlf;		//纵、横向裂缝
        private double cx;			//沉陷
        private double blyb;		//波浪拥包
        private double cz;			//车辙
        private double kc;			//坑槽
        private double ss;			//松散
        private double fy;			//泛油
        private double xb;			//修补

        private String pdsj;		//评定时间

        private List<Qmldb> mxbList = new ArrayList<Qmldb>();


}

