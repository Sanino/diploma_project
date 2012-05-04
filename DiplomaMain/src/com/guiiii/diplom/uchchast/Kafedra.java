package com.guiiii.diplom.uchchast;

public class Kafedra {
	public Kafedra(String name, int vstup, int asp, int doc, int stag) {
		mKafedraName = name;
		mVstup = vstup;
		mAsp = asp;
		mDoc = doc;
		mStag = stag;
	}
	
	public int getVstup() {
		return mVstup;
	}
	
	public int getAsp() {
		return mAsp;
	}
	
	public int getDoc() {
		return mDoc;
	}
	
	public int getStag() {
		return mStag;
	}
	
	public String getKafedraName() {
		return mKafedraName;
	}
	
	private String mKafedraName;
	private int mVstup;
	private int mAsp;
	private int mDoc;
	private int mStag;
}
