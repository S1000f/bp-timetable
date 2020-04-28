package controller;

import java.util.List;
import java.util.Map;

import model.logic.InitCal;

public class CalController {
	
	private String user;
	private InitCal initcal;
	
	public CalController(String user) {
		this.user = user;
	}
	
	public int initCal(String year, String month) {
		initcal = new InitCal();
		int week = initcal.initMyCal(year, month);
		
		return week;
	}
	
	public Map<Integer, List<String>> getWeeksContainer() {
		return initcal.getDrawCal().getWeeksContainer();
	}
}
