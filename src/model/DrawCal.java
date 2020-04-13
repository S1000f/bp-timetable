package model;

import java.util.ArrayList;
import java.util.List;

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
	
	public DrawCal(int first, int last) {
		this.firstday = first;
		this.lastday = last;
		this.numOfWeeks = 0;
		this.dayOne = 1;
	}
	
	public List<String> getWeek(int whichOne) {
		if(whichOne == 1) {
			return firstWeek;
		} else if(whichOne == 2) {
			return secondWeek;
		} else if(whichOne == 3) {
			return thirdWeek;
		} else if(whichOne == 4) {
			return fourthWeek;
		} else if(whichOne == 5) {
			return fifthWeek;
		} else if(whichOne == 6) {
			return lastWeek;
		} else {
			return null;
		}
	}
	
	public List<String> getFirstWeek() {
		return firstWeek;
	}

	public List<String> getSecondWeek() {
		return secondWeek;
	}

	public List<String> getThirdWeek() {
		return thirdWeek;
	}

	public List<String> getFourthWeek() {
		return fourthWeek;
	}

	public List<String> getFifthWeek() {
		return fifthWeek;
	}

	public List<String> getLastWeek() {
		return lastWeek;
	}

	public int initDrawing() {
		numOfWeeks++;
		firstWeek = new ArrayList<>(7);
		
		for(int i = 0; i < firstday - 1; i++) {
			firstWeek.add(i, "-");
		}
		
		for(int i = firstday - 1; i < 7; i++) {
			firstWeek.add(i, String.valueOf(dayOne++));
		}
		
		if(dayOne <= lastday && !firstWeek.isEmpty()) {
			secondWeek = new ArrayList<>(7);
			numOfWeeks++;
			for(int i = 0; i < 7 && dayOne <= lastday; i++) {
				secondWeek.add(i, String.valueOf(dayOne++));
			}
		}
		
		if(dayOne <= lastday && !secondWeek.isEmpty()) {
			thirdWeek = new ArrayList<>(7);
			numOfWeeks++;
			for(int i = 0; i < 7 && dayOne <= lastday; i++) {
				thirdWeek.add(i, String.valueOf(dayOne++));
			}
		}
		
		if(dayOne <= lastday && !thirdWeek.isEmpty()) {
			fourthWeek = new ArrayList<>();
			numOfWeeks++;
			for(int i = 0; i < 7 && dayOne <= lastday; i++) {
				fourthWeek.add(i, String.valueOf(dayOne++));
			}
		}
		
		if(dayOne <= lastday && !fourthWeek.isEmpty()) {
			fifthWeek = new ArrayList<>();
			numOfWeeks++;
			for(int i = 0; i < 7 && dayOne <= lastday; i++) {
				fifthWeek.add(i, String.valueOf(dayOne++));
			}
		}
		
		if(dayOne <= lastday && !fifthWeek.isEmpty()) {
			lastWeek = new ArrayList<>();
			numOfWeeks++;
			for(int i = 0; i < 7 && dayOne <= lastday; i++) {
				lastWeek.add(i, String.valueOf(dayOne++));
			}
		}
		
		return numOfWeeks;
		
	}
}
