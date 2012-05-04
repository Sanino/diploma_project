package com.guiiii.diplom.koefandenums;

public class Factors {
	

	public Factors(FactorsHelper fh){
		 mDayliFirst      = fh.dayliFirst;
		 mDayliSecond     = fh.dayliSecond;
		 mDayliThird      = fh.dayliThird;
		 mDayliFourth     = fh.dayliFourth;
		 mDayliSpecialist = fh.dayliSpecialist;
		 mDayliMagistr    = fh.dayliMagistr;
		
		 mZaochFirst      = fh.zaochFirst;
		 mZaochSecond     = fh.zaochSecond;
		 mZaochThird      = fh.zaochThird;
		 mZaochFourth     = fh.zaochFourth;
		 mZaochSpecialist = fh.zaochSpecialist;
		
		 mLectionZO = fh.lectionZO;
		 mLectionPS = fh.lectionPS;
		 mLectionPV = fh.lectionPV;
		 mLectionSP = fh.lectionSP;
		 mLectionMP = fh.lectionMP;
		
		 mLaboratories = fh.laboratories;
		 mPractical    = fh.practical;//for test result
		 mSeminar      = fh.seminar;
		
		 mClassTypeFirst  = fh.classTypeFirst;
		 mClassTypeSecond = fh.classTypeSecond;
		
		 mKursWorkFirst               = fh.kursWorkFirst;
		 mKursWorkSecond              = fh.kursWorkSecond;
		 mKursProjectFirst            = fh.kursProjectFirst;
		 mKursProjectSecond           = fh.kursProjectSecond;
		 mStudingPructic              = fh.studingPructic;
		 mWorkingPructic              = fh.workingPructic;
		 mUnderGradupterPractic       = fh.underGruduptedPractic;
		 mStateExam                   = fh.stateExam;
		 mDiplomaGuide                = fh.diplomaGuide;
		 mDiplomaEcomomicConsultation = fh.diplomaEcomomicConsultation;
		 mDiplomaHealthSafe           = fh.diplomaHealthSafe;
		 
		 mVstup = fh.vstup;
		 mAsp   = fh.asp;
		 mDoc   = fh.doc;
		 mStag  = fh.stag;
	}
	
	public float getFactorKN(Occupations.Curse curse,
			Occupations.StudingForm studingForm){
		switch(curse){
		case FIRST:
			if(studingForm == Occupations.StudingForm.DAILY){
				return mDayliFirst;
			} else {
				return mZaochFirst;
			}
		case SECOND:
			if(studingForm == Occupations.StudingForm.DAILY){
				return mDayliSecond;
			} else {
				return mZaochSecond;
			}
		case THIRD:
			if(studingForm == Occupations.StudingForm.DAILY){
				return mDayliThird;
			} else {
				return mZaochThird;
			}
		case FOURTH:
			if(studingForm == Occupations.StudingForm.DAILY){
				return mDayliFourth;
			} else {
				return mZaochFourth;
			}
		case SPECIALIST:
			if(studingForm == Occupations.StudingForm.DAILY){
				return mDayliSpecialist;
			} else {
				return mZaochSpecialist;
			}
		case MAGISTR:
			return mDayliMagistr;
		}
		return -1;
	}
	
	public float getFactorKL(Occupations.Lection lectionType){
		switch(lectionType){
		case ZO:
			return mLectionZO;
		case PS:
			return mLectionPS;
		case PV:
			return mLectionPV;
		case SP:
			return mLectionSP;
		case MP:
			return mLectionMP;
		}
		return -1;
	}

	public float getFactorLbPrS(Occupations.OtherDisciplineWork otherWork){
		switch(otherWork){
		case LABWORK:
			return mLaboratories;
		case PRACTICWORK:
			return mPractical;
		case SEMINARWORKS:
			return mSeminar;
		}
		return -1;
	}

	public float getFactorKM(Occupations.Lection classType){
		switch(classType){
		case ZO:
		case PS:
			return mClassTypeFirst;
		case PV:
		case SP:
		case MP:
			return mClassTypeSecond;
		}
		return -1;
	}
	
	public float getFactorOtherWorks(Occupations.MustOtherWork otherWork){
		switch(otherWork){
		case CURSEWORK_ZO_FD:
			return mKursWorkFirst;
		case CURSEWORK_PS_PV_SP_MP:
			return mKursWorkSecond;
		case CURSEPROJECT_Z0_FD:
			return mKursProjectFirst;
		case CURSEPROJECT_PS_PV_SP_MP:
			return mKursProjectSecond;
		case STADYPRACTIC:
			return mStudingPructic;
		case WORKPRACTIC:
			return mWorkingPructic;
		case UNDERGRADUTEPRACTIC:
			return mUnderGradupterPractic;
		case STATEEXAM:
			return mStateExam;
		case DIPLOMA_GUIDE:
			return mDiplomaGuide;
		case DIPLOMA_ECONOMIC_CONSULTATION:
			return mDiplomaEcomomicConsultation;
		case DIPLOMA_HEALTH_SAFE:
			return mDiplomaHealthSafe;
		}
		return -1;
	}
	
	public float getKafFactors(Occupations.KafFactors kafFactors){
		switch(kafFactors){
		case VSTUP:
			return mVstup;
		case ASP:
			return mAsp;
		case DOC:
			return mDoc;
		case STAG:
			return mStag;			
		}
		return -1;
	}
	
	private float mDayliFirst;
	private float mDayliSecond;
	private float mDayliThird;
	private float mDayliFourth;
	private float mDayliSpecialist;
	private float mDayliMagistr;
	
	private float mZaochFirst;
	private float mZaochSecond;
	private float mZaochThird;
	private float mZaochFourth;
	private float mZaochSpecialist;
	
	private float mLectionZO;
	private float mLectionPS;
	private float mLectionPV;
	private float mLectionSP;
	private float mLectionMP;
	
	private float mLaboratories;
	private float mPractical;//for test result
	private float mSeminar;
	
	private float mClassTypeFirst;
	private float mClassTypeSecond;
	
	private float mKursWorkFirst;
	private float mKursWorkSecond;
	private float mKursProjectFirst;
	private float mKursProjectSecond;
	private float mStudingPructic;
	private float mWorkingPructic;
	private float mUnderGradupterPractic;
	private float mStateExam;
	private float mDiplomaGuide;
	private float mDiplomaEcomomicConsultation;
	private float mDiplomaHealthSafe;
	
	private float mVstup;
	private float mAsp;
	private float mDoc;
	private float mStag;
}

