package _019;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class _019 {

	public static void main(String[] args) {
		new _019();
	}

	@SuppressWarnings("deprecation")
	public _019() {
		 GregorianCalendar startDate = new GregorianCalendar(1901, 1 - 1, 1);
		 GregorianCalendar endDate = new GregorianCalendar(2000, 12 - 1, 1);
		
		Calendar start = Calendar.getInstance();
		start.setTime(startDate.getTime());
		Calendar end = Calendar.getInstance();
		end.setTime(endDate.getTime());

		int num = 0;
		for (Date date = start.getTime(); !start.after(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
			if(date.getDate() == 1 && date.getDay() == 0) {
				num++;
			}
		}
		System.out.println(num);
	}

}
