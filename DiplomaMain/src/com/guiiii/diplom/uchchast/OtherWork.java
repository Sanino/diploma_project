package com.guiiii.diplom.uchchast;

import com.guiiii.diplom.koefandenums.Occupations;
import com.guiiii.diplom.koefandenums.Occupations.StudingForm;

public class OtherWork extends Employment {

	public OtherWork(String name, String kaf, String napr, StudingForm studyFormOcc, float credit, int contingent,
			Occupations.MustOtherWork work) {
		mName = name;
		mKafedra = kaf;
		mNapravlenie = napr;
		mStudyForm = studyFormOcc;
		mCredit = credit;
		mContingent = contingent;
		mWork = work;
	}
	
	public String getName() {
		return mName;
	}
	
	@Override
	void calculateFactor() {
		// TODO Auto-generated method stub

	}

	@Override
	void calculateStuff() {
		// TODO Auto-generated method stub

	}
	
	public String getKafedra() {
		return mKafedra;
	}
	
	public String getNapr() {
		return mNapravlenie;
	}
	
	public int getContingent() {
		return mContingent;
	}
	
	public StudingForm getStudyForm() {
				return mStudyForm;
	}
	
	private String mName;
	private String mKafedra;
	private String mNapravlenie;
	
	private float mCredit;
	private int   mContingent;
	
	private Occupations.MustOtherWork mWork;
	private StudingForm mStudyForm;
	
	private float       kLaboriousness;
	private float       kClassType;
	private float       kFactor;
	
	private float mShtat;

	public StudingForm getStudingForm() {
		// TODO Auto-generated method stub
		return mStudyForm;
	}

}
