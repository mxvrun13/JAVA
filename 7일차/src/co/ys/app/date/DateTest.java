package co.ys.app.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class DateTest {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int day_year = calendar.get(Calendar.DAY_OF_YEAR);
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(day_year);
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(second);
		
		System.out.println(System.currentTimeMillis());
		
		// 살아온 일 수 계산
		Calendar birth = Calendar.getInstance();
		birth.set(1996, 10, 13);	//month는 -1
		long dur = calendar.getTimeInMillis() - birth.getTimeInMillis();
		dur = dur/1000/60/60/24;
		System.out.println("일수 : " + dur);
		
		// 기념일
		Calendar an = Calendar.getInstance();
		an.set(2021, 4, 10);
		long d = calendar.getTimeInMillis() - an.getTimeInMillis();
		d = d/1000/60/60/24;
		System.out.println("일수 : " + d);
		
		LocalDate currentDate =  LocalDate.now();
		System.out.println(currentDate.getYear() + "/" + currentDate.getMonthValue() + "/" + currentDate.getDayOfMonth());
		System.out.println(currentDate.plusDays(100));
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd E u G 'at' HH:mm:ss z");
		System.out.println(df.format(calendar.getTime()));
		
	}

}
