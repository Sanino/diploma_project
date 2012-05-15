package com.guiiii.diplom.parcers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.guiiii.diplom.uchchast.Discipline;
import com.guiiii.diplom.uchchast.DisciplineZaoch;
import com.guiiii.diplom.uchchast.Employment;
import com.guiiii.diplom.uchchast.Kafedra;

public class ReportSaver {
    public static void save(String path, String name, List<Employment> emplo, List<Kafedra> kaf) {
        
        
        
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
        } catch (FileNotFoundException e1) {
        }
        Workbook wb = new HSSFWorkbook();
        Sheet s = wb.createSheet();
        Row r = null;
        Cell c = null;
        

        CellStyle cs = wb.createCellStyle();
        cs.setBorderBottom((short) 1);
        cs.setBorderLeft((short) 1);
        cs.setBorderRight((short) 1);
        cs.setBorderTop((short) 1);
        //Font f = wb.createFont();
        //f.setFontHeightInPoints((short) 12);
        //cs.setFont(f);
        wb.setSheetName(0, name);
        int rownum = 0;
        r = s.createRow(rownum++);
        c = r.createCell(0);
        c.setCellStyle(cs);
        c.setCellValue("Шапка");
        rownum += 2;
        r = s.createRow(rownum++);
        c = r.createCell(0);
        c.setCellStyle(cs);
        c.setCellValue("#");
        c = r.createCell(1);
        c.setCellStyle(cs);
        c.setCellValue("Наименование");
        c = r.createCell(2);
        c.setCellStyle(cs);
        c.setCellValue("Направление");
        c = r.createCell(3);
        c.setCellStyle(cs);
        c.setCellValue("Кафедра");
        c = r.createCell(4);
        c.setCellStyle(cs);
        c.setCellValue("Вид");
        c = r.createCell(5);
        c.setCellStyle(cs);
        c.setCellValue("Курс");
        c = r.createCell(6);
        c.setCellStyle(cs);
        c.setCellValue("Форма");
        c = r.createCell(7);
        c.setCellStyle(cs);
        c.setCellValue("Контингент");
        c = r.createCell(8);
        c.setCellStyle(cs);
        c.setCellValue("Объем");
        c = r.createCell(9);
        c.setCellStyle(cs);
        c.setCellValue("Нагрузка");
        int i = 1;
        for (Employment e: emplo) {
            r = s.createRow(rownum++);
            c = r.createCell(0);
            c.setCellStyle(cs);
           
            c.setCellValue(i++);  
            c = r.createCell(1);
            c.setCellStyle(cs);
            c.setCellValue(e.getName());
            c = r.createCell(2);
            c.setCellStyle(cs);
            c.setCellValue(e.getNapr());
            c = r.createCell(3);
            c.setCellStyle(cs);
            c.setCellValue(e.getKafedra());
            c = r.createCell(4);
            c.setCellStyle(cs);
            if(e instanceof Discipline || e instanceof DisciplineZaoch){
                c.setCellValue("Дис");  
            } else {
                c.setCellValue("Др.");
            }
            c = r.createCell(5);
            c.setCellStyle(cs);
            switch (e.getCurse()) {
            case FIRST:
                c.setCellValue("1 курс");
                break;
            case SECOND: 
                c.setCellValue("2 курс");
                break;
            case THIRD:
                c.setCellValue("3 курс");
                break;
            case FOURTH:
                c.setCellValue("4 курс");
                break;
            case SPECIALIST:
                c.setCellValue("Специалист");
                break;
            case MAGISTR:
                c.setCellValue("Магистр");
                break;
            }
            c = r.createCell(6);
            c.setCellStyle(cs);
            if(e instanceof Discipline){
                c.setCellValue("Дневная");
            } else if (e instanceof DisciplineZaoch) {
                c.setCellValue("Заочная");
            } else {
                c.setCellValue("---");
            }
            c = r.createCell(7);
            c.setCellStyle(cs);
            c.setCellValue(e.getContingent());
            c = r.createCell(8);
            c.setCellStyle(cs);
            c.setCellValue(e.getCredit());
            c = r.createCell(9);
            c.setCellStyle(cs);
            c.setCellValue(e.getStuff());

        }
        r = s.createRow(rownum);
        s.autoSizeColumn(0);
        s.autoSizeColumn(1);
        s.autoSizeColumn(2);
        s.autoSizeColumn(3);
        s.autoSizeColumn(4);
        s.autoSizeColumn(5);
        s.autoSizeColumn(6);
        s.autoSizeColumn(7);
        s.autoSizeColumn(8);
        s.autoSizeColumn(9);
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
