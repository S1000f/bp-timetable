package model.data;

import java.util.List;

public class PlanDto {
	
	private String user;
	private String year;
	private String month;
	private int week;
	private List<String> days;
	private String subjectName;
	
	public PlanDto(String user, String year, String month, int week, List<String> days, String subjectName) {
		this.user = user;
		this.year = year;
		this.month = month;
		this.week = week;
		this.days = days;
		this.subjectName = subjectName;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

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

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public List<String> getDays() {
		return days;
	}

	public void setDays(List<String> days) {
		this.days = days;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	
}
