package model;

import java.time.LocalDate;
import java.time.DayOfWeek;

/*
 *create essential data to make a calendar by using java.time.LocalDate.
 *firstday is integer ranged from 1 to 7 which means 1 is Monday.
 *lastday is integer which is the last day of the month selected by end-user.
 *both of them are supposed to be initialized by initCal.initMyCal on the other hand, day is fixed to 1
 *
 */
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

	// TODO
	public static void main(String[] args) {
		DrawCal draw = new DrawCal(3, 30);
		draw.initDrawing();
		draw.test();
	}
	
}

