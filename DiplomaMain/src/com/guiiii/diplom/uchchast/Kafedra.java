package com.guiiii.diplom.uchchast;

public class Kafedra {
	public Kafedra(String name) {
		mKafedraName = name;
	}
	
	public String getKafedra() {
		return mKafedraName;
	}
	
	public void appendCont(int con){
		mContingent += con;
	}
	
	public int getContingent() {
		return mContingent;
	}
	
	public void setVstup(int vstup){
		mVstup = vstup;
	}
	
	public void setAsp(int asp) {
		mAsp = asp;
	}
	
	public void setDoc(int doc) {
		mDoc = doc;
	}
	
	public void setStag(int stag) {
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
	
	@Override
	public boolean equals(Object other)
    {
        if(!super.equals(other)) return false;
        if (this == other) return true;
        if (other == null) return false;
        if(this.getClass() != other.getClass()) return false;
        Kafedra otherObj = (Kafedra)other;
        return this.mKafedraName.equals(otherObj.getKafedra());
    }
	
	@Override
    public int hashCode()
    {   
        return 76+133*mKafedraName.hashCode();
    }
	
	private String mKafedraName;
	private int mShtat;
	private int mContingent;
	private int mVstup;
	private int mAsp;
	private int mDoc;
	private int mStag;
}
