package com.guiiii.diplom.util;

import java.util.List;

import com.guiiii.diplom.uchchast.Discipline;
import com.guiiii.diplom.uchchast.Kafedra;
import com.guiiii.diplom.uchchast.OtherWork;

public abstract class MainFrameListener {
    public abstract void calculate();

    public abstract void setFactors();

    public abstract void setKafedraVolumes(List<Kafedra> kaf);

    public abstract void setStudingPlan(List<Discipline> ds, List<OtherWork> ow);

    public abstract void setStuff(float stuff);
}
