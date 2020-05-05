<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Optional" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	body {
		font-size: 14px;		
	}
</style>
</head>
<body>
	>>> <%=(String)Optional.ofNullable(session.getAttribute("sessionMessage")).orElse("log in or sign up, please") %>
</body>
</html>