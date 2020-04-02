package model;

import java.util.ArrayList;
import java.util.List;

public class DrawCal {
	
	private int firstday;
	private int lastday;
	private int count;
	private int numOfWeeks;
	private List<String> firstWeek;
	private List<String> secondWeek;
	private List<String> thirdWeek;
	private List<String> fourthWeek;
	private List<String> fifthWeek;
	private List<String> lastWeek;
	
	
	public DrawCal(int first, int last) {
		this.firstday = first;
		this.lastday = last;
		this.count = last;
		this.numOfWeeks = 0;
	}
	
	public int initDrawing() {
		int dayOne = 1;
		numOfWeeks++;
		firstWeek = new ArrayList<>(7);
		
		for(int i = 0; i < firstday - 1; i++) {
			firstWeek.add(i, "");
		}
		
		for(int i = firstday - 1; i < 7; i++) {
			count--;
			firstWeek.add(i, String.valueOf(dayOne++));
		}
		
		if(count != 0 && !firstWeek.isEmpty()) {
			secondWeek = new ArrayList<>(7);
			numOfWeeks++;
			for(int i = 0; i < 7 && count != 0; i++) {
				secondWeek.add(i, String.valueOf(lastday - count + 1));
				count--;
			}
		}
		
		if(count != 0 && !secondWeek.isEmpty()) {
			thirdWeek = new ArrayList<>(7);
			numOfWeeks++;
			for(int i = 0; i < 7 && count != 0; i++) {
				thirdWeek.add(i, String.valueOf(lastday - count + 1));
				count--;
			}
		}
		
		if(count != 0 && !thirdWeek.isEmpty()) {
			fourthWeek = new ArrayList<>(7);
			numOfWeeks++;
			for(int i = 0; i < 7 && count != 0; i++) {
				fourthWeek.add(i, String.valueOf(lastday - count + 1));
				count--;
			}
		}
		
		if(count != 0 && !fourthWeek.isEmpty()) {
			fifthWeek = new ArrayList<>(count >= 7 ? 7 : 7 - count);
			numOfWeeks++;
			for(int i = 0; i < 7 && count != 0; i++) {
				fifthWeek.add(i, String.valueOf(lastday - count + 1));
				count--;
			}
		}
		
		if(count != 0 && !fifthWeek.isEmpty()) {
			lastWeek = new ArrayList<>(count >= 7 ? 7 : 7 - count);
			numOfWeeks++;
			for(int i = 0; i < 7 && count != 0; i++) {
				lastWeek.add(i, String.valueOf(lastday - count + 1));
				count--;
			}
		}
		
		return numOfWeeks;
		
	}
}
