package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Qdxc implements Serializable {
    private static final long serialVersionUID = 5513601524146211490L;
    private String id,dwmc,dwbh,dwid,bmmc,bmbh,bmid,tbr,tbrid,tbrq,file,wfid,note,djbh,xclx,qqzh,xcfx,kssj,jssj,xcry,cphm,lx,zt;
}
