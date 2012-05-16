package com.guiiii.diplom.uchchast;

import com.guiiii.diplom.koefandenums.Factors;
import com.guiiii.diplom.koefandenums.Occupations;
import com.guiiii.diplom.koefandenums.Occupations.StudingForm;

public class DisciplineZaoch extends Employment {


    public DisciplineZaoch(String name, String kaf, String napr,
            float credits, int contingent, StudyTiming st,
            Occupations.Curse curse, Occupations.Lection lection) {
        super(name, napr, kaf, credits, contingent, curse);
    }

    @Override
    void calculateFactor(Factors factors) {
        // TODO Auto-generated method stub
    }
    
    void calculateFactor(Factors factors, Discipline d) {
        // TODO Auto-generated method stub
        mKoef = d.getKoef() * ((mContingent * factors.getFactorKN(mCurse, StudingForm.ZAOCH)) /
                (d.getContingent() * factors.getFactorKN(d.getCurse(), StudingForm.DAILY)));
    }

}
