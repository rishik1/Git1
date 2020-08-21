package com.airilines.api.flight.utils;

public class utils {

	
	public static int convertAmPmTimeUtils(String timeValue){
		if(timeValue==null){
			return -1; //inValid Val
		}
		int timeInMintues=0;
		
		if(timeValue.endsWith("am") || timeValue.endsWith("AM")){
			timeValue.replace("am", "");
			timeValue.replace("AM", "");
			
			String[] timeVals = timeValue.split(".");
			if(timeVals.length!=2)
				return -1; //Invalid val
			
			int timeInHr = Integer.parseInt(timeVals[0]) *60;
			int timeInMin = Integer.parseInt(timeVals[1]);
			
			int totalTimeInMins  = timeInHr+timeInMin;
			return totalTimeInMins;
		}
		
		if(timeValue.endsWith("pm") || timeValue.endsWith("PM")){
			timeValue.replace("pm", "");
			timeValue.replace("PM", "");
			
			String[] timeVals = timeValue.split(".");
			if(timeVals.length!=2)
				return -1; //Invalid val
			
			int timeInHr = Integer.parseInt(timeVals[0]);
			if(timeInHr!=12){
				 timeInHr =  (Integer.parseInt(timeVals[0]) *60) + (12*60);
			}else{
				timeInHr = 12*60;
			}
			
			int timeInMin = Integer.parseInt(timeVals[1]);
			
			int totalTimeInMins  = timeInHr+timeInMin;
			return totalTimeInMins;
		}
		return timeInMintues; 
	}
}
