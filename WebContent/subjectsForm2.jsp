<%@page import="model.InitSubject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    InitSubject initSub = new InitSubject();
    
    
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="menu subjects2">
	<form method="get" action="index.jsp">
		<label for="chooseWeek">weeks:</label>
			<select id="chooseWeek" name="chooseWeek">
			<%
			for(int i = 1; i <= weeks )
			%>
				<option value="C">C</option>
				
			</select>
			<br />
		<input type="number" name="turnOn" placeholder="0 or 1" required/>
		<br />
		<input type="submit" value="set subjects" />
	</form>
	</div>
</body>
</html>