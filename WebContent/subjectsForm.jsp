<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%
	String strTurnOn = Optional.ofNullable(request.getParameter("turnOn")).orElse("-1");
	int turn = Integer.valueOf(strTurnOn);
	session.setAttribute("turnOn", turn);
	
	String strSubjectName = Optional.ofNullable(request.getParameter("subjectName")).orElse("");
	session.setAttribute("sessionSubjectName", strSubjectName);
	
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="menu subjects">
		<form method="get" action="index.jsp">
			<label for="subjectNamed">Subject Name:</label>
			<input type="text" name="subjectNamed" placeholder="required"required/><br />
			<label for="colorTag">Color Tag:</label>
			<input type="color" name="colorTag" placeholder="colors" required/><br />
			<label for="sid">SID:</label>
			<input type="number" name="sid" placeholder="not required" /><br />
			<label for="teacher">Teacher:</label>
			<input type="text" name="teacher" placeholder="not required"/><br />
			<label for="desc">Description:</label>
			<input type="text" name="desc" placeholder="not required" /><br />
			<br />
			<input type="number" name="turnOn" placeholder="0 or 1" required/>
			<br />
			<input type="submit" value="set subjects" />
		</form>
	</div>
	
	
</body>
</html>