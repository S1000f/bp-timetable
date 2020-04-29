package controller;

import java.util.ArrayList;
import java.util.List;

import model.data.PlanDto;
import model.logic.InitPlan;

public class PlanController {

	private String user;
	private PlanDto planDto;
	private List<String> chosenDayList;
	private InitPlan initplan;
	
	public PlanController(String user) {
		this.user = user;
		this.chosenDayList = new ArrayList<>();
	}
	
	public void savePlan(String year, String month, int week, List<String> daylist, String subjectName) {
		planDto = new PlanDto(user, year, month, week, daylist, subjectName);
		// make DB insert method
		
	}
	
	
}
