package com.guiiii.diplom.uchchast;

import com.guiiii.diplom.koefandenums.Factors;
import com.guiiii.diplom.koefandenums.Occupations;
import com.guiiii.diplom.koefandenums.Occupations.Curse;

public abstract class Employment {

    protected float mStuff;
    protected float mKoef;
    protected String mName;
    protected String mKafedra;
    protected String mNapravlenie;
    protected float mCredits;
    protected int mContingent;
    
    protected Occupations.Curse mCurse;

    public Employment(String name, String kaf, String napr,
            float credit, int contingent, Curse curs) {
        mName = name;
        mKafedra = kaf;
        mNapravlenie = napr;
        mCredits = credit;
        mContingent = contingent;
        mCurse = curs;
    }

    abstract void calculateFactor(Factors factors);

    public int getContingent() {
        return mContingent;
    }
    public String getKafedra() {
        return mKafedra;
    }

    public float getKoef() {
        return mKoef;
    }
    public String getName() {
        return mName;
    }
    public String getNapr() {
        return mNapravlenie;
    }

    public float getStuff() {
        return mStuff;
    }

    public void setStuff(float stuff) {
        mStuff = stuff;
    }
    
    public Occupations.Curse getCurse() {
        return mCurse;
    }
    
    public float getCredit() {
        return mCredits;
    }
    
    
}
