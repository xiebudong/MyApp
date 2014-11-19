package com.gcl.myclock;

import com.gcl.myclock.getup.ActivityWeekday;
import com.gcl.myclock.tools.VibratorUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

public class ActivityGetUpClock extends Activity implements OnClickListener{
	
	private static final String LOG = "ActivityGetUpClock";
	private LinearLayout mRepeatLayout;
	private ToggleButton mToggleBtn;
	private MyHandler mHandler;
	
	private static final int CACLE_VIBRATE = 0;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.getup_clock);
		mRepeatLayout = (LinearLayout)findViewById(R.id.getup_item_repeat_layout);
		mRepeatLayout.setOnClickListener(this);
		mToggleBtn = (ToggleButton)findViewById(R.id.getup_clock_ToggleButton);
		mToggleBtn.setOnClickListener(this);
		mHandler = new MyHandler();
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent it = null;
		switch(v.getId()){
		case R.id.getup_item_repeat_layout:
			it = new Intent(ActivityGetUpClock.this, ActivityWeekday.class);
			startActivity(it);
			break;
		case R.id.getup_clock_ToggleButton:
			if(mToggleBtn.isChecked()){
				long[] values = {0,200,500};
				VibratorUtil.VibratorUtil(this, values,true);
				mHandler.sendEmptyMessageDelayed(CACLE_VIBRATE, 60000);
			}
			break;
			
		}
	}
	
	class MyHandler extends Handler{

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch(msg.what){
			
			case CACLE_VIBRATE:
				VibratorUtil.cacel();
			break;
			}
		}
		
	}

}
