package com.guiiii.diplom.uchchast;

import com.guiiii.diplom.koefandenums.Factors;
import com.guiiii.diplom.koefandenums.Occupations;
import com.guiiii.diplom.koefandenums.Occupations.Curse;

public class OtherWork extends Employment {

    private final Occupations.MustOtherWork mWork;

    public OtherWork(String name, String kaf, String napr, float credit,
            int contingent, Curse curs, Occupations.MustOtherWork work) {

        super(name, kaf, napr, credit, contingent, curs);

        mWork = work;
    }

    @Override
    void calculateFactor(Factors factors) {
        float km = 0;
        switch (mCurse) {
        case FIRST:
        case SECOND:
        case THIRD:
        case FOURTH:
            km = factors.getFactorKM(Occupations.Lection.ZO);
            break;
        case MAGISTR:
        case SPECIALIST:
            km = factors.getFactorKM(Occupations.Lection.MP);
            break;
        }
        mKoef = mCredits * factors.getFactorOtherWorks(mWork) * mContingent * km;
    }
}
