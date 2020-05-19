<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList" %>
<%@ page import="java.util.Optional" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BP TimeTable</title>

<style type="text/css">

	.header {
		height: 220px;
		overflow: hidden;
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
		<jsp:include page="subjectView.jsp" flush="false" />
		<jsp:include page="weekPlan.jsp" flush="false" />
	</div>
	<hr />
		<jsp:include page="message.jsp" flush="false" />
	<hr />
	<div class="include calendar">
		<jsp:include page="calendar.jsp" flush="false" />
	</div>
</body>
</html>