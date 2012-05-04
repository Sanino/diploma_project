package com.guiiii.diplom.uchchast;

import com.guiiii.diplom.koefandenums.Occupations;

public class OccupationsTrain {
	public OccupationsTrain(Occupations.Curse curse, Occupations.Lection lection,
			Occupations.StudingForm studForm) {
		mCurse = curse;
		mLection = lection;
		mStudingForm = studForm;
	}
	
	public Occupations.Curse getCurse() {
		return mCurse;
	}
	
	public Occupations.Lection getLection() {
		return mLection;
	}
	
	public Occupations.StudingForm getStudForm() {
		return mStudingForm;
	}
	
	private Occupations.Curse       mCurse;
	private Occupations.Lection     mLection;
	private Occupations.StudingForm mStudingForm;
}
