package com.guiiii.diplom.parcers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.guiiii.diplom.uchchast.Employment;

public class ReportSaver {
    public static void save(String path, String s1, List<Employment> emplo) {
        
        
        
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("workbook.xls");
        } catch (FileNotFoundException e1) {
        }
        Workbook wb = new HSSFWorkbook();
        Sheet s = wb.createSheet();
        Row r = null;
        Cell c = null;
        CellStyle cs = wb.createCellStyle();
        Font f = wb.createFont();
        f.setFontHeightInPoints((short) 12);
        cs.setFont(f);
        wb.setSheetName(0, "s1");
        int rownum = 0;
        r = s.createRow(rownum++);
        c = r.createCell(0);
        c.setCellValue("Шапка");
        r = s.createRow(rownum++);
        c = r.createCell(0);
        c.setCellValue("Наименование");
        c = r.createCell(1);
        c.setCellValue("Контингент");
        c = r.createCell(2);
        c.setCellValue("Кoэффициент");
        c = r.createCell(3);
        c.setCellValue("Курс");
        c = r.createCell(4);
        c.setCellValue("Форма обучения");
        c = r.createCell(5);
        c.setCellValue("Нагрузка");
        c = r.createCell(6);
        c.setCellValue("Количество кредитов");
        for (Employment e: emplo) {
            r = s.createRow(rownum++);

            c = r.createCell(0);
            c.setCellValue(e.getName());
            c = r.createCell(1);
            c.setCellValue(e.getContingent());
            c = r.createCell(2);
            c.setCellValue(e.getKoef());
            c = r.createCell(3);
            c.setCellValue("1");
            c = r.createCell(4);
            c.setCellValue("Дневная");
            c = r.createCell(6);
            c.setCellValue(e.getStuff());
            c = r.createCell(7);
            c.setCellValue("Количество кредитов");

        }
        r = s.createRow(rownum);
        try {
            wb.write(out);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
