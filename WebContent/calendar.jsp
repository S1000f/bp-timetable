<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="initializer.jsp" %>

<%
	List<String> empty = new ArrayList<>(Arrays.asList("","","","","","",""));
	try{
		if(session.getAttribute("sessionUser") == null) {
			for(int i = 0; i < 7; i++) {
				subNamesMap.replace(i, empty);
				subTagsMap.replace(i, empty);
			}
		}
	} catch(Exception e){
		e.printStackTrace();
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Timetable</title>
<style>
	.wrap {
		width: 1020px;
		margin: 0 auto;
	}
	
	.container {
		width: 800px;
		margin: 0 auto;
	}
	
		.container > .cal {
			width: 480px;
			margin: 0 auto;
			padding: 20px;
		}
		
			.container > .cal > div.rows {
				width: 480px;
				margin: 0 auto;
				padding: 0;
				font-weight: bold;
				font-size: 18px;
			}
			
				.container > .cal > .top > div.sat {
					color: dodgerBlue;
				}
				
				.container > .cal > .top > div.sun {
					color: tomato;
				}
			
				.container > .cal > .rows > div.day {
					width: 60px;
					height: 60px;
					margin: 0;
					padding: 0;
					display: inline-block;
					border-bottom: 0.2px solid;
				}
				
				.container > .cal > .rows > div.oneday {
					margin: 0px 4px 0 2px;
					height: 60px;
					border-bottom: 0;
					position: relative;
				}
				
				.container > .cal > .rows > .day > div.subject {
					width: 60px;
					height: 20px;
					margin: 0;
					padding: 0;
					border-bottom: 0.2px solid;
					position: absolute;
					top: 40px;
					font-size: 14px;
				}
				
</style>
</head>
<body>
	<div class="wrap">
		<div class="container">
			<div class="cal cal01">
				<h2><%=year %>&nbsp;<%=month %></h2>
				<div class="rows top">
					<div class="day mon">Mon</div>
					<div class="day tue">Tue</div>
					<div class="day wed">Wed</div>
					<div class="day thur">Thur</div>
					<div class="day fri">Fri</div>
					<div class="day sat">Sat</div>
					<div class="day sun">Sun</div>
				</div>
				<%
				try{
					for(int i = 1; i <= weeks; i++) {
						%><div class="rows week<%=i %>"><%
						for(int j = 0; j < weeksContainer.get(i).size(); j++) {
							
							%><div class="day oneday d<%= weeksContainer.get(i).get(j) %>"><%=weeksContainer.get(i).get(j) %>
								<div class="subject s<%= weeksContainer.get(i).get(j) %>" style="background-color:
								<%=subTagsMap.getOrDefault(i, empty).get(j) %>">
								<%=subNamesMap.getOrDefault(i, empty).get(j) %></div>
							</div><%
						}
						%></div><%
					}
				} catch(NullPointerException e) {
					e.printStackTrace();
				}
				%>
			</div>		
		</div>
	</div>	
	<hr />
</body>
</html>