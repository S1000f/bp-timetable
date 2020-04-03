<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.MyCal"%>
<%@ page import="model.InitCal" %>
<%@ page import="model.DrawCal" %>

	<%
	String year = null;
	String month = null;

	List<String> week1 = null;
	List<String> week2 = null;
	List<String> week3 = null;
	List<String> week4 = null;
	List<String> week5 = null;
	List<String> week6 = null;
	
	year = request.getParameter("year");
	month = request.getParameter("month");

	InitCal initcal = new InitCal();
	int weeks = initcal.initMyCal(year, month);
		
	try {
		DrawCal drawing = initcal.getDrawCal();
		week1 = drawing.getFirstWeek();
		week2 = drawing.getSecondWeek();
		week3 = drawing.getThirdWeek();
		week4 = drawing.getFourthWeek();
		week5 = drawing.getFifthWeek();
		week6 = drawing.getLastWeek();
		
	} catch(Exception e) {
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
			width: 460px;
			margin: 0 auto;
			padding: 0;
		}
		
			.container > .cal > div.rows {
				width: 450px;
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
					margin: 2px 2.1px 0 2.1px;
				}
				
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
						%><div class="day oneday"><%= week1.get(j) %></div><%
					}
					%>
				</div>
				<div class="rows week2">
					<%
					for(int j = 0; j < week2.size(); j++) {
						%><div class="day oneday"><%= week2.get(j) %></div><%
					}
					%>
				</div>
				<div class="rows week3">
					<%
					for(int j = 0; j < week3.size(); j++) {
						%><div class="day oneday"><%= week3.get(j) %></div><%
					}
					%>
				</div>
				<div class="rows week4">
					<%
					for(int j = 0; j < week4.size(); j++) {
						%><div class="day oneday"><%= week4.get(j) %></div><%
					}
					%>
				</div>
				<div class="rows week5">
					<%
					if(weeks >= 5) {
						for(int j = 0; j < week5.size(); j++) {
							%><div class="day oneday"><%= week5.get(j) %></div><%
						}
					}
					%>
				</div>
				<div class="rows week6">
					<%
					if(weeks >= 6) {
						for(int j = 0; j < week6.size(); j++) {
							%><div class="day oneday"><%= week6.get(j) %></div><%
						}
					}
					%>
				</div>
			</div>		
		</div>
	</div>	
	<hr />
	
	<jsp:useBean id="InitCal" class="model.InitCal">
		<jsp:setProperty name="InitCal" property="year" />
		<jsp:setProperty name="InitCal" property="month" />
	</jsp:useBean>
	
</body>
</html>