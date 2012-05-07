package com.guiiii.diplom.uchchast;

public class StudyTiming {
    private final float mLectionTime;

    private final float mLabTime;

    private final float mPracticalTime;

    private final float mSeminarTime;

    public StudyTiming(float lection, float laboratories, float practical,
            float seminar) {
        mLectionTime = lection;
        mLabTime = laboratories;
        mPracticalTime = practical;
        mSeminarTime = seminar;
    }

    public float getLabTime() {
        return mLabTime;
    }

    public float getLectionTime() {
        return mLectionTime;
    }

    public float getPracticalTime() {
        return mPracticalTime;
    }

    public float getSemionarTime() {
        return mSeminarTime;
    }
}
