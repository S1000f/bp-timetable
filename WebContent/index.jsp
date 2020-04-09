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
	<div class="include header">
		<jsp:include page="loginForm.jsp" flush="false" />
		<jsp:include page="calendarForm.jsp" flush="false" />
		<jsp:include page="subjectsForm.jsp" flush="false" />
	</div>
	<hr />
	<div class="include calendar">
		<jsp:include page="calendar.jsp" flush="false" />
	</div>

</body>
</html>