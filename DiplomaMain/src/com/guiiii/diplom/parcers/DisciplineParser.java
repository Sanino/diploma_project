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

import com.guiiii.diplom.koefandenums.Occupations;
import com.guiiii.diplom.koefandenums.Occupations.Curse;
import com.guiiii.diplom.koefandenums.Occupations.Lection;
import com.guiiii.diplom.koefandenums.Occupations.MustOtherWork;
import com.guiiii.diplom.koefandenums.Occupations.StudingForm;
import com.guiiii.diplom.uchchast.Discipline;
import com.guiiii.diplom.uchchast.OccupationsTrain;
import com.guiiii.diplom.uchchast.OtherWork;
import com.guiiii.diplom.uchchast.StudyTiming;
import com.guiiii.diplom.util.MainFrameListener;

public class DisciplineParser {
	public DisciplineParser() {
		
	}
	
	public int open (File file, MainFrameListener mMainFrameListener) {
		//cafNames.clear();
		//stud.clear();
		try {
			System.out.println("" + file);
			 InputStream in = new FileInputStream(file);
	    	 HSSFWorkbook wb = new HSSFWorkbook(in);
	    	 
	    	 Sheet sheet = wb.getSheetAt(0);
	    	 
	    	 System.out.println(sheet);
	    	 System.out.println(sheet.getRowSumsBelow());
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
		
		if(disciplines.size() == 0 && otherWorks.size() == 0)
		{
			return 1;
		}
		
		mMainFrameListener.setStudingPlan(disciplines, otherWorks);
		
		
        return 0;
	}
	
	private void parseLoad(Row row) {
		try{
			String name = row.getCell(1).getStringCellValue();
			String type = row.getCell(2).getStringCellValue();
			String kafedra = row.getCell(3).getStringCellValue();
			String napr = row.getCell(4).getStringCellValue();
			String cont = "" + (int)row.getCell(5).getNumericCellValue();
			String credits = "" + (float)row.getCell(6).getNumericCellValue();
			
			
			System.out.println("name " + name + " type " + type + " " + kafedra + " " + napr + " " + cont + " " + credits);
			if(type == null){
				throw new NullPointerException();
			}
			
			
			if(type.equals("�")) {
				
				String studyForm = row.getCell(7).getStringCellValue();
				String curse = row.getCell(8).getStringCellValue();
				String lection = row.getCell(9).getStringCellValue();
				String timeLection = "" + row.getCell(10).getNumericCellValue();
				String timeLab ="" + row.getCell(11).getNumericCellValue();
				String timePrk = "" + row.getCell(12).getNumericCellValue();
				String timeSeminar = "" + row.getCell(13).getNumericCellValue();
				
				Occupations.Lection lectionType = null;
				if(lection.equals("��")){
					lectionType = Lection.ZO;
				} else if (lection.equals("��")) {
					lectionType = Lection.PS;
				} else if (lection.equals("��")){
					lectionType = Lection.PS;
				} else if (lection.equals("��")){
					lectionType = Lection.PV;
				} else if (lection.equals("��")){
					lectionType = Lection.SP;
				} else if (lection.equals("��")){
					lectionType = Lection.MP;
				}
				if(lectionType == null){
					throw new NullPointerException();
				}
				
				Occupations.Curse curse1 = null;
				if(curse.equals("1 ����")){
					curse1 = Curse.FIRST;
				} else if (curse.equals("2 ����")){
					curse1 = Curse.SECOND;
				} else if (curse.equals("3 ����")){
					curse1 = Curse.THIRD;
				} else if (curse.equals("4 ����")){
					curse1 = Curse.FOURTH;
				} else if (curse.equals("����")){
					curse1 = Curse.SPECIALIST;
				} else if (curse.equals("�������")){
					curse1 = Curse.MAGISTR;
				}
				if(curse1 == null) {
					throw new NullPointerException();
				}
				
				Occupations.StudingForm studyFormOcc = null;
				if(studyForm.equals("������")){
					studyFormOcc = StudingForm.DAILY;
				} else if (studyForm.equals("�������")){
					studyFormOcc = StudingForm.ZAOCH;
				}
				if(studyFormOcc == null){
					throw new NullPointerException();
				}
				
				StudyTiming st = new StudyTiming(Float.parseFloat(timeLection),
						Float.parseFloat(timeLab),
						Float.parseFloat(timePrk),
						Float.parseFloat(timeSeminar));
				
				OccupationsTrain otr = new OccupationsTrain(curse1, lectionType, studyFormOcc);
				Discipline d = new Discipline(name, napr, kafedra, Float.parseFloat(credits),
						Integer.parseInt(cont), st, otr);
				
				disciplines.add(d);
			} else {
				Occupations.MustOtherWork work = null;
				if (type.equals("��1")){
					work = MustOtherWork.CURSEWORK_ZO_FD;
				} else if (type.equals("��2")){
					work = MustOtherWork.CURSEWORK_PS_PV_SP_MP;
				} else if (type.equals("��1")){
					work = MustOtherWork.CURSEPROJECT_Z0_FD;
				} else if (type.equals("��2")){
					System.out.println("asdfasdfjsjfl;skjf;sdf");
					work = MustOtherWork.CURSEPROJECT_PS_PV_SP_MP;
				} else if (type.equals("����")){
					work = MustOtherWork.STADYPRACTIC;
				} else if (type.equals("��������")){
					work = MustOtherWork.WORKPRACTIC;
				} else if (type.equals("�����")){
					work = MustOtherWork.UNDERGRADUTEPRACTIC;
				} else if (type.equals("���")){
					work = MustOtherWork.STATEEXAM;
				} else if (type.equals("������")){
					work = MustOtherWork.DIPLOMA_GUIDE;
				} else if (type.equals("�����")){
					work = MustOtherWork.DIPLOMA_ECONOMIC_CONSULTATION;
				} else if (type.equals("������")){
					work = MustOtherWork.DIPLOMA_HEALTH_SAFE;
				}
				if (work == null){
					throw new NullPointerException();
				}
				System.out.println(work);
				
				OtherWork ow = new OtherWork(name, kafedra, napr, Float.parseFloat(credits), Integer.parseInt(cont), work);
				System.out.println(ow);
				
				otherWorks.add(ow);
			}		
		}catch (Exception e){
			//e.printStackTrace();
		}
		
	}
	List<Discipline> disciplines = new ArrayList<Discipline>();
	List<OtherWork> otherWorks  = new ArrayList<OtherWork>();
}
