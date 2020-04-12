<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Optional"%>
<%@page import="model.InitSubject"%>
<%@include file="initializer.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.form {
	}

	.weekTable {
		
	}
	
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

</style>
</head>
<body>
	<div class="menu subjects2">
	<form method="get" action="index.jsp" class="form">
		<label for="chooseWeek">weeks:</label>
		<select id="chooseWeek" name="chooseWeek">
			<option value="<%=weeks %>" >whole</option>
			<%
			for(int i = 1; i <= weeks; i++) {
			%><option value="1"><%=i %></option><%
			}
			%>
		</select>
		<br />
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
				<%
				for(int j = 0; j < week1.size(); j++) {
					%><div class="day oneday d<%= week1.get(j) %>" id="<%= week1.get(j) %>"><%= week1.get(j) %></div><%
				}
				%>
			</div>
		</div>
		<input type="submit" value="set subjects" />
	</form>
	</div>
</body>
</html>