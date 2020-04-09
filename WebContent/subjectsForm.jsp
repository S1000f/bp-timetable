<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="menu subjects">
	<form method="get" action="index.jsp">
		<label for="subjectName">subjects:</label>
			<select id="subjectName" name="subjectName">
				<option value="C">C</option>
				<option value="C++">C++</option>
				<option value="C#">C#</option>
				<option value="Java">Java</option>
				<option value="JSP">JSP</option>
				<option value="Spring">Spring</option>
				<option value="Linux">Linux</option>
			</select>
			<br />
		<input type="number" name="turnOn" placeholder="0 or 1" required/>
		<br />
		<input type="submit" value="set subjects" />
	</form>
	</div>
	
	<%
	String strTurnOn = Optional.ofNullable(request.getParameter("turnOn")).orElse("-1");
	int turn = Integer.valueOf(strTurnOn);
	session.setAttribute("turnOn", turn);
	
	String strSubjectName = Optional.ofNullable(request.getParameter("subjectName")).orElse("");
	session.setAttribute("sessionSubjectName", strSubjectName);
	
	%>
	
	
</body>
</html>