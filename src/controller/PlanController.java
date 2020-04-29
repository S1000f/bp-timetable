package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.data.PlanDto;
import model.logic.InitPlan;

public class PlanController {

	private String user;
	private PlanDto planDto;
	private List<String> chosenDayList;
	private Map<Integer, Map<Integer, String>> weekPlanMap;
	private InitPlan initplan;
	
	public PlanController(String user) {
		this.user = user;
		this.chosenDayList = new ArrayList<>();
		this.initplan = new InitPlan();
	}
	
	// TODO revision
	public void savePlan(String year, String month, int week, List<String> daylist, String subjectName) {
		planDto = new PlanDto(user, year, month, week, daylist, subjectName);
		// make DB insert method via PlanDB
		weekPlanMap = initplan.makeWeekPlanMap(week, daylist, subjectName);
		
	}
	
	public Map<Integer, Map<Integer, String>> loadPlan() {
		// make DB read method via PlanDB
		return weekPlanMap;
	}
	
}
