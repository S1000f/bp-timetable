<%@page import="controller.LoginController"%>
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
		<form method="post" action="index.jsp">
			<input type="text" name="user" placeholder="user name" required/><br />
			<input type="password" name="password" placeholder="password" required/><br />
			<input type="submit" value="log in" />&nbsp;&nbsp;<input type="submit" value="sign up" /> 
		</form>
	</div>
</body>
</html>

<%
	LoginController loginController;
	String strUser = request.getParameter("user");
	String passwd = request.getParameter("password");
	int loginResult;
	String loginMessage;
	
	// start here
	if(strUser != null) {
		loginController = new LoginController(strUser, passwd);
		loginResult = loginController.loginUser();
		if(loginResult == 0) {
			session.setAttribute("sessionUser", strUser);
			loginMessage = "Welcome";
		} else {
			loginMessage = "incorrct user Id or password";
		}
	}
	
	
%>



