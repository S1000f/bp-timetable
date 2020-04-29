package model.logic;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class InitPlan {
	
	private Map<Integer, Map<Integer, String>> weekPlanMap;
	private Map<Integer, String> plan;
	
	public InitPlan() {
		weekPlanMap = new TreeMap<>();
		plan = new TreeMap<>();
	}
	
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
}
