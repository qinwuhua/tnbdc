package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Xcsb implements Serializable {

    private static final long serialVersionUID = -2742434068779831556L;
    private String rwmxId;

    private String rwmxMid;

    private String rwmxDwmc;

    private String rwmxDwbh;

    private String rwmxDwid;

    private String rwmxBmmc;

    private String rwmxBmbh;

    private String rwmxBmid;

    private String rwmxTbr;

    private String rwmxTbrid;

    private Date rwmxTbrq;

    private String rwmxNote;

    private String rwmxSjdh;

    private String rwmxGps;

    private String rwmxSjlx;

    private String rwmxSjsm;

    private String rwmxJjd;

    private String rwmxTp;

    private String rwmxSp;

    private String rwmxZh;

    private Date rwmxFxsj;

    private String rwmxShlx;

    private String rwmxBhlx;

    private BigDecimal rwmxBhsl;

    private String rwmxKhnr;

    private String rwmxCd;

    private String rwmxCzfs;



    public String getRwmxId() {
        return rwmxId;
    }

    public void setRwmxId(String rwmxId) {
        this.rwmxId = rwmxId == null ? null : rwmxId.trim();
    }

    public String getRwmxMid() {
        return rwmxMid;
    }

    public void setRwmxMid(String rwmxMid) {
        this.rwmxMid = rwmxMid == null ? null : rwmxMid.trim();
    }

    public String getRwmxDwmc() {
        return rwmxDwmc;
    }

    public void setRwmxDwmc(String rwmxDwmc) {
        this.rwmxDwmc = rwmxDwmc == null ? null : rwmxDwmc.trim();
    }

    public String getRwmxDwbh() {
        return rwmxDwbh;
    }

    public void setRwmxDwbh(String rwmxDwbh) {
        this.rwmxDwbh = rwmxDwbh == null ? null : rwmxDwbh.trim();
    }

    public String getRwmxDwid() {
        return rwmxDwid;
    }

    public void setRwmxDwid(String rwmxDwid) {
        this.rwmxDwid = rwmxDwid == null ? null : rwmxDwid.trim();
    }

    public String getRwmxBmmc() {
        return rwmxBmmc;
    }

    public void setRwmxBmmc(String rwmxBmmc) {
        this.rwmxBmmc = rwmxBmmc == null ? null : rwmxBmmc.trim();
    }

    public String getRwmxBmbh() {
        return rwmxBmbh;
    }

    public void setRwmxBmbh(String rwmxBmbh) {
        this.rwmxBmbh = rwmxBmbh == null ? null : rwmxBmbh.trim();
    }

    public String getRwmxBmid() {
        return rwmxBmid;
    }

    public void setRwmxBmid(String rwmxBmid) {
        this.rwmxBmid = rwmxBmid == null ? null : rwmxBmid.trim();
    }

    public String getRwmxTbr() {
        return rwmxTbr;
    }

    public void setRwmxTbr(String rwmxTbr) {
        this.rwmxTbr = rwmxTbr == null ? null : rwmxTbr.trim();
    }

    public String getRwmxTbrid() {
        return rwmxTbrid;
    }

    public void setRwmxTbrid(String rwmxTbrid) {
        this.rwmxTbrid = rwmxTbrid == null ? null : rwmxTbrid.trim();
    }

    public Date getRwmxTbrq() {
        return rwmxTbrq;
    }

    public void setRwmxTbrq(Date rwmxTbrq) {
        this.rwmxTbrq = rwmxTbrq;
    }

    public String getRwmxNote() {
        return rwmxNote;
    }

    public void setRwmxNote(String rwmxNote) {
        this.rwmxNote = rwmxNote == null ? null : rwmxNote.trim();
    }

    public String getRwmxSjdh() {
        return rwmxSjdh;
    }

    public void setRwmxSjdh(String rwmxSjdh) {
        this.rwmxSjdh = rwmxSjdh == null ? null : rwmxSjdh.trim();
    }

    public String getRwmxGps() {
        return rwmxGps;
    }

    public void setRwmxGps(String rwmxGps) {
        this.rwmxGps = rwmxGps == null ? null : rwmxGps.trim();
    }

    public String getRwmxSjlx() {
        return rwmxSjlx;
    }

    public void setRwmxSjlx(String rwmxSjlx) {
        this.rwmxSjlx = rwmxSjlx == null ? null : rwmxSjlx.trim();
    }

    public String getRwmxSjsm() {
        return rwmxSjsm;
    }

    public void setRwmxSjsm(String rwmxSjsm) {
        this.rwmxSjsm = rwmxSjsm == null ? null : rwmxSjsm.trim();
    }

    public String getRwmxJjd() {
        return rwmxJjd;
    }

    public void setRwmxJjd(String rwmxJjd) {
        this.rwmxJjd = rwmxJjd == null ? null : rwmxJjd.trim();
    }

    public String getRwmxTp() {
        return rwmxTp;
    }

    public void setRwmxTp(String rwmxTp) {
        this.rwmxTp = rwmxTp == null ? null : rwmxTp.trim();
    }

    public String getRwmxSp() {
        return rwmxSp;
    }

    public void setRwmxSp(String rwmxSp) {
        this.rwmxSp = rwmxSp == null ? null : rwmxSp.trim();
    }

    public String getRwmxZh() {
        return rwmxZh;
    }

    public void setRwmxZh(String rwmxZh) {
        this.rwmxZh = rwmxZh == null ? null : rwmxZh.trim();
    }

    public Date getRwmxFxsj() {
        return rwmxFxsj;
    }

    public void setRwmxFxsj(Date rwmxFxsj) {
        this.rwmxFxsj = rwmxFxsj;
    }

    public String getRwmxShlx() {
        return rwmxShlx;
    }

    public void setRwmxShlx(String rwmxShlx) {
        this.rwmxShlx = rwmxShlx == null ? null : rwmxShlx.trim();
    }

    public String getRwmxBhlx() {
        return rwmxBhlx;
    }

    public void setRwmxBhlx(String rwmxBhlx) {
        this.rwmxBhlx = rwmxBhlx == null ? null : rwmxBhlx.trim();
    }

    public BigDecimal getRwmxBhsl() {
        return rwmxBhsl;
    }

    public void setRwmxBhsl(BigDecimal rwmxBhsl) {
        this.rwmxBhsl = rwmxBhsl;
    }

    public String getRwmxKhnr() {
        return rwmxKhnr;
    }

    public void setRwmxKhnr(String rwmxKhnr) {
        this.rwmxKhnr = rwmxKhnr == null ? null : rwmxKhnr.trim();
    }

    public String getRwmxCd() {
        return rwmxCd;
    }

    public void setRwmxCd(String rwmxCd) {
        this.rwmxCd = rwmxCd == null ? null : rwmxCd.trim();
    }

    public String getRwmxCzfs() {
        return rwmxCzfs;
    }

    public void setRwmxCzfs(String rwmxCzfs) {
        this.rwmxCzfs = rwmxCzfs == null ? null : rwmxCzfs.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rwmxId=").append(rwmxId);
        sb.append(", rwmxMid=").append(rwmxMid);
        sb.append(", rwmxDwmc=").append(rwmxDwmc);
        sb.append(", rwmxDwbh=").append(rwmxDwbh);
        sb.append(", rwmxDwid=").append(rwmxDwid);
        sb.append(", rwmxBmmc=").append(rwmxBmmc);
        sb.append(", rwmxBmbh=").append(rwmxBmbh);
        sb.append(", rwmxBmid=").append(rwmxBmid);
        sb.append(", rwmxTbr=").append(rwmxTbr);
        sb.append(", rwmxTbrid=").append(rwmxTbrid);
        sb.append(", rwmxTbrq=").append(rwmxTbrq);
        sb.append(", rwmxNote=").append(rwmxNote);
        sb.append(", rwmxSjdh=").append(rwmxSjdh);
        sb.append(", rwmxGps=").append(rwmxGps);
        sb.append(", rwmxSjlx=").append(rwmxSjlx);
        sb.append(", rwmxSjsm=").append(rwmxSjsm);
        sb.append(", rwmxJjd=").append(rwmxJjd);
        sb.append(", rwmxTp=").append(rwmxTp);
        sb.append(", rwmxSp=").append(rwmxSp);
        sb.append(", rwmxZh=").append(rwmxZh);
        sb.append(", rwmxFxsj=").append(rwmxFxsj);
        sb.append(", rwmxShlx=").append(rwmxShlx);
        sb.append(", rwmxBhlx=").append(rwmxBhlx);
        sb.append(", rwmxBhsl=").append(rwmxBhsl);
        sb.append(", rwmxKhnr=").append(rwmxKhnr);
        sb.append(", rwmxCd=").append(rwmxCd);
        sb.append(", rwmxCzfs=").append(rwmxCzfs);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}