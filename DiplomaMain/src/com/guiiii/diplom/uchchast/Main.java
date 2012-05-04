package com.guiiii.diplom.uchchast;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.guiiii.diplom.gui.FactorsFrame;
import com.guiiii.diplom.gui.MainFrame;
import com.guiiii.diplom.koefandenums.Factors;
import com.guiiii.diplom.koefandenums.FactorsHelper;
import com.guiiii.diplom.util.FactorsFrameListener;
import com.guiiii.diplom.util.MainFrameListener;

public class Main {

	public Main() {
		// TODO Auto-generated method stub
		launchMainFrame(mMainFrameListener);
	}
	
	public void launchMainFrame(final MainFrameListener mfl) {
		EventQueue.invokeLater(new Runnable() {
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
	
	public void launchFactorsFrame(final FactorsFrameListener ffl) {
		EventQueue.invokeLater(new Runnable() {
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
	
	private MainFrameListener mMainFrameListener = new MainFrameListener() {
		
		@Override
		public void setStuff(float stuff) {
			// TODO Auto-generated method stub
			mStuff = stuff;
			mf.addToLog("Введена общая нагрузка");
			hasStaff = true;
			mf.checkStaff(true);
			if(hasFactors && hasStaff && hasPlan && hasKaf){
				mf.setCanStarted();
			}
			
			
		}
		
		@Override
		public void setFactors() {
			// TODO Auto-generated method stub
			//mf.dispose();
			launchFactorsFrame(mFactorsFrameListener);	
		}
		
		@Override
		public void calculate() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setStudingPlan(List<Discipline> ds, List<OtherWork> ow) {
			// TODO Auto-generated method stub
			
			for(Discipline d : ds) {
				kafedr.put(d.getKafedra(), ((kafedr.get(d.getKafedra()) == null) ? d.getContingent() : (kafedr.get(d.getKafedra()) + d.getContingent()) ));
				napravl.put(d.getNapr(), ((napravl.get(d.getNapr()) == null) ? d.getContingent() : (napravl.get(d.getNapr()) + d.getContingent())));
			}
			
			for(OtherWork d : ow) {
				kafedr.put(d.getKafedra(), ((kafedr.get(d.getKafedra()) == null) ? d.getContingent() : (kafedr.get(d.getKafedra()) + d.getContingent())));
				napravl.put(d.getNapr(), ((napravl.get(d.getNapr()) == null) ? d.getContingent() : (napravl.get(d.getNapr()) + d.getContingent())));
			}
			
			mf.checkKaf(kafedr.size());
			mf.checkNapr(napravl.size());
			
			mf.checkDis(ds.size());
			mf.checkWorks(ow.size());
			
			int sum = 0;
			for(String str: napravl.keySet()) {
				System.out.println(str + napravl.get(str));
				sum += napravl.get(str);
			}
			mf.checkKon(sum);
			
			hasPlan = true;
			mf.checkPlan(true);
			mf.addToLog("Введен учебный план");
			if(hasFactors && hasStaff && hasPlan && hasKaf){
				mf.setCanStarted();
			}
			
			
		}

		@Override
		public void setKafedraVolumes(List<Kafedra> kaf) {
			// TODO Auto-generated method stub
			mKaf = kaf;
			for(Kafedra k: mKaf) {
				System.out.println(k.getKafedraName() + " " + k.getVstup() + " " + k.getAsp() + " " + k.getDoc() + " " + k.getStag());
			}
			
			hasKaf = true;
			mf.checkKaf(true);
			mf.addToLog("Введены данные по кафедрам");
			if(hasFactors && hasStaff && hasPlan && hasKaf){
				mf.setCanStarted();
			}
			
		}
	};
	
	private FactorsFrameListener mFactorsFrameListener = new FactorsFrameListener() {

		@Override
		public void okBtnClick(FactorsHelper fh) {
			// TODO Auto-generated method stub
			mFactors = new Factors(fh);
			mf.addToLog("Введены коэффициенты расчета");
			mf.checkFactors(true);
			if(hasFactors && hasStaff && hasPlan && hasKaf){
				mf.setCanStarted();
			}
		}
	};
	
	private Factors mFactors;
	private List<Discipline> disciplines = new ArrayList<Discipline>();
	private List<OtherWork> otherWorks = new ArrayList<OtherWork>();
	
	private MainFrame mf;
	private FactorsFrame ff;
	
	private float mStuff;
	
	private boolean hasFactors;
	private boolean hasStaff;
	private boolean hasPlan;
	private boolean hasKaf;
	
	Map<String, Integer> kafedr = new HashMap<String, Integer>();
	Map<String, Integer> napravl = new HashMap<String, Integer>();
	
	List<Kafedra> mKaf;

}
