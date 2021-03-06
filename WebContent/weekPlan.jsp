<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Optional"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Arrays" %>

<%@include file="initializer.jsp" %>

	<%
	int whichWeek;
	List<String> chosenWeek;
	String[] str;
	List<String> chosenDayList;
	String chosenSubject;
	
	whichWeek = Integer.valueOf(Optional.ofNullable(request.getParameter("chooseWeek")).orElse("-1"));
	if(whichWeek != -1) {
		session.setAttribute("sessionWhichWeek", whichWeek);
	}
	
	chosenWeek = calController.getWeeksContainer().get(whichWeek);
	
	str = Optional.ofNullable(request.getParameterValues("checkbox")).orElse(new String[] {"0"});
	chosenDayList = new ArrayList<>(Arrays.asList(str));
	
	subjectMap = (Map<Integer, SubjectDto>) session.getAttribute("sessionSubjectMap");
	
	chosenSubject = Optional.ofNullable(request.getParameter("chooseSubject")).orElse("undefined");
	
	// when 'sava plan' button clicked
	if(!chosenSubject.equals("undefined")) {
		subjectController = (SubjectController)Optional.ofNullable(session.getAttribute("sessionSubjectController"))
				.orElse(new SubjectController((String)session.getAttribute("sessionUser")));
		session.setAttribute("sessionSubjectController", subjectController);
		
		subjectMap = subjectController.readSubject();
		session.setAttribute("sessionSubjectMap", subjectMap);
		
		planController = (PlanController)Optional.ofNullable(session.getAttribute("sessionPlanController"))
				.orElse(new PlanController((String)session.getAttribute("sessionUser")));
		session.setAttribute("sessionPlanController", planController);
		
		whichWeek = (int)session.getAttribute("sessionWhichWeek");
		
		int result = planController.savePlan(year, month, whichWeek, chosenDayList, chosenSubject);
		if(result == 1) {
			session.setAttribute("sessionMessage", "[SUCCESS] the plan saved");
		} else if(result == -1) {
			session.setAttribute("sessionMessage", "[failed] DB connection error...");
		}
		
	}
	
	%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	.weekTable > .rows {
		margin: 0;
		padding: 0;
	}
	
		.weekTable > .rows > .day {
			width: 35px;
			height: 35px;
			display: inline-block;
			margin: 0;
			padding: 0;
			border: 0.2px solid;
		}
		
		.weekTable > .rows > .sat {
			color: dodgerblue;
		}
		
		.weekTable > .rows > .sun {
			color: tomato;
		}
		
		.weekTable > .rows > .oneday {
			margin: 0 0px 0 0px;
		}
		
		.weekTable > .rows > .checkbox {
			display: none;
		}
		
		<%
		for(int i = 1; i <= 7; i++) {
			%>.weekTable > .selection > input:nth-of-type(<%=i %>):checked ~ label.oneday:nth-of-type(<%=i %>) {
	            background-color: Dodgerblue;
	        }
	        
	        .weekTable > .selection > input:nth-of-type(<%=i %>):hover ~ label.oneday:nth-of-type(<%=i %>) {
	            background-color: Tomato;
	        }
	        <%
		}
		%>
	
</style>
</head>
<body>
	<div class="menu subjects2">
		<form method="get" action="index.jsp">
		<label for="chooseWeek">weeks:</label>
		<select id="chooseWeek" name="chooseWeek" >
			<option value="0" >whole</option>
			<%
			for(int i = 1; i <= weeks; i++) {
				%><option value="<%=i %>"><%=i %></option><%
			}
			%>
		</select>
		<input type="submit" value="Load week" />
		</form>
		<hr />
		<div class="weekTable">
			<div class="rows top">
				<div class="day mon">Mon</div>
				<div class="day tue">Tue</div>
				<div class="day wed">wed</div>
				<div class="day thur">Thur</div>
				<div class="day fri">Fri</div>
				<div class="day sat">Sat</div>
				<div class="day sun">Sun</div>
			</div>
			<form method="get" action="index.jsp" class="rows selection">
				<%
				if(chosenWeek != null) {
					for(int j = 0; j < chosenWeek.size(); j++) {
						%><input type="checkbox" name="checkbox" class="checkbox" id="checkbox<%=j %>" value="<%=j %>" />	
						<label for="checkbox<%=j %>" class="day oneday d<%= chosenWeek.get(j) %>">
							<%= chosenWeek.get(j) %></label><%
					}
				}
				%>
				<br />
				<label for="chooseSubject">subject:</label>
				<select id="chooseSubject" name="chooseSubject">
				<%
				try {
					if(session.getAttribute("sessionUser") != null) {
						for(int i = 1; i <= subjectMap.size(); i++) {
							%><option value="<%=subjectMap.get(i).getSid() %>">
							<%=subjectMap.get(i).getSid() %>: <%=subjectMap.get(i).getSubjectName() %></option><%
						}
					}
				}catch (NullPointerException e) {
					e.printStackTrace();
				}
				%>
				</select>
				<input type="submit" value="save plan" />
			</form>
		</div>
	</div>
</body>
</html>