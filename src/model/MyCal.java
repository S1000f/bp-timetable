package model;

import java.time.LocalDate;
import java.time.DayOfWeek;

public class MyCal {
	
	private LocalDate date;
	private DayOfWeek today;
	private String firstDay;
	
	public MyCal(int year, int month, int day) {
		date = LocalDate.of(year, month, day);
		today = date.getDayOfWeek();
		firstDay = String.valueOf(today);
	}
	
	public String getFirstDay() {
		return firstDay;
	}
	
	public static void main(String[] args) {
		//MyCal cal = new MyCal(2021, 4);
		//String dayStart = cal.getFirstDay();
		
		//System.out.println(dayStart);
		
	}
	
}

