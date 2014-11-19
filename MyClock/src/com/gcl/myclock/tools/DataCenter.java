package com.gcl.myclock.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.content.Context;

public class DataCenter {
	
	private Context mContext;
	private OpenDBHelper mOpenDBHelper;
	private List<Clock> mClocks = new ArrayList<Clock>();
	
	public DataCenter(Context context){
		mContext = context;
		mOpenDBHelper = new OpenDBHelper(context);
	}
	
	public OpenDBHelper getDBHelper(){
		
		return mOpenDBHelper;
	}
	
	public void LoadAllClocks(){
		List<Clock> allclocks = new ArrayList<Clock>();
		List<GetUpClock> getupclocks = mOpenDBHelper.loadAllGetUpClocks();
		List<BirthClock> birthclocks = mOpenDBHelper.loadAllBirthClocks();
		List<InvertClock> invertclock = mOpenDBHelper.loadAllInvertClocks();
		allclocks.addAll(getupclocks);
		allclocks.addAll(birthclocks);
		allclocks.addAll(invertclock);
		Collections.sort(allclocks, new Comparator<Clock>(){

			@Override
			public int compare(Clock lhs, Clock rhs) {
				// TODO Auto-generated method stub
				return  lhs.compareTo(rhs);
			}
			
		});
		
		
		mClocks.addAll(allclocks);
	}
	
	public List<Clock> getAllClocks(){
		
		return mClocks;
	}
	
	public void addNewGetUpClock(GetUpClock clock){
		
		mClocks.add(clock);
		mOpenDBHelper.addNewGetUpClock(clock);
		
	}
	
	public void updateGetUpClock(GetUpClock oldclock,GetUpClock newclock){
		mOpenDBHelper.updateGetUpClock(oldclock, newclock);
		for(Clock clock:mClocks){
			if(clock.mAddingTime.equals(oldclock.mAddingTime) && clock instanceof GetUpClock){
				GetUpClock getupclock = (GetUpClock)clock;
				getupclock.mStatus = newclock.mStatus;
				getupclock.mTime = newclock.mTime;
				getupclock.mLabel = newclock.mLabel;
				getupclock.mRepeat = newclock.mRepeat;
				getupclock.mMusic = newclock.mMusic;
				getupclock.mVibrate = newclock.mVibrate;
				getupclock.mSleepTime = newclock.mSleepTime;
			}
		}
	}
	
	public void deleteGetUpClock(GetUpClock clock){
		mOpenDBHelper.removeGetUpClock(clock);
		for(Clock c:mClocks){
			if(c.mAddingTime.equals(clock.mAddingTime) && c instanceof GetUpClock){
				mClocks.remove(c);
			}
		}
	}
	
	public void addNewBirthClock(BirthClock clock){
		
		mClocks.add(clock);
		mOpenDBHelper.addNewBirthClock(clock);
		
	}
	
	public void updateBirthClock(BirthClock oldclock,BirthClock newclock){
		mOpenDBHelper.updateBirthClock(oldclock, newclock);
		for(Clock clock:mClocks){
			if(clock.mAddingTime.equals(oldclock.mAddingTime) && clock instanceof BirthClock){
				BirthClock birthclock = (BirthClock)clock;
				birthclock.mStatus = newclock.mStatus;
				birthclock.mDay = newclock.mDay;
				birthclock.mTime = newclock.mTime;
				birthclock.mLabel = newclock.mLabel;
				birthclock.mMusic = newclock.mMusic;
				birthclock.mVibrate = newclock.mVibrate;

			}
		}
	}

	public void deleteBirthClock(BirthClock clock){
		mOpenDBHelper.removeBirthClock(clock);
		for(Clock c:mClocks){
			if(c.mAddingTime.equals(clock.mAddingTime) && c instanceof BirthClock){
				mClocks.remove(c);
			}
		}
	}
	
	public void addNewInvertClock(InvertClock clock){
		
		mClocks.add(clock);
		mOpenDBHelper.addNewInvertClock(clock);
		
	}
	
	public void updateInvertClock(InvertClock oldclock,InvertClock newclock){
		mOpenDBHelper.updateInvertClock(oldclock, newclock);
		for(Clock clock:mClocks){
			if(clock.mAddingTime.equals(oldclock.mAddingTime) && clock instanceof InvertClock){
				InvertClock invertclock = (InvertClock)clock;
				invertclock.mStatus = newclock.mStatus;
				invertclock.mTime = newclock.mTime;
				invertclock.mLabel = newclock.mLabel;
				invertclock.mMusic = newclock.mMusic;

			}
		}
	}
	
	public void deleteInvertClock(InvertClock clock){
		mOpenDBHelper.removeInvertClock(clock);
		for(Clock c:mClocks){
			if(c.mAddingTime.equals(clock.mAddingTime) && c instanceof InvertClock){
				mClocks.remove(c);
			}
		}
	}
}
