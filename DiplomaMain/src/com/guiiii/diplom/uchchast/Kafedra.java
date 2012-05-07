package com.guiiii.diplom.uchchast;

public class Kafedra {
    private final String mKafedraName;

    private final int mVstup;

    private final int mAsp;

    private final int mDoc;

    private final int mStag;

    public Kafedra(String name, int vstup, int asp, int doc, int stag) {
        mKafedraName = name;
        mVstup = vstup;
        mAsp = asp;
        mDoc = doc;
        mStag = stag;
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
