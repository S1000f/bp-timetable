package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.data.PlanDao;
import model.data.PlanDto;
import model.logic.InitPlan;

public class PlanController {

	private String user;
	private PlanDao planDao;
	private PlanDto planDto;
	private List<String> chosenDayList;
	private Map<Integer, Map<Integer, String>> weekPlanMap;
	private InitPlan initplan;
	private List<Integer> weekPlanList;
	private List<Integer> formerPlanList;
	
	public PlanController(String user) {
		this.user = user;
		this.planDao = new PlanDao();
		this.chosenDayList = new ArrayList<>();
		this.initplan = new InitPlan();
	}
	
	public int savePlan(String year, String month, int week, List<String> daylist, String sid) {
		int result = 0;
		int intYear = Integer.valueOf(year);
		int intMonth = Integer.valueOf(month);
		int intSid = Integer.valueOf(sid);
		
		weekPlanList = initplan.makePlanList(daylist, intSid);
		planDto = new PlanDto(user, intYear, intMonth, week, weekPlanList, intSid);
		int checkResult = planDao.checkPlan(planDto);
		
		if(checkResult == 0) {
			result = planDao.insertPlan(planDto);
			return result;
		} else if(checkResult == 1) {
			formerPlanList = planDao.getWeekPlan(planDto);
			planDto = initplan.mergePlanList(formerPlanList, weekPlanList, planDto);
			result = planDao.insertPlan(planDto);
			return result;
		} else {
			return -1; // DB connection failed
		}
		
		// TODO revision
		//weekPlanMap = initplan.makeWeekPlanMap(week, daylist, sid);
		
	}
	
	public Map<Integer, Map<Integer, String>> loadPlan() {
		// make DB read method via PlanDB
		return weekPlanMap;
	}
	
}
