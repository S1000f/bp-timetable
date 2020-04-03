<%@page import="model.InitCal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.MyCal"%>
<%@ page import="model.InitCal" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<div class="container">
			<div class="cal cal01">
				<div class="top">
					<div id="mon">mon</div>
					<div id="tue">tue</div>
					<div id="wed">wed</div>
					<div id="thur">thur</div>
					<div id="fri">fri</div>
					<div id="sat">sat</div>
					<div id="sun">sun</div>
				</div>
				<div class="weeks">
					<div class="first-week"></div>
					<div class="second-week"></div>
					<div class="third-week"></div>
					<div class="fourth-week"></div>
					<div class="fifth-week"></div>
					<div class="last-week"></div>
				</div>			
			</div>		
		</div>
	</div>	
	
	<hr />
	<jsp:useBean id="InitCal" class="model.InitCal">
		<jsp:setProperty name="InitCal" property="year" />
		<jsp:setProperty name="InitCal" property="month" />
		jsp:getproperty >>> [<jsp:getProperty name="InitCal" property="year" />]<br />
		jsp:getproperty >>> [<jsp:getProperty name="InitCal" property="month" />]<br />
		jsp:getProperty >>> [<jsp:getProperty name="InitCal" property="firstday" />]<br />
		jsp:getProperty >>> [<jsp:getProperty name="InitCal" property="lastday" />]
	</jsp:useBean>
	
</body>
</html>