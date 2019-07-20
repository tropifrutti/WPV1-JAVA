package hsnr.fb03.wpv1.classes;

import java.util.Calendar;
import java.util.Date;

public class DatingGame {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(1999, 12, 31);
		System.out.print(cal.get(Calendar.YEAR) + " ");
		
		Date d = cal.getTime();
		System.out.println(d.getDay());
	}

}
