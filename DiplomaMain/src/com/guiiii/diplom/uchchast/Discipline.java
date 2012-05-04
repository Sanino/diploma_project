package com.guiiii.diplom.uchchast;

import com.guiiii.diplom.koefandenums.Occupations;

public class Discipline extends Employment {
	
	public Discipline(String name, String nap, String kaf,
			float credits, int contingent, StudyTiming st, OccupationsTrain ot) {
		mName = name;
		
		mNapravlenie = nap;
		mKafedra     = kaf;
		mCredits     = credits;
		mContingent  = contingent;
		
		mLectionTimeWeek = st.getLectionTime();
		mLaboratoriesTimeWeek = st.getLabTime();
		mPracticalTimeWeek = st.getPracticalTime();
		mSeminarTimeWeek = st.getSemionarTime();
		
		mCurse = ot.getCurse();
		mLection = ot.getLection();
		mStudingForm = ot.getStudForm();
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
	
	private String mName;
	
	private String mNapravlenie;
	private String     mKafedra;
	
	private float mCredits;
	private int mContingent;
	
	private float mLectionTimeWeek;
	private float mLaboratoriesTimeWeek;
	private float mPracticalTimeWeek;
	private float mSeminarTimeWeek;

	private Occupations.Curse       mCurse;
	private Occupations.Lection     mLection;
	private Occupations.StudingForm mStudingForm;
	
	private float kLaboriousness;
	private float kClassType;
	private float kCourseType;
	
	private float kLection;
	private float kLaboratories;
	private float kPractical;
	private float kSeminar;
	private float kFactor;
	
	private float mShtat;
}
