package model;

import java.time.LocalDate;
import java.time.DayOfWeek;

class MyCal {
	
	private LocalDate date;
	private DayOfWeek today;
	private String firstDay;
	
	public MyCal(int year, int month) {
		date = LocalDate.of(year, month, 1);
		today = date.getDayOfWeek();
		firstDay = String.valueOf(today);
	}
	
	String getFirstDay() {
		return firstDay;
	}
}

public class MyCalendar {
	public static void main(String[] args) {
		
		MyCal cal = new MyCal(2021, 4);
		String dayStart = cal.getFirstDay();
		
		System.out.println(dayStart);
	}
	
}
