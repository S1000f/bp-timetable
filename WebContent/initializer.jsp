<%@page import="model.DrawCal"%>
<%@page import="model.InitCal"%>
<%@page import="java.util.Optional"%>
<%@page import="java.util.List"%>
    
    <%!
	int on;
	int subjectWeekPositon = 0;
	int weeks;
	String subjectName;
	String year;
	String month;
	
	List<String> week1;
	List<String> week2;
	List<String> week3;
	List<String> week4;
	List<String> week5;
	List<String> week6;
	%>
	
	<%--making subjects --%>
	<%
	
	// TODO
	on = (Integer)session.getAttribute("turnOn");
	
	if(on == 1) {
		subjectName = (String)session.getAttribute("sessionSubjectName");
	} else if(on == 0 || on == -1) {
		subjectName = "";
	}
	%>
	
	<%--drawing calendar --%>
	<%
	// TODO
	if(request.getParameter("year") != year || request.getParameter("month") != month) {
		year = request.getParameter("year");
		month = request.getParameter("month");
		
		session.setAttribute("sessionYear", year);
		session.setAttribute("sessionMonth", month);
	}
	
	year = Optional.ofNullable((String)session.getAttribute("sessionYear")).orElse("2077");
	month = Optional.ofNullable((String)session.getAttribute("sessionMonth")).orElse("12");
	
	InitCal initcal = new InitCal();
	weeks = initcal.initMyCal(year, month);
	session.setAttribute("sessionWeeks", weeks);
	
	DrawCal drawing = initcal.getDrawCal();
	
	week1 = drawing.getFirstWeek();
	week2 = drawing.getSecondWeek();
	week3 = drawing.getThirdWeek();
	week4 = drawing.getFourthWeek();
	week5 = drawing.getFifthWeek();
	week6 = drawing.getLastWeek();
	
	%>