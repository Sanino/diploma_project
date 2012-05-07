package com.guiiii.diplom.uchchast;

import com.guiiii.diplom.koefandenums.Factors;
import com.guiiii.diplom.koefandenums.Occupations;
import com.guiiii.diplom.koefandenums.Occupations.StudingForm;

public class OtherWork extends Employment {

	public OtherWork(String name, String kaf, String napr, StudingForm studyFormOcc,
			float credit, int contingent, Occupations.MustOtherWork work) {
		
		super(name,kaf,napr,studyFormOcc,credit,contingent);
		
		mWork = work;
	}
	
	@Override
	void calculateFactor(Factors factors) {
		mKoef = mCredits * factors.getFactorOtherWorks(mWork) *  mContingent;
	}
	
	private Occupations.MustOtherWork mWork;
}
