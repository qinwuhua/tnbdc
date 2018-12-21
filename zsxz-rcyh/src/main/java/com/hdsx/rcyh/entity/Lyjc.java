package com.hdsx.rcyh.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 履约检查字段
 */
public class Lyjc implements Serializable{

    private static final long serialVersionUID = 3834262618582486202L;

    private String id;
    private String dwmc;
    private String dwid;
    private String bmmc;
    private String bmbh;
    private String bmid;
    private String tbr;
    private String tbrid;
    private Date tbrq;
    private String spzt;
    private String wfid;
    private String htbh;
    private Date jcrq;
    private String sgdw;
    private Double fjhj;
    private String gldw;
    private String jrc;
    private Double htjr;
    private String bz;
    private List<MultipartFile> multipartFiles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getDwid() {
        return dwid;
    }

    public void setDwid(String dwid) {
        this.dwid = dwid;
    }

    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }

    public String getBmbh() {
        return bmbh;
    }

    public void setBmbh(String bmbh) {
        this.bmbh = bmbh;
    }

    public String getBmid() {
        return bmid;
    }

    public void setBmid(String bmid) {
        this.bmid = bmid;
    }

    public String getTbr() {
        return tbr;
    }

    public void setTbr(String tbr) {
        this.tbr = tbr;
    }

    public String getTbrid() {
        return tbrid;
    }

    public void setTbrid(String tbrid) {
        this.tbrid = tbrid;
    }

    public Date getTbrq() {
        return tbrq;
    }

    public void setTbrq(Date tbrq) {
        this.tbrq = tbrq;
    }

    public String getSpzt() {
        return spzt;
    }

    public void setSpzt(String spzt) {
        this.spzt = spzt;
    }

    public String getWfid() {
        return wfid;
    }

    public void setWfid(String wfid) {
        this.wfid = wfid;
    }

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh;
    }

    public Date getJcrq() {
        return jcrq;
    }

    public void setJcrq(Date jcrq) {
        this.jcrq = jcrq;
    }

    public String getSgdw() {
        return sgdw;
    }

    public void setSgdw(String sgdw) {
        this.sgdw = sgdw;
    }

    public Double getFjhj() {
        return fjhj;
    }

    public void setFjhj(Double fjhj) {
        this.fjhj = fjhj;
    }

    public String getGldw() {
        return gldw;
    }

    public void setGldw(String gldw) {
        this.gldw = gldw;
    }

    public String getJrc() {
        return jrc;
    }

    public void setJrc(String jrc) {
        this.jrc = jrc;
    }

    public Double getHtjr() {
        return htjr;
    }

    public void setHtjr(Double htjr) {
        this.htjr = htjr;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public List<MultipartFile> getMultipartFiles() {
        return multipartFiles;
    }

    public void setMultipartFiles(List<MultipartFile> multipartFiles) {
        this.multipartFiles = multipartFiles;
    }
}
