<%@page import="controller.PlanController"%>
<%@page import="controller.CalController"%>
<%@page import="controller.SubjectController"%>
<%@page import="model.logic.DrawCal"%>
<%@page import="model.logic.InitCal"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Optional"%>
<%@page import="java.util.List"%>
    
    <%!
	// TODO implement later
	String user = "mock";
    //
    SubjectController subjectController = new SubjectController(user);
    CalController calController = new CalController(user);
    PlanController planController = new PlanController(user);
    
    
    int on = 0;
	int subjectWeekPositon = 0;
	int weeks;
	String subjectName = "";
	String year;
	String month;

	Map<Integer, List<String>> weeksContainer;
	List<String> subjectNamesList;
	// TODO revision
	Map<Integer, Map<Integer, String>> weekPlanMap;
	Map<Integer, String> emptyMap;
	%>
	
	<%--drawing calendar --%>
	<%
	
	// TODO revison
	year = Optional.ofNullable((String)session.getAttribute("sessionYear")).orElse("2077");
	month = Optional.ofNullable((String)session.getAttribute("sessionMonth")).orElse("12");
	
	if(request.getParameter("year") != null) {
		year = request.getParameter("year");
		month = request.getParameter("month");
		
		session.setAttribute("sessionYear", year);
		session.setAttribute("sessionMonth", month);
	}
	
	weeks = calController.initCal(year, month);
	session.setAttribute("sessionWeeks", weeks);

	weeksContainer = calController.getWeeksContainer();
	
	%>