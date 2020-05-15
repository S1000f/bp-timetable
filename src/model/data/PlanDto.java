package model.data;

import java.util.List;

public class PlanDto {
	
	private String user;
	private int year;
	private int month;
	private int week;
	private List<Integer> planList;
	private int sid;
	
	public PlanDto(String user, int year, int month, int week, List<Integer> list, int sid) {
		this.user = user;
		this.year = year;
		this.month = month;
		this.week = week;
		this.planList = list;
		this.sid = sid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public List<Integer> getPlanList() {
		return planList;
	}

	public void setPlanList(List<Integer> list) {
		this.planList = list;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
	
}
