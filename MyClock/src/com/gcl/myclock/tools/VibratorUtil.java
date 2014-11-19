package com.gcl.myclock.tools;

import android.app.Activity;
import android.app.Service;
import android.os.Vibrator;

public class VibratorUtil {
	
	private static Vibrator vib;
	public static void VibratorUtil(final Activity activity,long milliseconds){
		vib = (Vibrator) activity.getSystemService(Service.VIBRATOR_SERVICE);   
        vib.vibrate(milliseconds);   
	}
	
	
	public static void VibratorUtil(final Activity activity, long[] pattern,boolean isRepeat) {   
        vib = (Vibrator) activity.getSystemService(Service.VIBRATOR_SERVICE);   
        vib.vibrate(pattern, isRepeat ? 1 : -1);   
	}  
	
	public static void cacel(){
		if(vib != null)
			vib.cancel();		
	}
	
	
}
