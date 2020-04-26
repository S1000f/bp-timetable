<%@page import="java.util.Map"%>
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

	Map<Integer, List<String>> weeksContainer;
	%>
	
	<%--making subjects --%>
	<%
	
	// TODO delete later
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
	year = Optional.ofNullable((String)session.getAttribute("sessionYear")).orElse("2077");
	month = Optional.ofNullable((String)session.getAttribute("sessionMonth")).orElse("12");
	
	if(request.getParameter("year") != null) {
		year = request.getParameter("year");
		month = request.getParameter("month");
		
		session.setAttribute("sessionYear", year);
		session.setAttribute("sessionMonth", month);
	}
	
	InitCal initcal = new InitCal();
	weeks = initcal.initMyCal(year, month);
	session.setAttribute("sessionWeeks", weeks);
	
	DrawCal drawing = initcal.getDrawCal();
	weeksContainer = drawing.getWeeksContainer();
	%>