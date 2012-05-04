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
	public int open (File file, MainFrameListener mMainFrameListener) {
		try {
			 InputStream in = new FileInputStream(file);
	    	 HSSFWorkbook wb = new HSSFWorkbook(in);
	    	 
	    	 Sheet sheet = wb.getSheetAt(1);

	         Iterator<Row> it = sheet.iterator();
	         
	         while (it.hasNext()) {	 
	            Row row = it.next();
	            parseLoad(row);
	         }
		}
		catch(Exception e) {
			e.printStackTrace();
			return 1;
		}
		
		if(kafedras.size() == 0)
		{
			return 1;
		}
		
		System.out.println(kafedras.size());
		mMainFrameListener.setKafedraVolumes(kafedras);
		
		
        return 0;
	}
	
	private void parseLoad(Row row) {
		try{
			String name = row.getCell(0).getStringCellValue();
			int vstup = (int)row.getCell(1).getNumericCellValue();
			int asp = (int)row.getCell(2).getNumericCellValue();
			int doc = (int)row.getCell(3).getNumericCellValue();
			int stag = (int)row.getCell(4).getNumericCellValue();
			
			kafedras.add(new Kafedra(name, vstup, asp, doc, stag));
					
		}catch (Exception e){
			//e.printStackTrace();
		}
		
	}
	List<Kafedra> kafedras = new ArrayList<Kafedra>();
}
