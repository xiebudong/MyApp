package com.gcl.myclock.tools;

public class GetUpClock extends Clock{
//	public String mStatus;
//	public String mTime;
//	public String mLabel;
	public String mRepeat;
//	public String mMusic;
	public String mVibrate;
	public String mSleepTime;
	
	public GetUpClock(String addingtime,String status,String time,String label,String repeat,String music,String vibrate,String sleeptime){
		super(CType.CGetUp);
		mAddingTime = addingtime;
		mStatus = status;
		mTime = time;
		mLabel = label;
		mRepeat = repeat;
		mMusic = music;
		mVibrate = vibrate;
		mSleepTime = sleeptime;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "addingtime: " + mAddingTime + "status: " + mStatus + " time: " + mTime + " label: " + mLabel + " repeat: " + mRepeat + " music : " + 
				mMusic + " vibrate: " + mVibrate + " sleeptime: " + mSleepTime + " type: " + mType;
	}

}
