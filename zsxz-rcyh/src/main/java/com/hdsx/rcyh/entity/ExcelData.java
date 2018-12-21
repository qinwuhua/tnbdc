package com.hdsx.rcyh.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class ExcelData implements Serializable {

    private List<ExcelTitle> titles;
    private String titleName;
    private String sheetName;
    private String fileName;
    private List<HashMap<String,Object>> dataList;
    private Integer rowSum;

    public Integer getRowSum() {
        return rowSum;
    }

    public void setRowSum(Integer rowSum) {
        this.rowSum = rowSum;
    }

    public List<ExcelTitle> getTitles() {
        return titles;
    }

    public void setTitles(List<ExcelTitle> titles) {
        this.titles = titles;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<HashMap<String, Object>> getDataList() {
        return dataList;
    }

    public void setDataList(List<HashMap<String, Object>> dataList) {
        this.dataList = dataList;
    }
}
