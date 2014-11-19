package com.gcl.myclock;

import com.gcl.myclock.tools.DataCenter;
import com.gcl.myclock.tools.OpenDBHelper;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

public class ClockApp extends Application{
	
	private DataCenter mData;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mData = new DataCenter(getApplicationContext());
	}
	
	public DataCenter getData(){
		
		return mData;		
	}
	
}
