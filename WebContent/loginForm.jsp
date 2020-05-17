<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="controller.LoginController"%>
<%@page import="java.util.Optional" %>

<%@include file="initializer.jsp" %>

<%
	strUser = Optional.ofNullable(request.getParameter("user")).orElse("");
	passwd = request.getParameter("password");
	signUpCheck = Optional.ofNullable(request.getParameter("sign-up")).orElse("off");
	logout = request.getParameter("logout");
	
	if(strUser != null && passwd != null && signUpCheck.equals("off")) {
		loginController = new LoginController();
		loginResult = loginController.loginUser(strUser, passwd);
		
		if(loginResult == 1) {
			user = strUser;
			session.setAttribute("sessionID", session.getId());
			session.setAttribute("sessionUser", strUser);
			session.setAttribute("sessionMessage", "[SUCCESS] log-in success ");
			request.setAttribute("login", "login");
			
		} else {
			session.setAttribute("sessionMessage", "[failed] incorrect id or password!");
			loginResult = 0;
		}
	} else if(strUser != null && passwd != null && signUpCheck.equals("on")) {
		session.setAttribute("sessionMessage", "sign-up processing...");
		loginController = new LoginController();
		int check = loginController.signUp(strUser, passwd);
		
		if(check == 1) {
			session.setAttribute("sessionMessage", "[SUCCESS] registered successfully!, log in please");
		} else if(check == 2) {
			session.setAttribute("sessionMessage", "[failed] sorry, try other names...");
		} else {
			session.setAttribute("sessionMessage", "[failed] DB connection problems, try agian later or contact the admin");
		}
		
	}
	
	if(logout != null) {
		session.invalidate();
		loginResult = 0;
	}
	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<style type="text/css">

	div.loginforms {
		width: 130px;
		height: 100px;
	}
	
	input.input {
		width: 115px;
	}

	div.login {
		text-align: center;
		<%
		if(loginResult == 0) {
			%>display: none;<%
		} else if(loginResult == 1) {
			%>display: block;
			background-color: #f0f0f0;<%
		}
		%>
	}
	
	form.loginForm {
		<%
		if(loginResult == 1) {
			%>display: none;<%
		} else if(loginResult == 0) {
			%>display: block;<%
		}
		%>
	}
	
	label {
		font-size: 12px;
	}
	
	input.logout {
		display: none;
	}
	
</style>
</head>
<body>
	<div class="menu loginforms">
		<div class="login">
			<h5>Welcome!<br /><%=user %></h5><br />
			<form method="get" action="index.jsp" >
				<input type="text" name="logout" value="logout" class="logout" />
				<input type="submit" value="log out">
			</form>
		</div>
		<form method="post" action="index.jsp" class="loginForm">
			<input type="text" name="user" placeholder="user name" class="input" required/><br />
			<input type="password" name="password" placeholder="password" class="input" required/><br />
			<input type="submit" value="log in" /><br />
			<label for="sign-up" >check for sign-up</label><input type="checkbox" name="sign-up" value="on" /><br/>
			<input type="submit" value="sign up" /> 
		</form>
	</div>
</body>
</html>
