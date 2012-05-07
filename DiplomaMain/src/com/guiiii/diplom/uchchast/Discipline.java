package com.guiiii.diplom.uchchast;

import com.guiiii.diplom.koefandenums.Factors;
import com.guiiii.diplom.koefandenums.Occupations;
import com.guiiii.diplom.koefandenums.Occupations.OtherDisciplineWork;
import com.guiiii.diplom.koefandenums.Occupations.StudingForm;

public class Discipline extends Employment {

    private final float mLectionTimeWeek;
    private final float mLaboratoriesTimeWeek;
    private final float mPracticalTimeWeek;
    private final float mSeminarTimeWeek;

    private final Occupations.Curse mCurse;
    private final Occupations.Lection mLection;

    public Discipline(String name, String kaf, String napr,
            StudingForm studyForm, float credits, int contingent,
            StudyTiming st, Occupations.Curse curse, Occupations.Lection lection) {
        super(name, napr, kaf, studyForm, credits, contingent);
        mLectionTimeWeek = st.getLectionTime();
        mLaboratoriesTimeWeek = st.getLabTime();
        mPracticalTimeWeek = st.getPracticalTime();
        mSeminarTimeWeek = st.getSemionarTime();
        mCurse = curse;
        mLection = lection;
    }

    @Override
    void calculateFactor(Factors factors) {
        float kjk = ((mLectionTimeWeek * factors.getFactorKL(mLection))
                + (mLaboratoriesTimeWeek * factors
                        .getFactorLbPrS(OtherDisciplineWork.LABWORK))
                + (mPracticalTimeWeek * factors
                        .getFactorLbPrS(OtherDisciplineWork.PRACTICWORK)) + (mSeminarTimeWeek * factors
                .getFactorLbPrS(OtherDisciplineWork.SEMINARWORKS)));
        kjk /= (mLectionTimeWeek + mLaboratoriesTimeWeek + mPracticalTimeWeek + mSeminarTimeWeek);

        mKoef = ((1.44f * mCredits * kjk * factors.getFactorKN(mCurse,
                mStudyForm))
                + (0.2f * factors.getFactorKN(mCurse, mStudyForm))
                + (0.33f * mCredits)
                + (0.086f * mCredits * factors.getFactorKN(mCurse, mStudyForm)) + 0.5f)
                * mContingent * factors.getFactorKM(mLection);
    }
}
