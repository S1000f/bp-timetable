package model.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DrawCal {
	
	private int firstday;
	private int lastday;
	private int numOfWeeks;
	private int dayOne;
	private List<String> firstWeek;
	private List<String> secondWeek;
	private List<String> thirdWeek;
	private List<String> fourthWeek;
	private List<String> fifthWeek;
	private List<String> lastWeek;
	private Map<Integer, List<String>> weeksContainer;
	
	public DrawCal(int first, int last) {
		this.firstday = first;
		this.lastday = last;
		this.numOfWeeks = 0;
		this.dayOne = 1;
		this.weeksContainer = new TreeMap<>();
	}
	
	public Map<Integer, List<String>> getWeeksContainer() {
		return weeksContainer;
	}
	
	public int initDrawing() {
		numOfWeeks++;
		weeksContainer.put(0, new ArrayList<>(Arrays.asList("-","-","-","-","-","-","-")));
		firstWeek = new ArrayList<>(7);
		
		for(int i = 0; i < firstday - 1; i++) {
			firstWeek.add(i, "-");
		}
		
		for(int i = firstday - 1; i < 7; i++) {
			firstWeek.add(i, String.valueOf(dayOne++));
		}
		
		weeksContainer.put(1, firstWeek);
		
		if(dayOne <= lastday && !firstWeek.isEmpty()) {
			secondWeek = new ArrayList<>(7);
			numOfWeeks++;
			for(int i = 0; i < 7 && dayOne <= lastday; i++) {
				secondWeek.add(i, String.valueOf(dayOne++));
			}
			weeksContainer.put(2, secondWeek);
		}
		
		if(dayOne <= lastday && !secondWeek.isEmpty()) {
			thirdWeek = new ArrayList<>(7);
			numOfWeeks++;
			for(int i = 0; i < 7 && dayOne <= lastday; i++) {
				thirdWeek.add(i, String.valueOf(dayOne++));
			}
			weeksContainer.put(3, thirdWeek);
		}
		
		if(dayOne <= lastday && !thirdWeek.isEmpty()) {
			fourthWeek = new ArrayList<>();
			numOfWeeks++;
			for(int i = 0; i < 7 && dayOne <= lastday; i++) {
				fourthWeek.add(i, String.valueOf(dayOne++));
			}
			weeksContainer.put(4, fourthWeek);
		}
		
		if(dayOne <= lastday && !fourthWeek.isEmpty()) {
			fifthWeek = new ArrayList<>();
			numOfWeeks++;
			for(int i = 0; i < 7 && dayOne <= lastday; i++) {
				fifthWeek.add(i, String.valueOf(dayOne++));
			}
			weeksContainer.put(5, fifthWeek);
		}
		
		if(dayOne <= lastday && !fifthWeek.isEmpty()) {
			lastWeek = new ArrayList<>();
			numOfWeeks++;
			for(int i = 0; i < 7 && dayOne <= lastday; i++) {
				lastWeek.add(i, String.valueOf(dayOne++));
			}
			weeksContainer.put(6, lastWeek);
		}
		
		return numOfWeeks;
		
	}
}
