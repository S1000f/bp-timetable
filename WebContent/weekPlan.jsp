<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Optional"%>
<%@page import="model.InitSubject"%>
<%@include file="initializer.jsp" %>

	<%
	List<String> chosenWeek = null;
	int chooseWeek = Integer.valueOf(Optional.ofNullable(request.getParameter("chooseWeek")).orElse("0"));
	
	if(chooseWeek >= 0) {
		chosenWeek = drawing.getWeek(chooseWeek);
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
		
		
			.weekTable > .rows input:nth-of-type(1):checked ~ section.buttons > label:nth-child(1) {
	            background-color: white;
	            color: black;
	        }
	
	        .weekTable > .rows input:nth-of-type(2):checked ~ section.buttons > label:nth-child(2) {
	            background-color: white;
	            color: black;
	        }
        
</style>
</head>
<body>
	<div class="menu subjects2">
	<form method="get" action="index.jsp" class="form">
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
		<hr />
		<div class="weekTable">
			<div class="rows top">
				<div class="day mon">mon</div>
				<div class="day tue">tue</div>
				<div class="day wed">wed</div>
				<div class="day thur">thur</div>
				<div class="day fri">fri</div>
				<div class="day sat">sat</div>
				<div class="day sun">sun</div>
			</div>
			<div class="rows week1">
			<form method="get" action="weekPlan.jsp" >
				<%
				if(chosenWeek != null) {
					for(int j = 0; j < chosenWeek.size(); j++) {
						%><input type="checkbox" class="checkbox" id="checkbox<%=j %>" value="<%=j %>" />	
						<label for="checkbox<%=j %>" class="day oneday d<%= chosenWeek.get(j) %>" id="<%= chosenWeek.get(j) %>"><%= chosenWeek.get(j) %></label><%
					}
				}
				%>
			</form>
			</div>
		</div>
		<input type="submit" value="set subjects" />
	</form>
	</div>
</body>
</html>