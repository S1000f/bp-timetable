package model.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.data.PlanDao;
import model.data.PlanDto;

public class InitPlan {
	
	private List<Integer> weekPlanList;
	private List<Integer> sidList;
	private Set<Integer> sidSet;
	private Map<Integer, Map<String,String>> subNameAndTagMap;
	private Map<Integer, Map<String, String>> monthPlanMap;
	
	public InitPlan() {
		this.weekPlanList = new ArrayList<>();
	}
	
	public List<Integer> makePlanList(List<String> daylist, int sid) {
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
	
	public Map<Integer, Map<String, String>> buildMonthPlanMap(
			String user, Map<Integer, List<Integer>> planMap, PlanDao planDao, Map<Integer, List<String>> weeksContainer) {
		sidSet = new HashSet<>();
		
		Set<Integer> keySet = planMap.keySet();
		for(Integer n : keySet) {
			sidSet.addAll(planMap.get(n));
		}
		sidSet.remove(0);
		sidList = new ArrayList<>(sidSet);
		Collections.sort(sidList);
		
		subNameAndTagMap = planDao.getSubNameAndTag(user);
		
		
		
		//TODO delete
		System.out.println(planMap);
		System.out.println(subNameAndTagMap);
		System.out.println(weeksContainer);
		
		for(int i = 1; i <= weeksContainer.size(); i++) {
			
		}
		
		
		return new TreeMap<>();
	}
	
}






