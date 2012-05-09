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
import com.guiiii.diplom.uchchast.Discipline;
import com.guiiii.diplom.uchchast.DisciplineZaoch;
import com.guiiii.diplom.uchchast.OtherWork;
import com.guiiii.diplom.uchchast.StudyTiming;
import com.guiiii.diplom.util.MainFrameListener;

public class DisciplineParser {
    List<Discipline> disciplines = new ArrayList<Discipline>();
    List<DisciplineZaoch> disciplinesZ = new ArrayList<DisciplineZaoch>();

    List<OtherWork> otherWorks = new ArrayList<OtherWork>();

    public DisciplineParser() {

    }

    public int open(File file, MainFrameListener mMainFrameListener) {

        try {
            final InputStream in = new FileInputStream(file);
            final HSSFWorkbook wb = new HSSFWorkbook(in);

            final Sheet sheet = wb.getSheetAt(0);

            final Iterator<Row> it = sheet.iterator();

            while (it.hasNext()) {
                final Row row = it.next();
                parseLoad(row);
            }
        } catch (final Exception e) {
            e.printStackTrace();
            return 1;
        }

        if ((disciplines.size() == 0) && (otherWorks.size() == 0)) {
            return 1;
        }

        mMainFrameListener.setStudingPlan(disciplines,disciplinesZ, otherWorks);

        return 0;
    }
    private void parseLoad(Row row) {
        try {
            final String name = row.getCell(1).getStringCellValue();
            final String type = row.getCell(2).getStringCellValue();
            final String kafedra = row.getCell(3).getStringCellValue();
            final String napr = row.getCell(4).getStringCellValue();
            final String cont = "" + (int) row.getCell(5).getNumericCellValue();
            final String credits = "" + (float) row.getCell(6).getNumericCellValue();
            final String studyForm = row.getCell(7).getStringCellValue();
            final String curse = row.getCell(8).getStringCellValue();

            if (type == null) {
                throw new NullPointerException();
            }

            Occupations.Curse curse1 = null;
            if (curse.equals("1 курс")) {
                curse1 = Curse.FIRST;
            } else if (curse.equals("2 курс")) {
                curse1 = Curse.SECOND;
            } else if (curse.equals("3 курс")) {
                curse1 = Curse.THIRD;
            } else if (curse.equals("4 курс")) {
                curse1 = Curse.FOURTH;
            } else if (curse.equals("Спец")) {
                curse1 = Curse.SPECIALIST;
            } else if (curse.equals("Магистр")) {
                curse1 = Curse.MAGISTR;
            }
            if (curse1 == null) {
                throw new NullPointerException();
            }
            
            if (type.equals("Д")) {


                final String lection = row.getCell(9).getStringCellValue();
                final String timeLection = "" + row.getCell(10).getNumericCellValue();
                final String timeLab = "" + row.getCell(11).getNumericCellValue();
                final String timePrk = "" + row.getCell(12).getNumericCellValue();
                final String timeSeminar = "" + row.getCell(13).getNumericCellValue();

                Occupations.Lection lectionType = null;
                if (lection.equals("ЗО")) {
                    lectionType = Lection.ZO;
                } else if (lection.equals("ПС")) {
                    lectionType = Lection.PS;
                } else if (lection.equals("ФД")) {
                    lectionType = Lection.PS;
                } else if (lection.equals("ПВ")) {
                    lectionType = Lection.PV;
                } else if (lection.equals("СП")) {
                    lectionType = Lection.SP;
                } else if (lection.equals("МП")) {
                    lectionType = Lection.MP;
                }
                if (lectionType == null) {
                    throw new NullPointerException();
                }


                final StudyTiming st = new StudyTiming(Float.parseFloat(timeLection),
                        Float.parseFloat(timeLab), Float.parseFloat(timePrk),
                        Float.parseFloat(timeSeminar));

                
                Occupations.StudingForm studyFormOcc = null;
                if (studyForm.equals("дневная")) {
                    final Discipline d = new Discipline(name, napr, kafedra,
                            Float.parseFloat(credits),Integer.parseInt(cont),
                            st, curse1, lectionType);
                    disciplines.add(d);
                } else if (studyForm.equals("заочная")) {
                    final DisciplineZaoch d = new DisciplineZaoch(name, napr, kafedra,
                            Float.parseFloat(credits),Integer.parseInt(cont),
                            st, curse1, lectionType);
                    disciplinesZ.add(d);
                }
                if (studyFormOcc == null) {
                    throw new NullPointerException();
                }
                

                
            } else {
                Occupations.MustOtherWork work = null;
                if (type.equals("КР1")) {
                    work = MustOtherWork.CURSEWORK_ZO_FD;
                } else if (type.equals("КР2")) {
                    work = MustOtherWork.CURSEWORK_PS_PV_SP_MP;
                } else if (type.equals("КП1")) {
                    work = MustOtherWork.CURSEPROJECT_Z0_FD;
                } else if (type.equals("КП2")) {
                    work = MustOtherWork.CURSEPROJECT_PS_PV_SP_MP;
                } else if (type.equals("ПРУЧ")) {
                    work = MustOtherWork.STADYPRACTIC;
                } else if (type.equals("ПРПРОИЗВ")) {
                    work = MustOtherWork.WORKPRACTIC;
                } else if (type.equals("ПРДИП")) {
                    work = MustOtherWork.UNDERGRADUTEPRACTIC;
                } else if (type.equals("ГОС")) {
                    work = MustOtherWork.STATEEXAM;
                } else if (type.equals("ДИПРУК")) {
                    work = MustOtherWork.DIPLOMA_GUIDE;
                } else if (type.equals("ДИПЕК")) {
                    work = MustOtherWork.DIPLOMA_ECONOMIC_CONSULTATION;
                } else if (type.equals("ДИПОХР")) {
                    work = MustOtherWork.DIPLOMA_HEALTH_SAFE;
                }
                if (work == null) {
                    throw new NullPointerException();
                }


                final OtherWork ow = new OtherWork(name, kafedra, napr,
                        Float.parseFloat(credits), Integer.parseInt(cont),curse1, work);

                otherWorks.add(ow);
            }
        } catch (final Exception e) {
            // e.printStackTrace();
        }

    }
}
