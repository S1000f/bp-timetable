package model;

import java.util.Optional;

public class InitCal {

	private MyCal cal;
	private DrawCal drawing;
	private int firstday;
	private int lastday;
	private int weeks;
	private String year;
	private String month;
	private final int day = 1;
	private int intYears;
	private int intMonths;
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getFirstday() {
		return firstday;
	}
	
	public int getLastday() {
		return lastday;
	}
	
	public int getWeeks () {
		return weeks;
	}
	
	public DrawCal getDrawCal() {
		return drawing;
	}
	
	public int initMyCal(String year, String month) {
		
		try {
			intYears = Optional.ofNullable(year)
					.map(s-> Integer.valueOf(s))
					.orElse(2077);
			
			intMonths = Optional.ofNullable(month)
					.map(s-> Integer.valueOf(s))
					.orElse(1);
			
			this.cal = new MyCal(intYears, intMonths, day);
			this.firstday = cal.getFirstDay();
			this.lastday = cal.getLastDay();
			
			drawing = new DrawCal(firstday, lastday);
			weeks = drawing.initDrawing();
			
			return weeks;
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
