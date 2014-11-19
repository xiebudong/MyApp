package com.gcl.myclock;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;


public class CustomLabelImg extends Button{
	
	private Context mContext;

	public CustomLabelImg(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		mContext = context;
		setBackgroundResource(R.drawable.custom_label_bg);
		setTextSize(15.0f);
	}

	public CustomLabelImg(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mContext = context;
		setBackgroundResource(R.drawable.custom_label_bg);
		setTextSize(15.0f);
	}

	public CustomLabelImg(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mContext = context;
		setBackgroundResource(R.drawable.custom_label_bg);
		setTextSize(15.0f);
	}
	
	public void setText(String text){
		setText(text);
	}
		
}
