<%@page import="java.util.ArrayList"%>
<%@page import="controller.SubjectController"%>
<%@page import="java.util.Map"%>
<%@page import="model.logic.DrawCal"%>
<%@page import="model.logic.InitCal"%>
<%@page import="java.util.Optional"%>
<%@page import="java.util.List"%>
    
    <%!
	// TODO implement later
	final String user = "mock";
    SubjectController subjectController = new SubjectController(user);
    
    //
    
    int on = 0;
	int subjectWeekPositon = 0;
	int weeks;
	String subjectName;
	String year;
	String month;

	Map<Integer, List<String>> weeksContainer;
	List<String> subjectNamesList;
	
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