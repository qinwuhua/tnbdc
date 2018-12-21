package com.hdsx.rcyh.utils;

import com.hdsx.rcyh.entity.ExcelData;
import com.hdsx.rcyh.entity.ExcelTitle;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelExport {

    public static void excel_export(ExcelData excelData, HttpServletResponse response) throws Exception{
        try {
            response.setContentType("octets/stream");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(excelData.getFileName().trim().getBytes("gb2312"), "ISO-8859-1") + ".xls");
            OutputStream out = response.getOutputStream();
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet(excelData.getSheetName());
            HSSFRow row = sheet.createRow((int) 0);
            HSSFCellStyle style = wb.createCellStyle();
            HSSFCellStyle style1 = wb.createCellStyle();
            HSSFCellStyle style2 = wb.createCellStyle();
            style.setBorderTop(BorderStyle.THIN);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            style1.setBorderTop(BorderStyle.THIN);
            style1.setBorderBottom(BorderStyle.THIN);
            style1.setBorderLeft(BorderStyle.THIN);
            style1.setBorderRight(BorderStyle.THIN);
            style2.setBorderTop(BorderStyle.THIN);
            style2.setBorderBottom(BorderStyle.THIN);
            style2.setBorderLeft(BorderStyle.THIN);
            style2.setBorderRight(BorderStyle.THIN);
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            style1.setAlignment(HorizontalAlignment.CENTER);
            style1.setVerticalAlignment(VerticalAlignment.CENTER);
            style1.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style2.setAlignment(HorizontalAlignment.CENTER);
            style2.setVerticalAlignment(VerticalAlignment.CENTER);
            HSSFCell cell = row.createCell((short) 0);
            cell.setCellType(CellType.STRING);
            row.setHeightInPoints(30f);
            HSSFFont font = wb.createFont();
            HSSFFont font1 = wb.createFont();
            font.setFontName("楷体");
            font.setFontHeightInPoints((short) 18);// 设置字体大小
            font1.setFontName("宋体");
            font1.setFontHeightInPoints((short) 10);// 设置字体大小
            style.setFont(font1);
            style2.setFont(font);
            cell.setCellValue(excelData.getTitleName());
            cell.setCellStyle(style2);
            List<ExcelTitle> et = excelData.getTitles();
            int maxy=0;
            int maxx=0;
            int minx=1;
            row = sheet.createRow((int) 1);
            for (ExcelTitle title : et) {
                row.setHeightInPoints(20f);
                int x1=title.getX1();
                int x2=title.getX2();
                int y1=title.getY1();
                int y2=title.getY2();
                if(y2>maxy){
                    maxy=y2;
                }
                if(x2>maxx){
                    maxx=x2;
                }
                if(x1>minx){
                    minx=x1;
                    row = sheet.createRow((int) x1);
                }
                cell = row.createCell((short) y1);
                cell.setCellValue(title.getName());
                cell.setCellStyle(style1);
            }
            for (int i = 0; i <=maxy ; i++) {
                sheet.setColumnWidth(i, 32 * 150);//设置固定宽度150
                //sheet.autoSizeColumn((short)i); //自动适应宽度
            }
            HSSFPrintSetup printSetup = sheet.getPrintSetup();
            printSetup.setLandscape(true);
            printSetup.setPaperSize(HSSFPrintSetup.A3_PAPERSIZE); // 纸张
            for (ExcelTitle excel_tilte : et){
                int x1=excel_tilte.getX1();
                int x2=excel_tilte.getX2();
                int y1=excel_tilte.getY1();
                int y2=excel_tilte.getY2();
                if(x1!=x2||y1!=y2){
                    CellRangeAddress range = new CellRangeAddress(x1,x2,y1,y2);
                    sheet.addMergedRegion(range);
                    setRegionStyle(style1,range,sheet);
                }
            }
            CellRangeAddress range = new CellRangeAddress(0,0,0,maxy);
            sheet.addMergedRegion(range);
            setRegionStyle(style2,range,sheet);
            List<HashMap<String, Object>> dataList = excelData.getDataList();
            for (int i = 0; i < dataList.size(); i++){
                row = sheet.createRow((int) i + maxx+1);
                Map<String,Object> rows = dataList.get(i);
                for (int j = 0; j <= maxy; j++) {
                    cell = row.createCell((short) j);
                    cell.setCellType(CellType.STRING);
                    for(int f=0; f<= excelData.getRowSum(); f++){
                        for (Object value : rows.values()){
                            cell.setCellValue(String.valueOf(value));
                            cell.setCellStyle(style);
                        }
                        /*if(j==f){
                            *//*String val = String.valueOf(rows.get("V_"+j));*//*

                            cell.setCellValue(val);
                            cell.setCellStyle(style);
                        }*/
                    }
                }
            }
            wb.write(out);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 设置合并单元格格式
     * @param sheet
     * @param region
     * @param cs
     */
    private static void setRegionStyle(CellStyle cs, CellRangeAddress region, Sheet sheet){
        for(int i=region.getFirstRow();i<=region.getLastRow();i++){
            Row row=sheet.getRow(i);
            if(row==null) row=sheet.createRow(i);
            for(int j=region.getFirstColumn();j<=region.getLastColumn();j++){
                Cell cell=row.getCell(j);
                if( cell==null){
                    cell=row.createCell(j);
                    cell.setCellValue("");
                }
                cell.setCellStyle(cs);
            }
        }
    }
}
