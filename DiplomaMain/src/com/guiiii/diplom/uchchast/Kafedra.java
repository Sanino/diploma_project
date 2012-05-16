package com.guiiii.diplom.uchchast;

public class Kafedra {
    private final String mKafedraName;

    private final int mVstup;
    private final int mAsp;
    private final int mDoc;
    private final int mStag;
    
    private float mVstupStuff;
    private float mAspStuff;
    private float mDocStuff;
    private float mStagStuff;
    

    public Kafedra(String name, int vstup, int asp, int doc, int stag) {
        mKafedraName = name;
        mVstup = vstup;
        mAsp = asp;
        mDoc = doc;
        mStag = stag;
    }
    
    public void setVstupStuff(float stuff) {
        mVstupStuff = stuff;
    }
    
    public float getVstupStuff() {return mVstupStuff;}
    
    public float getAspStuff() {return mAspStuff;}
    
    public float getDocStuff() {return mDocStuff;}
    
    public float getStagStuff() {return mStagStuff;}
    
    public void setAspStuff(float stuff) {
        mAspStuff = stuff;
    }
    
    public void setDocStuff (float stuff) {
        mDocStuff = stuff;
    }
    
    public void setStagStuff (float stuff) {
        mStagStuff = stuff;
    }

    public int getAsp() {
        return mAsp;
    }

    public int getDoc() {
        return mDoc;
    }

    public String getKafedraName() {
        return mKafedraName;
    }

    public int getStag() {
        return mStag;
    }

    public int getVstup() {
        return mVstup;
    }
}
