package com.gcl.myclock;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ActivityMenu extends Activity implements OnClickListener{
	private static final String LOG = "ActivityMenu";
	private LinearLayout mBackLayout;
	private LinearLayout mSmartSettingCont;
	private LinearLayout mSoundSettingCont;
	private LinearLayout mAboutCont;
	private ImageView mImgSmartSetting;
	private ImageView mImgSoundSetting;
	private ImageView mImgAboutClock;
	private ImageView mMenuBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		Log.i(LOG, "----------in onCreate--------------");
		mBackLayout = (LinearLayout)findViewById(R.id.layout_menu_back);
		mImgSmartSetting = (ImageView)findViewById(R.id.img_menu_smart_settings);
		mImgSoundSetting = (ImageView)findViewById(R.id.img_menu_sound_settings);
		mImgAboutClock = (ImageView)findViewById(R.id.img_menu_about_clock);
		mMenuBack = (ImageView)findViewById(R.id.btn_menu_back);
		mSmartSettingCont = (LinearLayout)findViewById(R.id.menu_smart_content);
		mSoundSettingCont = (LinearLayout)findViewById(R.id.menu_sound_content);
		mAboutCont = (LinearLayout)findViewById(R.id.menu_about_clock_content);
		mBackLayout.setOnClickListener(this);
		mImgSmartSetting.setOnClickListener(this);
		mImgSoundSetting.setOnClickListener(this);
		mImgAboutClock.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.i(LOG, "----------in onClick--------------");
		switch(v.getId()){
		case R.id.layout_menu_back:
			mMenuBack.setPressed(true);
			finish();
			break;
		case R.id.img_menu_smart_settings:
			if(mImgSmartSetting.isSelected()){
				mImgSmartSetting.setSelected(false);
				mSmartSettingCont.setVisibility(View.GONE);				
			}
			else{
				mImgSmartSetting.setSelected(true);
				mSmartSettingCont.setVisibility(View.VISIBLE);	
			}
			break;
		case R.id.img_menu_sound_settings:
			if(mImgSoundSetting.isSelected()){
				mImgSoundSetting.setSelected(false);
				mSoundSettingCont.setVisibility(View.GONE);				
			}
			else{
				mImgSoundSetting.setSelected(true);
				mSoundSettingCont.setVisibility(View.VISIBLE);	
			}
			break;
		case R.id.img_menu_about_clock:
			if(mImgAboutClock.isSelected()){
				mImgAboutClock.setSelected(false);
				mAboutCont.setVisibility(View.GONE);				
			}
			else{
				mImgAboutClock.setSelected(true);
				mAboutCont.setVisibility(View.VISIBLE);	
			}
			break;
		}
	}

}
