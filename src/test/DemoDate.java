package test;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DemoDate {
	public static void main(String[] args) {
		Format formatter = new SimpleDateFormat("dd MMM yy", new Locale("th", "TH"));
	    System.out.println(formatter.format(new Date()));
	}
	
	

}
