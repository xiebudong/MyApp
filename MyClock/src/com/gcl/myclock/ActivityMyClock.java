package com.gcl.myclock;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ext.SatelliteMenu;
import android.view.ext.SatelliteMenuItem;
import android.widget.ImageView;
import android.view.ext.SatelliteMenu.SateliteClickedListener;


public class ActivityMyClock extends Activity implements OnClickListener{
	
	private static final String TAG = "ActivityMyClock";
	private ImageView mAddClockBtn;
	private ImageView mMenuBtn;
	private ImageView mRecordBtn;
	private SatelliteMenu mSateMenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i(TAG, "---------------- onCreate--------------");
		setContentView(R.layout.activity_my_clock);
		mAddClockBtn = (ImageView)findViewById(R.id.btn_add_clock);
		mMenuBtn = (ImageView)findViewById(R.id.btn_menu);
		mAddClockBtn.setOnClickListener(this);
		mMenuBtn.setOnClickListener(this);
		mSateMenu = (SatelliteMenu)findViewById(R.id.img_tools_pop_clock);
		mRecordBtn = (ImageView)findViewById(R.id.imgs_tools_record);
		mRecordBtn.setOnClickListener(this);
		List<SatelliteMenuItem> items = new ArrayList<SatelliteMenuItem>();
		items.add(new SatelliteMenuItem(1, R.drawable.empty));
		items.add(new SatelliteMenuItem(2, R.drawable.getup_clock_enter));
		items.add(new SatelliteMenuItem(3, R.drawable.invert_clock_enter));        
        items.add(new SatelliteMenuItem(4, R.drawable.birth_clock_enter));	
        mSateMenu.addItems(items);
        mSateMenu.setOnItemClickedListener(new SateliteClickedListener(){

			@Override
			public void eventOccured(int id) {
				// TODO Auto-generated method stub
				Log.i(TAG, "Clicked on " + id);
				Intent it = null;
				switch(id){
				case 2:
					it = new Intent(ActivityMyClock.this, ActivityGetUpClock.class);
					startActivity(it);
					break;
				case 3: 
					it = new Intent(ActivityMyClock.this, ActivityInvertClock.class);
					startActivity(it);
					break;
				case 4:
					it = new Intent(ActivityMyClock.this, ActivityBirthdayClock.class);
					startActivity(it);
					break;
				}
			}
        	
        });
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.i(TAG, "------------in onClick------------");
		switch(v.getId()){
		
		case R.id.btn_add_clock:
			
			break;
			
		case R.id.btn_menu:
			Intent it = new Intent(ActivityMyClock.this,ActivityMenu.class);
			startActivity(it);
			break;
		case R.id.imgs_tools_record:
			Log.i(TAG, "------------record------------");
			
		}
		
	}

}
