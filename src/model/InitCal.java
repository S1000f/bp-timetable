package model;

public class InitCal {

	private MyCal cal;
	private DrawCal drawing;
	private int firstday;
	private int lastday;
	private int weeks;
	private String year;
	private String month;
	private final int day = 1;
	int intYear;
	int intMonth;
	
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
			intYear = Integer.valueOf(year);
			intMonth = Integer.valueOf(month);
			
			this.cal = new MyCal(intYear, intMonth, day);
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
