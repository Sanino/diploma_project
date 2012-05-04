package com.guiiii.diplom.util;

import java.util.List;

import com.guiiii.diplom.uchchast.Discipline;
import com.guiiii.diplom.uchchast.OtherWork;

public abstract class MainFrameListener {
	public abstract void setFactors();
	public abstract void setStudingPlan(List<Discipline> ds, List<OtherWork> ow);
	public abstract void setStuff();
	public abstract void calculate();
}
