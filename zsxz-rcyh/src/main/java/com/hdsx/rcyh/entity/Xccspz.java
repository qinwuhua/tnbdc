package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Xccspz implements Serializable {

    private static final long serialVersionUID = 6010038448640771150L;
    private String xccsId;

    private String xccsDwmc;

    private String xccsDwbh;

    private String xccsDwid;

    private String xccsXclx;

    private BigDecimal xccsRcs;

    private BigDecimal xccsYcs;

    private BigDecimal xccsNcs;

    private String xccsNote;



    public String getXccsId() {
        return xccsId;
    }

    public void setXccsId(String xccsId) {
        this.xccsId = xccsId == null ? null : xccsId.trim();
    }

    public String getXccsDwmc() {
        return xccsDwmc;
    }

    public void setXccsDwmc(String xccsDwmc) {
        this.xccsDwmc = xccsDwmc == null ? null : xccsDwmc.trim();
    }

    public String getXccsDwbh() {
        return xccsDwbh;
    }

    public void setXccsDwbh(String xccsDwbh) {
        this.xccsDwbh = xccsDwbh == null ? null : xccsDwbh.trim();
    }

    public String getXccsDwid() {
        return xccsDwid;
    }

    public void setXccsDwid(String xccsDwid) {
        this.xccsDwid = xccsDwid == null ? null : xccsDwid.trim();
    }

    public String getXccsXclx() {
        return xccsXclx;
    }

    public void setXccsXclx(String xccsXclx) {
        this.xccsXclx = xccsXclx == null ? null : xccsXclx.trim();
    }

    public BigDecimal getXccsRcs() {
        return xccsRcs;
    }

    public void setXccsRcs(BigDecimal xccsRcs) {
        this.xccsRcs = xccsRcs;
    }

    public BigDecimal getXccsYcs() {
        return xccsYcs;
    }

    public void setXccsYcs(BigDecimal xccsYcs) {
        this.xccsYcs = xccsYcs;
    }

    public BigDecimal getXccsNcs() {
        return xccsNcs;
    }

    public void setXccsNcs(BigDecimal xccsNcs) {
        this.xccsNcs = xccsNcs;
    }

    public String getXccsNote() {
        return xccsNote;
    }

    public void setXccsNote(String xccsNote) {
        this.xccsNote = xccsNote == null ? null : xccsNote.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", xccsId=").append(xccsId);
        sb.append(", xccsDwmc=").append(xccsDwmc);
        sb.append(", xccsDwbh=").append(xccsDwbh);
        sb.append(", xccsDwid=").append(xccsDwid);
        sb.append(", xccsXclx=").append(xccsXclx);
        sb.append(", xccsRcs=").append(xccsRcs);
        sb.append(", xccsYcs=").append(xccsYcs);
        sb.append(", xccsNcs=").append(xccsNcs);
        sb.append(", xccsNote=").append(xccsNote);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}