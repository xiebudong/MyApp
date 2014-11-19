package com.gcl.myclock;


import java.util.Calendar;
import java.util.Locale;

import com.gcl.myclock.tools.BirthClock;
import com.gcl.myclock.tools.GetUpClock;
import com.gcl.myclock.tools.InvertClock;
import com.identify.timepicker.NumericWheelAdapter;
import com.identify.timepicker.OnWheelChangedListener;
import com.identify.timepicker.OnWheelClickedListener;
import com.identify.timepicker.OnWheelScrollListener;
import com.identify.timepicker.WheelView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;

public class ActivityInvertClock extends Activity implements OnClickListener{
	// Time changed flag
	private boolean timeChanged = false;
	
	// Time scrolled flag
	private boolean timeScrolled = false;
	
	private Button mBtnYes;
	private Button mBtnNo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.invert_clock);
		
		final WheelView hours = (WheelView) findViewById(R.id.invert_picker_hour);
		hours.setViewAdapter(new NumericWheelAdapter(this, 0, 23,"%02d"));
	
		final WheelView mins = (WheelView) findViewById(R.id.invert_picker_mins);
		mins.setViewAdapter(new NumericWheelAdapter(this, 0, 59, "%02d"));
		mins.setCyclic(true);
		
		final WheelView sends = (WheelView) findViewById(R.id.invert_picker_sends);
		sends.setViewAdapter(new NumericWheelAdapter(this, 0, 59, "%02d"));
		sends.setCyclic(true);
		
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
        hours.setCurrentItem(calendar.get(Calendar.HOUR));
        mins.setCurrentItem(calendar.get(Calendar.MINUTE));
        sends.setCurrentItem(calendar.get(Calendar.SECOND));
        
        addChangingListener(mins, "min");
		addChangingListener(hours, "hour");
	
		OnWheelChangedListener wheelListener = new OnWheelChangedListener() {
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				if (!timeScrolled) {
					timeChanged = true;
//					picker.setCurrentHour(hours.getCurrentItem());
//					picker.setCurrentMinute(mins.getCurrentItem());
					timeChanged = false;
				}
			}
		};
		hours.addChangingListener(wheelListener);
		mins.addChangingListener(wheelListener);
		
		OnWheelClickedListener click = new OnWheelClickedListener() {
            public void onItemClicked(WheelView wheel, int itemIndex) {
                wheel.setCurrentItem(itemIndex, true);
            }
        };
        hours.addClickingListener(click);
        mins.addClickingListener(click);

		OnWheelScrollListener scrollListener = new OnWheelScrollListener() {
			public void onScrollingStarted(WheelView wheel) {
				timeScrolled = true;
			}
			public void onScrollingFinished(WheelView wheel) {
				timeScrolled = false;
				timeChanged = true;
//				picker.setCurrentHour(hours.getCurrentItem());
//				picker.setCurrentMinute(mins.getCurrentItem());
				timeChanged = false;
			}
		};
		
		hours.addScrollingListener(scrollListener);
		mins.addScrollingListener(scrollListener);
		
//		picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//			public void onTimeChanged(TimePicker  view, int hourOfDay, int minute) {
//				if (!timeChanged) {
//					hours.setCurrentItem(hourOfDay, true);
//					mins.setCurrentItem(minute, true);
//				}
//			}
//		});
		mBtnYes = (Button)findViewById(R.id.invert_btn_yes);
		mBtnNo = (Button)findViewById(R.id.invert_btn_no);
		mBtnYes.setOnClickListener(this);
		mBtnNo.setOnClickListener(this);
	}

	/**
	 * Adds changing listener for wheel that updates the wheel label
	 * @param wheel the wheel
	 * @param label the wheel label
	 */
	private void addChangingListener(final WheelView wheel, final String label) {
		wheel.addChangingListener(new OnWheelChangedListener() {
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				//wheel.setLabel(newValue != 1 ? label + "s" : label);
			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.invert_btn_yes:
//			InvertClock clock = new InvertClock("1000", "true", "9:00", "test", "test.mp3");
//			GetUpClock c = new GetUpClock("1000", "00", "7:00", "test", "00", "test.mp3", "true", "10");
			BirthClock c = new BirthClock("1", "2", "9:35", "09/14", "test", "test.mp3", "true");
			((ClockApp)getApplication()).getData().addNewBirthClock(c);
			
			break;
		case R.id.invert_btn_no:
			
			break;
		}
	}

}
