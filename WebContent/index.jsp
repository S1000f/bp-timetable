<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BP TimeTable</title>

<style type="text/css">

	.header {
		display: inline-block;
		height: 70px;
	}
	
	.header > .menu {
		display: inline-block;
		margin: 0 20px 0 10px;
	}

</style>
</head>
<body>
	<div class="header">
		<jsp:include page="loginForm.jsp" flush="false" />
		<div class="menu calendar">
			<form method="get" action="index.jsp">
				<input type="number" name="year" placeholder="year" required/><br />
				<label for="month">month:</label>
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
				<br />
				<input type="submit" value="create a timetable" />
			</form>
		</div>
	</div>
	<hr />
	<div class="include calendar">
		<jsp:include page="calendar.jsp" flush="false" />
	</div>
	

</body>
</html>