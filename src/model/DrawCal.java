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
	
	public int initDrawing() {
		numOfWeeks++;
		firstWeek = new ArrayList<>(7);
		
		for(int i = 0; i < firstday - 1; i++) {
			firstWeek.add(i, "");
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
			fourthWeek = new ArrayList<>(7);
			numOfWeeks++;
			for(int i = 0; i < 7 && dayOne <= lastday; i++) {
				fourthWeek.add(i, String.valueOf(dayOne++));
			}
		}
		
		/*
		 * To avoid making the null-point exception, calculating exact size of array we need
		 * when it comes to creating fifth and lastweek array list.
		 */
		if(dayOne <= lastday && !fourthWeek.isEmpty()) {
			fifthWeek = new ArrayList<>(lastday - dayOne >= 7 ? 7 : lastday - dayOne);
			numOfWeeks++;
			for(int i = 0; i < 7 && dayOne <= lastday; i++) {
				fifthWeek.add(i, String.valueOf(dayOne++));
			}
		}
		
		if(dayOne <= lastday && !fifthWeek.isEmpty()) {
			lastWeek = new ArrayList<>(lastday - dayOne >= 7 ? 7 : lastday - dayOne);
			numOfWeeks++;
			for(int i = 0; i < 7 && dayOne <= lastday; i++) {
				lastWeek.add(i, String.valueOf(dayOne++));
			}
		}
		
		return numOfWeeks;
		
	}
	
	public void test() {
		for(String e: firstWeek) {
			System.out.print(e + "\t");
		}
		System.out.println();
		for(String e: secondWeek) {
			System.out.print(e + "\t");
		}
		System.out.println();
		for(String e: thirdWeek) {
			System.out.print(e + "\t");
		}
		System.out.println();
		for(String e: fourthWeek) {
			System.out.print(e + "\t");
		}
		System.out.println();
		for(String e: fifthWeek) {
			System.out.print(e + "\t");
		}
		System.out.println();
	}
}
