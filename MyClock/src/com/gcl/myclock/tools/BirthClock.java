package com.gcl.myclock.tools;

public class BirthClock extends Clock{
//	public String mStatus;
//	public String mTime;
	public String mDay;
//	public String mMusic;
	public String mVibrate;
//	public String mLabel;
	
	public BirthClock(String addingtime,String status,String time,String day,String label,String music,String vibrate){
		super(CType.CBirth);
		mAddingTime = addingtime;
		mStatus = status;
		mTime = time;
		mMusic = music;
		mVibrate = vibrate;
		mDay = day;
		mLabel = label;
				
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "addingtime: " + mAddingTime + "status: " + mStatus + " day: " + mDay + " time: " + mTime + " label: " + mLabel + " music : " + mMusic +
				" vibrate: " + mVibrate + " type: " + mType;
	}
	

}
