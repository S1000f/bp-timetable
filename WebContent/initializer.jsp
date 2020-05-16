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

	int weeks;
	int loginResult;
	String year;
	String month;
	
	// loginForm.jsp
	String strUser;
	String passwd;
	String signUpCheck;
	String logout;
	
	// subjectFrom.jsp, subjectView.jsp
	Map<Integer, SubjectDto> subjectMap;
	// calendar.jsp
	Map<Integer, List<String>> weeksContainer;
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