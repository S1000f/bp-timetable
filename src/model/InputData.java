package model;

public class InputData {

	private MyCal cal;
	private String year = "";
	private String month = "";
	private int day = 1;
	
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
	
	public String initMyCal() {
		
		try {
			int intYear = Integer.valueOf(year);
			int intMonth = Integer.valueOf(month);
			
			cal = new MyCal(intYear, intMonth, day);
			
			return cal.getFirstDay();
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
