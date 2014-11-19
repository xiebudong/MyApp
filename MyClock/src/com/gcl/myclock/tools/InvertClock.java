package com.gcl.myclock.tools;

public class InvertClock extends Clock{
//	public String mStatus;
//	public String mTime;
//	public String mLabel;
//	public String mMusic;
	
	public InvertClock(String addingtime,String status,String time,String label,String music){
		super(CType.CInvert);
		mAddingTime = addingtime;
		mStatus = status;
		mTime = time;
		mLabel = label;
		mMusic = music;
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "addingtime: " + mAddingTime +"status: " + mStatus + " time: " + mTime + " label: " + mLabel + " music : " + 
				mMusic + " type: " + mType;
	}
}
