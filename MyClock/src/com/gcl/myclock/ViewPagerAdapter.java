package com.gcl.myclock;

import java.util.List;

import com.gcl.myclock.R;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ViewPagerAdapter extends PagerAdapter{

	private List<View> mViews;
	private Activity mActivity;
	private static final String FILE_NAME = "servey";
	private static final String TAG = "ViewPagerAdapter";
	
	public ViewPagerAdapter(List<View> views, Activity activity){
		mViews = views;
		mActivity = activity;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(mViews == null)
			return 0;
		return mViews.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(View container, int position) {
		// TODO Auto-generated method stub
		((ViewPager)container).addView(mViews.get(position));
		if(position == mViews.size() - 1){
			ImageView btnEnter = (ImageView)container.findViewById(R.id.tip_three_button_enter);
			btnEnter.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Log.i(TAG, "------------------- in onClick ----------------");
					setGuided();
					goHome();
				}
				
			});
			
		}
		return mViews.get(position);
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		((ViewPager)container).removeView(mViews.get(position));
	}
	
	private void setGuided(){
		SharedPreferences pref = mActivity.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
		Editor edt = pref.edit();
		edt.putBoolean("isFirstRun", false);
		edt.commit();
	}
	
	private void goHome(){
		
		Intent intent = new Intent(mActivity, ActivityMyClock.class);
		mActivity.startActivity(intent);
		mActivity.finish();
	}
	
	

}
