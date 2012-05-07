package com.guiiii.diplom.uchchast;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guiiii.diplom.gui.FactorsFrame;
import com.guiiii.diplom.gui.MainFrame;
import com.guiiii.diplom.koefandenums.Factors;
import com.guiiii.diplom.koefandenums.FactorsHelper;
import com.guiiii.diplom.koefandenums.Occupations.KafFactors;
import com.guiiii.diplom.util.FactorsFrameListener;
import com.guiiii.diplom.util.MainFrameListener;

public class Main {

    public static void main(String[] args) {

        launchMainFrame(mMainFrameListener);
    }

    public static void launchMainFrame(final MainFrameListener mfl) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    mf = new MainFrame(mfl);
                    mf.setVisible(true);
                    mf.addToLog("Лог:");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void launchFactorsFrame(final FactorsFrameListener ffl) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ff = new FactorsFrame(ffl);
                    ff.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static MainFrameListener mMainFrameListener = new MainFrameListener() {

        @Override
        public void setStuff(float stuff) {
            // TODO Auto-generated method stub
            mStuff = stuff;
            mf.addToLog("Введен общий штат: " + mStuff);
            hasStaff = true;
            mf.checkStaff(true);
            if (hasFactors && hasStaff && hasPlan && hasKaf) {
                mf.setCanStarted();
            }
        }

        @Override
        public void setFactors() {
            launchFactorsFrame(mFactorsFrameListener);
        }

        @Override
        public void calculate() {
            int aspSum = 0;
            int doctSum = 0;
            int vstupSum = 0;
            int stagSum = 0;

            for (Kafedra k : mKaf) {
                aspSum += k.getAsp();
                vstupSum += k.getVstup();
                doctSum += k.getDoc();
                stagSum += k.getStag();
            }
            mf.addToLog("Нагрузка необходимая на проведение вступительных экзаменов: "
                    + vstupSum
                    + " * "
                    + mFactors.getKafFactors(KafFactors.VSTUP)
                    + " = "
                    + (mFactors.getKafFactors(KafFactors.VSTUP) * vstupSum));
            mf.addToLog("Нагрузка необходимая на руководство аспирантами: "
                    + aspSum + " * " + mFactors.getKafFactors(KafFactors.ASP)
                    + " = " + (mFactors.getKafFactors(KafFactors.ASP) * aspSum));

            mf.addToLog("Нагрузка необходимая на руководство докторантами: "
                    + doctSum + " * " + mFactors.getKafFactors(KafFactors.DOC)
                    + " = "
                    + (mFactors.getKafFactors(KafFactors.DOC) * doctSum));

            mf.addToLog("Нагрузка необходимая на руководство стажерами: "
                    + stagSum + " * " + mFactors.getKafFactors(KafFactors.STAG)
                    + " = "
                    + (mFactors.getKafFactors(KafFactors.STAG) * stagSum));

            float otherShtat = mFactors.getKafFactors(KafFactors.VSTUP)
                    * vstupSum + mFactors.getKafFactors(KafFactors.ASP)
                    * aspSum + mFactors.getKafFactors(KafFactors.DOC) * doctSum
                    + mFactors.getKafFactors(KafFactors.STAG) * stagSum;

            float uchStuff = mStuff - otherShtat;

            mf.addToLog("Нагрузка необходимая для обеспечения учебного процесса: "
                    + mStuff + " - " + otherShtat + " = " + uchStuff);

            if (uchStuff < 0) {
                hasStaff = false;

                return;
            }

            Map<String, Float> sumPriv = new HashMap<String, Float>();
            for (String s : napravl.keySet()) {
                System.out.println(s);
                sumPriv.put(s, (float) 0);
            }

            float privAllSum = 0;
            for (String napr : sumPriv.keySet()) {
                float dayliStuff = 0;
                float zaochStuff = 0;
                for (Discipline d : disciplines) {
                    d.toString();
                    if (d.getNapr().equals(napr)) {
                        switch (d.getStudyForm()) {
                        case DAILY:
                            dayliStuff += d.getContingent();
                            break;
                        case ZAOCH:
                            zaochStuff += d.getContingent();
                            break;
                        }
                    }
                }

                for (OtherWork d : otherWorks) {
                    d.toString();
                    if (d.getNapr().equals(napr)) {
                        switch (d.getStudyForm()) {
                        case DAILY:
                            dayliStuff += d.getContingent();
                            break;
                        case ZAOCH:
                            zaochStuff += d.getContingent();
                            break;
                        }
                    }
                }
                mf.addToLog("Контингент направления - " + napr
                        + " дневной формы обучения: " + dayliStuff);
                mf.addToLog("Контингент направления - " + napr
                        + " заочной формы обучения: " + zaochStuff);

                mf.addToLog("Суммарный приведенный контингент направения "
                        + napr + ": " + (dayliStuff + 0.2 * zaochStuff));

                sumPriv.put(napr, (float) (dayliStuff * 0.2 * zaochStuff));
                privAllSum += (float) (dayliStuff * 0.2 * zaochStuff);
            }

            float sum = 0;
            for (String s : sumPriv.keySet()) {
                sumPriv.put(s, uchStuff * (sumPriv.get(s) / privAllSum));
                mf.addToLog("Нагрузка направения " + s + ": " + sumPriv.get(s));
                sum += sumPriv.get(s);
            }
            mf.addToLog("Общая нагрузка: " + sum);

            for (String s : sumPriv.keySet()) {
                float koefsum = 0;
                for (Discipline d : disciplines) {
                    d.toString();
                    if (d.getNapr().equals(s)) {
                        d.calculateFactor(mFactors);
                        koefsum += d.getKoef();
                    }
                }
                for (OtherWork d : otherWorks) {
                    if (d.getNapr().equals(s)) {
                        d.calculateFactor(mFactors);
                        koefsum += d.getKoef();
                    }
                }

                for (Discipline d : disciplines) {
                    d.toString();
                    if (d.getNapr().equals(s)) {
                        d.setStuff(sumPriv.get(s) * (d.getKoef() / koefsum));
                    }
                }

                for (OtherWork d : otherWorks) {
                    if (d.getNapr().equals(s)) {
                        d.setStuff(sumPriv.get(s) * (d.getKoef() / koefsum));
                    }
                }
            }

            for (String kaf : kafedr.keySet()) {
                float kaffStaff = 0;
                for (Discipline d : disciplines) {
                    if (d.getKafedra().equals(kaf)) {
                        kaffStaff += d.getStuff();
                    }
                }

                for (OtherWork d : otherWorks) {
                    if (d.getKafedra().equals(kaf)) {
                        kaffStaff += d.getStuff();
                    }
                }
                mf.addToLog("Нагрузка кафедры " + kaf + ": " + kaffStaff);
            }

        }

        @Override
        public void setStudingPlan(List<Discipline> ds, List<OtherWork> ow) {
            // TODO Auto-generated method stub
            mf.addToLog("Введен учебный план");

            disciplines = ds;
            otherWorks = ow;

            for (Discipline d : ds) {
                kafedr.put(
                        d.getKafedra(),
                        ((kafedr.get(d.getKafedra()) == null) ? d
                                .getContingent()
                                : (kafedr.get(d.getKafedra()) + d
                                        .getContingent())));
                napravl.put(
                        d.getNapr(),
                        ((napravl.get(d.getNapr()) == null) ? d.getContingent()
                                : (napravl.get(d.getNapr()) + d.getContingent())));
            }

            for (OtherWork d : ow) {
                kafedr.put(
                        d.getKafedra(),
                        ((kafedr.get(d.getKafedra()) == null) ? d
                                .getContingent()
                                : (kafedr.get(d.getKafedra()) + d
                                        .getContingent())));
                napravl.put(
                        d.getNapr(),
                        ((napravl.get(d.getNapr()) == null) ? d.getContingent()
                                : (napravl.get(d.getNapr()) + d.getContingent())));
            }

            mf.addToLog("Количество направлений: " + napravl.size());
            mf.addToLog("Количество дисциплин: " + napravl.size());
            mf.addToLog("Количество дисциплин: " + ds.size());
            mf.addToLog("Количество других работ: " + ow.size());

            int sum = 0;
            for (String str : napravl.keySet()) {
                System.out.println(str + napravl.get(str));
                sum += napravl.get(str);
            }
            mf.addToLog("Суммарный контингент: " + sum);

            mf.addToLog("Дисциплины:");
            int i = 0;
            for (Discipline d : ds) {
                mf.addToLog("" + (i + 1) + ". " + d.getName());
                mf.addToLog("\tКонтингент: " + d.getContingent());
                mf.addToLog("\tКафедра: " + d.getKafedra());
                mf.addToLog("\tНаправление: " + d.getNapr());
                mf.addToLog("\tФорма обучения: " + d.getStudyForm());
                i++;
            }

            i = 0;
            mf.addToLog("Другие виды работ:");
            for (OtherWork o : ow) {
                mf.addToLog("" + (i + 1) + ". " + o.getName());
                mf.addToLog("\tКонтингент: " + o.getContingent());
                mf.addToLog("\tКафедра: " + o.getKafedra());
                mf.addToLog("\tНаправление: " + o.getNapr());
                i++;
            }

            hasPlan = true;
            mf.checkPlan(true);

            if (hasFactors && hasStaff && hasPlan && hasKaf) {
                mf.setCanStarted();
            }
        }

        @Override
        public void setKafedraVolumes(List<Kafedra> kaf) {
            mKaf = kaf;
            for (Kafedra k : mKaf) {
                System.out.println(k.getKafedraName() + " " + k.getVstup()
                        + " " + k.getAsp() + " " + k.getDoc() + " "
                        + k.getStag());
            }

            hasKaf = true;
            mf.checkKaf(true);
            mf.addToLog("Введены данные по кафедрам");
            if (hasFactors && hasStaff && hasPlan && hasKaf) {
                mf.setCanStarted();
            }
        }
    };

    private static FactorsFrameListener mFactorsFrameListener = new FactorsFrameListener() {

        @Override
        public void okBtnClick(FactorsHelper fh) {
            // TODO Auto-generated method stub
            mFactors = new Factors(fh);
            mf.addToLog("Введены коэффициенты расчета");
            mf.checkFactors(true);
            hasFactors = true;
            if (hasFactors && hasStaff && hasPlan && hasKaf) {
                mf.setCanStarted();
            }
        }
    };

    private static Factors mFactors;
    private static List<Discipline> disciplines;
    private static List<OtherWork> otherWorks;

    private static MainFrame mf;
    private static FactorsFrame ff;

    private static float mStuff;

    private static boolean hasFactors;
    private static boolean hasStaff;
    private static boolean hasPlan;
    private static boolean hasKaf;

    private static Map<String, Integer> kafedr = new HashMap<String, Integer>();
    private static Map<String, Integer> napravl = new HashMap<String, Integer>();

    private static List<Kafedra> mKaf;
}
