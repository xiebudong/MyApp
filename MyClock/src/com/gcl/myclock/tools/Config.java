package com.gcl.myclock.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Config {
	
	private static final String FILE_NAME = "config";
	private SharedPreferences mShare;
	private static Config mConfig;
	public static String WEEKDAY_MONDAY = "monday";
	public static String WEEKDAY_TUESDAY = "tuesday";
	public static String WEEKDAY_WEDNESDAY = "wednesday";
	public static String WEEKDAY_THURSDAY = "thursday";
	public static String WEEKDAY_FRIDAY = "friday";
	public static String WEEKDAY_SATUDAY = "saturday";
	public static String WEEKDAY_SUNDAY = "sunday";
	
	public static Config getConfig(Context context){
		
		if(mConfig == null){
			mConfig = new Config(context);
		}
		return mConfig;
		
	}
	
	private Config(Context context){
		
		mShare = context.getSharedPreferences(FILE_NAME, Context.MODE_WORLD_READABLE);				
	}
	
	public void setConfig(String key,String value){
		
		Editor edit = mShare.edit();
		edit.putString(key, value);
		edit.commit();		
	}
	
	public String getString(String key,String defaultvalue){
		String value = mShare.getString(key, defaultvalue);
		return value;
	}

}
