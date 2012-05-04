package com.guiiii.diplom.uchchast;

public class StudyTiming {
	public StudyTiming(float lection, float laboratories,
			float practical, float seminar){
		mLectionTime = lection;
		mLabTime = laboratories;
		mPracticalTime = practical;
		mSeminarTime  = seminar;
	}
	
	public float getLectionTime(){
		return mLectionTime;
	}
	
	public float getLabTime(){
		return mLabTime;
	}
	
	public float getPracticalTime() {
		return mPracticalTime;
	}
	
	public float getSemionarTime() {
		return mSeminarTime;
	}
	
	private float mLectionTime;
	private float mLabTime;
	private float mPracticalTime;
	private float mSeminarTime;
}
