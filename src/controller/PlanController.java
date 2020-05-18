package controller;

import java.util.List;
import java.util.Map;

import model.data.PlanDao;
import model.data.PlanDto;
import model.logic.InitPlan;

public class PlanController {

	private String user;
	private PlanDao planDao;
	private PlanDto planDto;
	private InitPlan initplan;
	private List<Integer> weekPlanList;
	private List<Integer> formerPlanList;
	private Map<Integer, List<Integer>> planMap;
	
	public PlanController(String user) {
		this.user = user;
		this.planDao = new PlanDao();
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
			result = planDao.updatePlan(planDto);
			return result;
		} else {
			return -1; // DB connection failed
		}
		
	}
	
	public Map<Integer, List<Integer>> readPlan(String year, String month, Map<Integer,List<String>> weeksContainer) {
		int intYear = Integer.valueOf(year);
		int intMonth = Integer.valueOf(month);
		planMap = planDao.readMonthPlan(user, intYear, intMonth);
		
		initplan.buildMonthPlanMap(user, planMap, planDao, weeksContainer);
		
		return planMap;
	}
	
	public int deletePlan(String sid) {
		int intSid = Integer.valueOf(sid);
		int result = 0;
		result = planDao.deletePlan(user, intSid);
		
		return result;
		
	}
	
	
	public Map<Integer,List<String>> getSubNamesMap() {
		return initplan.getWeekSubNames();
	}
	
	public Map<Integer, List<String>> getSubTagsMap() {
		return initplan.getWeekSubTags();
	}
	
}
