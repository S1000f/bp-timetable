<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="menu calendar">
		<form method="get" action="index.jsp" >
			<label for="year">year:</label>
			<input type="number" name="year" placeholder="input year" min="1000" value="2020" required/><br />
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
</body>
</html>