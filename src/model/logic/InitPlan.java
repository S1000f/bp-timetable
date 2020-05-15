package model.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.data.PlanDto;

public class InitPlan {
	
	private Map<Integer, Map<Integer, String>> weekPlanMap;
	private Map<Integer, String> plan;
	private List<Integer> weekPlanList;
	
	public InitPlan() {
		weekPlanMap = new TreeMap<>();
		plan = new TreeMap<>();
	}
	
	// TODO revision <week <day, subject>>
	public Map<Integer, Map<Integer, String>> makeWeekPlanMap(int week, List<String> list, String name) {
		for(int i = 0; i < list.size(); i++) {
			plan.put(Integer.valueOf(list.get(i)), name);
		}
		
		for(int i = 0; i < 7; i++) {
			if(plan.get(i) == null) {
				plan.put(i, "");
			}
		}
		
		weekPlanMap.put(week, plan);
		return weekPlanMap;
	}
	
	public List<Integer> makePlanList(List<String> daylist, int sid) {
		weekPlanList = new ArrayList<>();
		
		for(int i = 0; i < 7; i++) {
			if(daylist.contains(String.valueOf(i))) {
				weekPlanList.add(sid);
			} else {
				weekPlanList.add(0);
			}
		}
		
		return weekPlanList;
	}
	
	public PlanDto mergePlanList(List<Integer> oldList, List<Integer> newList, PlanDto planDto) {
		for(int i = 0; i < 7; i++) {
			if(newList.get(i) != 0) {
				oldList.add(i, newList.get(i));
			}
		}
		
		planDto.setPlanList(oldList);
		
		return planDto;
	}
	
}






