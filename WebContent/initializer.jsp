<%@page import="model.data.SubjectDto"%>
<%@page import="controller.LoginController"%>
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
	String user;
	LoginController loginController;
	CalController calController = new CalController(user);
	
   	SubjectController subjectController;
	PlanController planController;

	// TODO revision
	int on = 0;
	int subjectWeekPositon = 0;
	int weeks;
	int loginResult;
	String subjectName = "";
	String year;
	String month;
	
	// loginForm
	String strUser;
	String passwd;
	String signUpCheck;
	String logout;
	
	// subjectFrom, subjectView
	Map<Integer, SubjectDto> subjectMap;
	List<String> subjectNamesList;
	
	Map<Integer, List<String>> weeksContainer;
	// TODO revision
	Map<Integer, Map<Integer, String>> weekPlanMap;
	Map<Integer, String> emptyMap;
%>

<%
	
	// TODO revison
	year = Optional.ofNullable((String)session.getAttribute("sessionYear")).orElse("2077");
	month = Optional.ofNullable((String)session.getAttribute("sessionMonth")).orElse("12");
	
	if(request.getParameter("year") != null) {
		year = request.getParameter("year");
		month = request.getParameter("month");
		
		session.setAttribute("sessionYear", year);
		session.setAttribute("sessionMonth", month);
		
		session.setAttribute("sessionMessage", "[SUCCESS] Calendar generated");
	}
	
	weeks = calController.initCal(year, month);
	session.setAttribute("sessionWeeks", weeks);
	
	weeksContainer = calController.getWeeksContainer();
	
%>