package com.guiiii.diplom.uchchast;

import com.guiiii.diplom.koefandenums.Factors;
import com.guiiii.diplom.koefandenums.Occupations.StudingForm;

public abstract class Employment {
	
	public Employment(String name, String kaf, String napr, StudingForm studyFormOcc, float credit, int contingent) {
		mName = name;
		mKafedra = kaf;
		mNapravlenie = napr;
		mStudyForm = studyFormOcc;
		mCredits = credit;
		mContingent = contingent;
	}
	abstract void calculateFactor(Factors factors);
	
	public void setStuff(float stuff) {
		mStuff = stuff;
	}
	
	public float getStuff(){
		return mStuff;
	}
	
	public float getKoef(){
		return mKoef;
	}
	
	public String getName() {
		return mName;
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
	
	protected float mStuff;
	protected float mKoef;
	
	protected String mName;
	protected String mKafedra;
	protected String mNapravlenie;
	
	protected float mCredits;
	protected int mContingent;
	
	protected StudingForm mStudyForm;	
}
