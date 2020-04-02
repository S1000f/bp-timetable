<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="model.DAOBase"%>
<%@ page import="model.MyCal"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BP Time Table</title>
</head>
<body>
	<form method="get" action="index.jsp">
		<input type="text" name="year" placeholder="year" /><br />
		<label for="month">Choose month:</label>
		<select id="month" name="month">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
		</select>
		<input type="submit" value="make a timetable" />
	</form>

	<%
		String year = request.getParameter("year");
		String month = request.getParameter("month");
	%>

	<jsp:include page="forward.jsp" flush="false">
		<jsp:param name="year" value="<%=year%>" />
		<jsp:param name="month" value="<%=month%>" />
	</jsp:include>


</body>
</html>