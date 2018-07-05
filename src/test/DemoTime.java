package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoTime {
	
	static int Time = 0;

	public static void main(String[] args) {
		String time = "09:15 - 12:4";
		diffTime(time);
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
			Time += minuteDiff + (hourDiff*60);
			time = String.valueOf(hourDiff) + ":" + String.valueOf(minuteDiff);
			System.out.println("ชั่วโมง : "+time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}
}
