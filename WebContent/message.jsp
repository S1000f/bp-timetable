<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Optional" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	.messenger {
		font-size: 14px;
		font-weight: bolder;	
	}
</style>
</head>
<body>
	<div class="messenger">
	>>> <%=(String)Optional.ofNullable(session.getAttribute("sessionMessage")).orElse("log in or sign up, please") %>
	</div>
</body>
</html>