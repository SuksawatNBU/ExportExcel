package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoTime {

	public static void main(String[] args) {
		String startTime = "2013-08-01 12:43:23";
		String endTime = "2013-08-02 21:01:21";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
		Date start = df.parse(startTime);
		Date end = df.parse(endTime);
		long diff = end.getTime() - start.getTime();
		int dayDiff = (int) (diff / (24 * 60 * 60 * 1000));
		int hourDiff = (int) (diff / (60 * 60 * 1000) % 24);
		int minuteDiff = (int) (diff / (60 * 1000) % 60);
		int secondDiff = (int) (diff / 1000 % 60);
		System.out.println("Day Diff = " + dayDiff);
		System.out.println("Hour Diff = " + hourDiff);
		System.out.println("Minute Diff = " + minuteDiff);
		System.out.println("Second Diff = " + secondDiff);
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}
}
