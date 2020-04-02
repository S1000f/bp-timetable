package model;

import java.time.LocalDate;
import java.time.DayOfWeek;


public class MyCal {
	
	private LocalDate date;
	private DayOfWeek today;
	private int firstDay;
	private int lastDay;
	
	public MyCal(int year, int month, int day) {
		this.date = LocalDate.of(year, month, day);
		this.today = date.getDayOfWeek();
		this.firstDay = today.getValue();
		this.lastDay = date.lengthOfMonth();
	}
	
	public int getFirstDay() {
		return firstDay;
	}
	
	public int getLastDay() {
		return lastDay;
	}
	
	public static void main(String[] args) {
		
	}
	
}

