<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Optional"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Arrays" %>

<%@include file="initializer.jsp" %>

	<%
	int whichWeek;
	String[] str;
	String chosenSubject;
	List<String> chosenWeek;
	List<String> chosenDayList;
	
	whichWeek = Integer.valueOf(Optional.ofNullable(request.getParameter("chooseWeek")).orElse("0"));
	chosenWeek = calController.getWeeksContainer().get(whichWeek);
	
	str = Optional.ofNullable(request.getParameterValues("checkbox")).orElse(new String[] {"0"});
	chosenDayList = new ArrayList<>(Arrays.asList(str));
	
	subjectNamesList = Optional.ofNullable((List<String>)session.getAttribute("sessionSubjectNamesList"))
			.orElse(new ArrayList<String>(Arrays.asList("---")));
	
	chosenSubject = Optional.ofNullable(request.getParameter("chooseSubject")).orElse("undefined");
	
	// TODO revision
	if(chosenSubject != null) {
		planController.savePlan(year, month, whichWeek, chosenDayList, chosenSubject);
		weekPlanMap = planController.loadPlan();
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
	        }<%
		}
		%>
	
</style>
</head>
<body>
	<div class="menu subjects2">
		<form method="get" action="index.jsp">
		<label for="chooseWeek">weeks:</label>
		<select id="chooseWeek" name="chooseWeek">
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
					for(int i = 0; i < subjectNamesList.size(); i++) {
						%><option value="<%=subjectNamesList.get(i) %>"><%=subjectNamesList.get(i) %></option><%
					}
					%>
				</select>
				<input type="submit" value="save plan" />
			</form>
		</div>
	</div>
</body>
</html>