package com.gcl.myclock;


import com.gcl.myclock.R;
import com.gcl.myclock.tools.DataCenter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class ActivityWelcomeSetUp extends Activity {

	private boolean mIsFirstRun = false;
	private DoHandler mHandler;
	private static final String FILE_NAME = "servey";
	private static final int LOADFINISH = 0;
	private static final int GO_HOME = 1;
	private static final int GO_HELP_TIPS = 2;
	private static final long INTERVAL_TIME = 500;
	private DataCenter mData;
	private ClockApp mApp;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_my_app);
		ImageView img = new ImageView(this);
		img.setBackgroundResource(R.drawable.welcome);
		setContentView(img);
		SharedPreferences sharepreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
		mIsFirstRun = sharepreferences.getBoolean("isFirstRun", true);
		mHandler = new DoHandler();
		mApp = (ClockApp)getApplication();
		mData = mApp.getData();
		new DoLoadClock().start();
//		init();
	}
	
	
	
	private void init()
	{
//		SharedPreferences sharepreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
//		mIsFirstRun = sharepreferences.getBoolean("isFirstRun", true);
//		mHandler = new DoHandler();
//		mApp = (ClockApp)getApplication();
//		mData = mApp.getData();
		if(mIsFirstRun){
			mHandler.sendEmptyMessage(GO_HELP_TIPS);
		}
		else{
			mHandler.sendEmptyMessage(GO_HOME);
		}
	}
	
	private void goHome(){
		Intent intent = new Intent(ActivityWelcomeSetUp.this,ActivityMyClock.class);
		startActivity(intent);
		finish();
	}
	
	private void goHelpTips(){
		Intent intent = new Intent(ActivityWelcomeSetUp.this,ActivityHelpTips.class);
		startActivity(intent);
		finish();
	}
	
	@SuppressLint("HandlerLeak")
	class DoHandler extends Handler{

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch(msg.what){
			case LOADFINISH:
				init();
				break;
			case GO_HOME:
				goHome();
				break;
			case GO_HELP_TIPS:
				goHelpTips();
				break;
			}
		}
		
	}
	
	class DoLoadClock extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			mData.LoadAllClocks();
			mHandler.sendEmptyMessage(LOADFINISH);
			
		}
		
	}

}
