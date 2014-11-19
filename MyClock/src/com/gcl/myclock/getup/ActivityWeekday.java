package com.gcl.myclock.getup;

import com.gcl.myclock.R;
import com.gcl.myclock.tools.Config;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ActivityWeekday extends Activity implements OnClickListener{
	
	
	private static final String LOG = "ActivityWeekday";
	private Config mConfig;
	private RelativeLayout mMonLayout;
	private RelativeLayout mTuesLayout;
	private RelativeLayout mWedLayout;
	private RelativeLayout mThurLayout;
	private RelativeLayout mFriLayout;
	private RelativeLayout mSatuLayout;
	private RelativeLayout mSunLayout;
	
	private ImageView mMonImg;
	private ImageView mTuesImg;
	private ImageView mWedImg;
	private ImageView mThurImg;
	private ImageView mFriImg;
	private ImageView mSatuImg;
	private ImageView mSunImg;
	
	private String mMonImgStatus;
	private String mTuesImgStatus;
	private String mWedImgStatus;
	private String mThurImgStatus;
	private String mFriImgStatus;
	private String mSatuImgStatus;
	private String mSunImgStatus;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weekday_set);
		
		mConfig = Config.getConfig(this);
		
		mMonLayout = (RelativeLayout)findViewById(R.id.monday);
		mTuesLayout = (RelativeLayout)findViewById(R.id.tuesday);
		mWedLayout = (RelativeLayout)findViewById(R.id.wednesday);
		mThurLayout = (RelativeLayout)findViewById(R.id.thursday);
		mFriLayout = (RelativeLayout)findViewById(R.id.friday);
		mSatuLayout = (RelativeLayout)findViewById(R.id.saturday);
		mSunLayout = (RelativeLayout)findViewById(R.id.sunday);
		
		mMonLayout.setOnClickListener(this);
		mTuesLayout.setOnClickListener(this);
		mWedLayout.setOnClickListener(this);
		mThurLayout.setOnClickListener(this);
		mFriLayout.setOnClickListener(this);
		mSatuLayout.setOnClickListener(this);
		mSunLayout.setOnClickListener(this);
		
		mMonImg = (ImageView)findViewById(R.id.monday_img);
		mTuesImg = (ImageView)findViewById(R.id.tuesday_img);
		mWedImg = (ImageView)findViewById(R.id.wednesday_img);
		mThurImg = (ImageView)findViewById(R.id.thursday_img);
		mFriImg = (ImageView)findViewById(R.id.friday_img);
		mSatuImg = (ImageView)findViewById(R.id.saturday_img);
		mSunImg = (ImageView)findViewById(R.id.sunday_img);
		
		mMonImgStatus = mConfig.getString(Config.WEEKDAY_MONDAY, "true");
		mTuesImgStatus = mConfig.getString(Config.WEEKDAY_TUESDAY, "true");
		mWedImgStatus = mConfig.getString(Config.WEEKDAY_WEDNESDAY, "true");
		mThurImgStatus = mConfig.getString(Config.WEEKDAY_THURSDAY, "true");
		mFriImgStatus = mConfig.getString(Config.WEEKDAY_FRIDAY, "true");
		mSatuImgStatus = mConfig.getString(Config.WEEKDAY_SATUDAY, "false");
		mSunImgStatus = mConfig.getString(Config.WEEKDAY_SUNDAY, "false");
//		setAllStatus();
		
		setStatus(mMonImg,mMonImgStatus);
		setStatus(mTuesImg,mTuesImgStatus);
		setStatus(mWedImg,mWedImgStatus);
		setStatus(mThurImg,mThurImgStatus);
		setStatus(mFriImg,mFriImgStatus);
		setStatus(mSatuImg,mSatuImgStatus);
		setStatus(mSunImg,mSunImgStatus);
		Log.i(LOG, "mMonImgStatus : " + mMonImgStatus + " mTuesImgStatus: " + mTuesImgStatus + " mWedImgStatus: " + mWedImgStatus
				+ " mThurImgStatus : " + mThurImgStatus + " mFriImgStatus: " + mFriImgStatus+ " mSatuImgStatus : " + mSatuImgStatus
				+ " mSunImgStatus : " + mSunImgStatus
				);
//		mMonImg.setSelected(true);
//		mTuesImg.setSelected(true);
//		mWedImg.setSelected(true);
//		mThurImg.setSelected(true);
//		mFriImg.setSelected(true);
//		mSatuImg.setSelected(false);
//		mSunImg.setSelected(false);
		
		
	}

	private void setAllStatus(){
		
		if(mMonImgStatus.equals("true")){
			mMonImg.setSelected(true);
		}
		else{
			mMonImg.setSelected(false);
		}
		
		if(mTuesImgStatus.equals("true")){
			mTuesImg.setSelected(true);
		}
		else{
			mTuesImg.setSelected(false);
		}
		
		if(mWedImgStatus.equals("true")){
			mWedImg.setSelected(true);
		}
		else{
			mWedImg.setSelected(false);
		}
		
		if(mThurImgStatus.equals("true")){
			mThurImg.setSelected(true);
		}
		else{
			mThurImg.setSelected(false);
		}
		
		if(mFriImgStatus.equals("true")){
			mFriImg.setSelected(true);
		}
		else{
			mFriImg.setSelected(false);
		}
		
		if(mSatuImgStatus.equals("true")){
			mSatuImg.setSelected(true);
		}
		else{
			mSatuImg.setSelected(false);
		}
		
		if(mSunImgStatus.equals("true")){
			mSunImg.setSelected(true);
		}
		else{
			mSunImg.setSelected(false);
		}
		
	}
	
	
	private void setStatus(ImageView img,String status){
		if(status.equals("true")){
			img.setSelected(true);
		}
		else{
			img.setSelected(false);
		}
	}
	
	private void saveStatus(String key,String status){
		Log.i(LOG, "key : " + key + " status:" + status);
		mConfig.setConfig(key, status);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.monday:
			if(mMonImg.isSelected()){
				mMonImg.setSelected(false);
				saveStatus(Config.WEEKDAY_MONDAY,"false");
			}
			else{
				mMonImg.setSelected(true);
				saveStatus(Config.WEEKDAY_MONDAY,"true");
			}
			break;
		case R.id.tuesday:
			if(mTuesImg.isSelected()){
				mTuesImg.setSelected(false);
				saveStatus(Config.WEEKDAY_TUESDAY,"false");
			}
			else{
				mTuesImg.setSelected(true);
				saveStatus(Config.WEEKDAY_TUESDAY,"true");
			}
			break;
		case R.id.wednesday:
			if(mWedImg.isSelected()){
				mWedImg.setSelected(false);
				saveStatus(Config.WEEKDAY_WEDNESDAY,"false");
			}
			else{
				mWedImg.setSelected(true);
				saveStatus(Config.WEEKDAY_WEDNESDAY,"true");
			}
			break;
		case R.id.thursday:
			if(mThurImg.isSelected()){
				mThurImg.setSelected(false);
				saveStatus(Config.WEEKDAY_THURSDAY,"false");
			}
			else{
				mThurImg.setSelected(true);
				saveStatus(Config.WEEKDAY_THURSDAY,"true");
			}
			break;
		case R.id.friday:
			if(mFriImg.isSelected()){
				mFriImg.setSelected(false);
				saveStatus(Config.WEEKDAY_FRIDAY,"false");
			}
			else{
				mFriImg.setSelected(true);
				saveStatus(Config.WEEKDAY_FRIDAY,"true");
			}
			break;
		case R.id.saturday:
			if(mSatuImg.isSelected()){
				mSatuImg.setSelected(false);
				saveStatus(Config.WEEKDAY_SATUDAY,"false");
			}
			else{
				mSatuImg.setSelected(true);
				saveStatus(Config.WEEKDAY_SATUDAY,"true");
			}
			break;
		case R.id.sunday:
			if(mSunImg.isSelected()){
				mSunImg.setSelected(false);
				saveStatus(Config.WEEKDAY_SUNDAY,"false");
			}
			else{
				mSunImg.setSelected(true);
				saveStatus(Config.WEEKDAY_SUNDAY,"true");
			}
			break;
		}
	}

}
