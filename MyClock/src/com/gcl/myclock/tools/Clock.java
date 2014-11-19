package com.gcl.myclock.tools;

import android.widget.AnalogClock;

public class Clock implements Comparable<Object>{
	
	public String mStatus;
	public String mTime;
	public String mLabel;
	public String mMusic;
	public String mAddingTime;
	public CType mType;
	
	
	public enum CType{
		CGetUp,
		CBirth,
		CInvert
	}
	
	public Clock(CType type){
		mType = type;
	}

	@Override
	public int compareTo(Object another) {
		// TODO Auto-generated method stub
		if(this == another)
			return 0;
		else if(another != null &&another instanceof Clock){
			Clock c = (Clock)another;
			if(Long.parseLong(mAddingTime) <= Long.parseLong(c.mAddingTime)){
				return -1;
			}
			else{
				return 1;
			}
		}
		else{
			return -1;
		}
	}

}
