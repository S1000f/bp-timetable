<%@page import="java.util.Optional"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.MyCal"%>
<%@ page import="model.InitCal" %>
<%@ page import="model.DrawCal" %>

	<%!
	int on = -1;
	int subjectWeekPositon = 0;
	String subjectName;
	String year;
	String month;
	
	List<String> week1 = null;
	List<String> week2 = null;
	List<String> week3 = null;
	List<String> week4 = null;
	List<String> week5 = null;
	List<String> week6 = null;
	%>
	
	<%--making subjects --%>
	<%
	// TODO
	on = (Integer)session.getAttribute("turnOn");
	
	if(on == 1) {
		subjectName = (String)session.getAttribute("sessionSubjectName");
	} else if(on == 0 || on == -1) {
		subjectName = "";
	}
	%>
	
	<%--drawing calendar --%>
	<%
	// TODO
	if(on == -1) {
		year = request.getParameter("year");
		month = request.getParameter("month");
		
		session.setAttribute("sessionYear", year);
		session.setAttribute("sessionMonth", month);
	}
	
	year = Optional.ofNullable((String)session.getAttribute("sessionYear")).orElse("2077");
	month = Optional.ofNullable((String)session.getAttribute("sessionMonth")).orElse("12");
	
	InitCal initcal = new InitCal();
	int weeks = initcal.initMyCal(year, month);
	DrawCal drawing = initcal.getDrawCal();
	
	week1 = drawing.getFirstWeek();
	week2 = drawing.getSecondWeek();
	week3 = drawing.getThirdWeek();
	week4 = drawing.getFourthWeek();
	week5 = drawing.getFifthWeek();
	week6 = drawing.getLastWeek();
	
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
			padding: 0;
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
					margin: 0px 3px 0 3px;
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
				
				<%
				// TODO
				if(on == 1) {
					%>.container > .cal > .rows > .day > div.subject {
						background-color: dodgerblue;
					}<%
				} else {
					
				}
				%>
				
				<%
				// TODO
				if(on == 1) {
					%>.container > .cal > .week<%= subjectWeekPositon %> > .day > div.subject {
						
					
					
					}<%
				} else {
					
				}
				%>
				
</style>
</head>
<body>
	<div class="wrap">
		<div class="container">
			<div class="cal cal01">
				<h2><%=year %>&nbsp;<%=month %></h2>
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
						%><div class="day oneday d<%= week1.get(j) %>" id="<%= week1.get(j) %>"><%= week1.get(j) %>
							<div class="subject s<%= week1.get(j) %>"><%= subjectName %></div>
						</div><%
					}
					%>
				</div>
				<div class="rows week2">
					<%
					for(int j = 0; j < week2.size() ; j++) {
						%><div class="day oneday d<%= week2.get(j) %>" id="<%= week2.get(j) %>"><%= week2.get(j) %>
							<div class="subject s<%= week2.get(j) %>"><%= subjectName %></div>
						</div><%
					}
					%>
				</div>
				<div class="rows week3">
					<%
					for(int j = 0; j < week3.size(); j++) {
						%><div class="day oneday d<%= week3.get(j) %>" id="<%= week3.get(j) %>"><%= week3.get(j) %>
							<div class="subject s<%= week3.get(j) %>"><%= subjectName %></div>
						</div><%
					}
					%>
				</div>
				<div class="rows week4">
					<%
					for(int j = 0; j < week4.size(); j++) {
						%><div class="day oneday d<%= week4.get(j) %>" id="<%= week4.get(j) %>"><%= week4.get(j) %>
							<div class="subject s<%= week4.get(j) %>"><%= subjectName %></div>
						</div><%
					}
					%>
				</div>
				<div class="rows week5">
					<%
					if(weeks >= 5) {
						for(int j = 0; j < week5.size(); j++) {
							%><div class="day oneday d<%= week5.get(j) %>" id="<%= week5.get(j) %>"><%= week5.get(j) %>
							<div class="subject s<%= week5.get(j) %>"><%= subjectName %></div>
						</div><%
						}
					}
					%>
				</div>
				<div class="rows week6">
					<%
					if(weeks >= 6) {
						for(int j = 0; j < week6.size(); j++) {
							%><div class="day oneday d<%= week6.get(j) %>" id="<%= week6.get(j) %>"><%= week6.get(j) %>
							<div class="subject s<%= week6.get(j) %>"><%= subjectName %></div>
						</div><%
						}
					}
					%>
				</div>
			</div>		
		</div>
	</div>	
	<hr />
</body>
</html>