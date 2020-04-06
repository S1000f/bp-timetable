<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
	<div class="menu loginform">
		<form method="get" action="index.jsp">
			<input type="text" name="user" placeholder="user name" required/><br />
			<input type="password" name="password" placeholder="password" required/><br />
			<input type="submit" value="log in" /> 
		</form>
	</div>
</body>
</html>