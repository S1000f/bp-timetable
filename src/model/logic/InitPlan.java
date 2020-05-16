package model.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.data.PlanDao;
import model.data.PlanDto;

public class InitPlan {
	
	private List<Integer> weekPlanList;
	private Map<Integer, String> subNamesMap;
	private Map<Integer, String> subTagsMap;
	Map<Integer, List<String>> weekSubNames;
	Map<Integer, List<String>> weekSubTags;
	
	public InitPlan() {
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
				oldList.set(i, newList.get(i));
			}
		}
		
		planDto.setPlanList(oldList);
		
		return planDto;
	}
	
	public void buildMonthPlanMap(
			String user, Map<Integer, List<Integer>> planMap, PlanDao planDao, Map<Integer, List<String>> weeksContainer) {
		
		subNamesMap = planDao.getSubNamesMap(user);
		subTagsMap = planDao.getSubTagsMap(user);
		
		weekSubNames = new TreeMap<>();
		weekSubTags = new TreeMap<>();
		List<String> emptySubNames = new ArrayList<>(Arrays.asList("","","","","","",""));
		List<String> emptySubTags = new ArrayList<>(Arrays.asList("#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff"));
		
		for(int i = 1; i < weeksContainer.size(); i++) {
			weekSubNames.put(i, emptySubNames);
			weekSubTags.put(i, emptySubTags);
		}
		
		try {
			for(int i = 1; i <= weekSubNames.size(); i++) {
				if(planMap.containsKey(i)) {
					List<String> namesList = new ArrayList<>();
					for(int j = 0; j < planMap.get(i).size(); j++) {
						if(planMap.get(i).get(j) != 0) {
							namesList.add(subNamesMap.getOrDefault(planMap.get(i).get(j), ""));
						} else {
							namesList.add("");
						}
					}
					weekSubNames.replace(i, namesList);
				}
			}
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		try {
			for(int i = 1; i <= weekSubNames.size(); i++) {
				if(planMap.containsKey(i)) {
					List<String> tagsList = new ArrayList<>();
					for(int j = 0; j < planMap.get(i).size(); j++) {
						if(planMap.get(i).get(j) != 0) {
							tagsList.add(subTagsMap.getOrDefault(planMap.get(i).get(j), "#ffffff"));
						} else {
							tagsList.add("#ffffff");
						}
					}
					weekSubTags.replace(i, tagsList);
				}
			}
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		
	}
	
	public Map<Integer, List<String>> getWeekSubNames() {
		return weekSubNames;
	}
	
	public Map<Integer, List<String>> getWeekSubTags() {
		return weekSubTags;
	}
	
}






