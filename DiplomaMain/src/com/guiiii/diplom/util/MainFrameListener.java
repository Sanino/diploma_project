package com.guiiii.diplom.util;

import java.util.List;

import com.guiiii.diplom.uchchast.Discipline;
import com.guiiii.diplom.uchchast.DisciplineZaoch;
import com.guiiii.diplom.uchchast.Kafedra;
import com.guiiii.diplom.uchchast.OtherWork;

public abstract class MainFrameListener {
    public abstract void calculate();

    public abstract void setFactors();

    public abstract void setKafedraVolumes(List<Kafedra> kaf);


    public abstract void setStuff(float stuff);

    public void setStudingPlan(List<Discipline> ds,
            List<DisciplineZaoch> zaoch, List<OtherWork> ow) {
        // TODO Auto-generated method stub
        
    }
}
