package com.guiiii.diplom.parcers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.guiiii.diplom.uchchast.Kafedra;
import com.guiiii.diplom.util.MainFrameListener;

public class KafedrasParser {
    List<Kafedra> kafedras = new ArrayList<Kafedra>();

    public int open(File file, MainFrameListener mMainFrameListener) {
        try {
            final InputStream in = new FileInputStream(file);
            final HSSFWorkbook wb = new HSSFWorkbook(in);

            final Sheet sheet = wb.getSheetAt(1);

            final Iterator<Row> it = sheet.iterator();

            while (it.hasNext()) {
                final Row row = it.next();
                parseLoad(row);
            }
        } catch (final Exception e) {
            e.printStackTrace();
            return 1;
        }

        if (kafedras.size() == 0) {
            return 1;
        }

        System.out.println(kafedras.size());
        mMainFrameListener.setKafedraVolumes(kafedras);

        return 0;
    }

    private void parseLoad(Row row) {
        try {
            final String name = row.getCell(0).getStringCellValue();
            final int vstup = (int) row.getCell(1).getNumericCellValue();
            final int asp = (int) row.getCell(2).getNumericCellValue();
            final int doc = (int) row.getCell(3).getNumericCellValue();
            final int stag = (int) row.getCell(4).getNumericCellValue();

            kafedras.add(new Kafedra(name, vstup, asp, doc, stag));

        } catch (final Exception e) {
            // e.printStackTrace();
        }

    }
}
