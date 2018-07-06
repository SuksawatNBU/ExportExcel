package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoTime {
	
	static int minuteSum = 0;
	static int minuteTotal = 0;

	public static void main(String[] args) {
		String time = null;
		for(int i = 1 ; i < 2 ; i++){
			
			System.out.println("ห้องประชุม " + i+ "=============================");
			for(int j = 0 ; j < 3 ; j++){
				time = "14:00 - 14:01";
				diffTime(time);
			}
			System.out.println("--> เวลารวม " + (minuteSum/60) + ":" + (minuteSum%60) + " ชั่วโมง ");
			System.out.println("time = " + (minuteSum/60) + "." + (minuteSum%60)*100/60 + " ชั่วโมง ");
			System.out.println();
			
			minuteTotal += minuteSum;
			minuteSum = 0;
		}
		System.out.println("=============================");
		System.out.println("--> เวลารวม " + (minuteTotal/60) + ":" + (minuteTotal%60) + " ชั่วโมง ");
		System.out.println("time = " + (minuteTotal/60) + "." + (minuteTotal%60)*100/60 + " ชั่วโมง ");
	}
	
	public static String diffTime(String time){
		String startTime = time.substring(0, 5);
		String endTime = time.substring(8, 13);
		DateFormat df = new SimpleDateFormat("HH:mm");
		try {
			Date start = df.parse(startTime);
			Date end = df.parse(endTime);
			long diff = end.getTime() - start.getTime();
			int hourDiff = (int) (diff / (60 * 60 * 1000) % 24);
			int minuteDiff = (int) (diff / (60 * 1000) % 60);
			minuteSum += minuteDiff + (hourDiff*60);
			
			if(minuteDiff < 10){
				time = String.valueOf(hourDiff) + ".0" + String.valueOf(minuteDiff*100/60);
			}else{
				time = String.valueOf(hourDiff) + "." + String.valueOf(minuteDiff*100/60);
			}
			
			// Show
			if(minuteDiff < 10){
				System.out.println(startTime+ "-" + endTime + " = " +hourDiff + ":0" + minuteDiff + " ชั่วโมง");
			}else{
				System.out.println(startTime+ "-" + endTime + " = " +hourDiff + ":" + minuteDiff + " ชั่วโมง");
			}
			
			System.out.println("time = " + time);
			
			return time;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
