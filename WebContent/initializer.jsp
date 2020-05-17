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
	LoginController loginController;
	CalController calController = new CalController("geust");
   	SubjectController subjectController;
	PlanController planController;

	int weeks;
	String year;
	String month;
	
	//subjectFrom.jsp, subjectView.jsp
	Map<Integer, SubjectDto> subjectMap;
	
	// calendar.jsp
	Map<Integer, List<String>> weeksContainer;
	
	Map<Integer, List<Integer>> planMap;
	Map<Integer, List<String>> subNamesMap;
	Map<Integer, List<String>> subTagsMap;
%>

<%
	
	
	// TODO revison
	year = Optional.ofNullable((String)session.getAttribute("sessionYear")).orElse("2077");
	month = Optional.ofNullable((String)session.getAttribute("sessionMonth")).orElse("9");
	
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
	
	//TODO session
	if(session.getAttribute("sessionUser") != null) {
		try{
			if(session.getAttribute("sessionID").equals(session.getId())) {
				planController = new PlanController((String)session.getAttribute("sessionUser"));
				planMap = planController.readPlan(year, month, weeksContainer);
				subNamesMap = planController.getSubNamesMap();
				subTagsMap = planController.getSubTagsMap();
			} else {
				planController = new PlanController((String)session.getAttribute("guest"));
				planMap = planController.readPlan(year, month, weeksContainer);
				subNamesMap = planController.getSubNamesMap();
				subTagsMap = planController.getSubTagsMap();
			}
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
%>