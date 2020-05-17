<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="controller.LoginController"%>
<%@page import="java.util.Optional" %>

<%@include file="initializer.jsp" %>

<%
	//loginForm.jsp
	String strUser;
	String passwd;
	String signUpCheck;
	String logout;
	int loginResult;
	String userName = "";
	
	strUser = Optional.ofNullable(request.getParameter("user")).orElse("guest");
	passwd = request.getParameter("password");
	signUpCheck = Optional.ofNullable(request.getParameter("sign-up")).orElse("off");
	logout = request.getParameter("logout");
	
	if(strUser != null && passwd != null && signUpCheck.equals("off")) {
		
		loginController = new LoginController();
		loginResult = loginController.loginUser(strUser, passwd);
		
		// TODO session
		if(loginResult == 1) {
			session.setAttribute("sessionID", session.getId());
			session.setAttribute("sessionUser", strUser);
			session.setAttribute("sessionMessage", "[SUCCESS] log-in success ");
			request.setAttribute("login", "login");
			
		} else {
			session.setAttribute("sessionMessage", "[failed] incorrect id or password!");
		}
	} else if(strUser != null && passwd != null && signUpCheck.equals("on")) {
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
	try{
		String sessionID = (String)session.getAttribute("sessionID");
		if(logout != null && sessionID.equals(session.getId())) {
			session.removeAttribute("sessionUser");
			session.removeAttribute("sessionID");
			session.invalidate();
			loginResult = 0;
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	try{
		if(session.getAttribute("sessionUser") != null) {
			userName = (String)session.getAttribute("sessionUser");
		}
		} catch(Exception e) {
			
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

	.login-success {
		text-align: center;
		<%
		try{
			if(!userName.equals(""))    {
				%>display: block;
				background-color: #f0f0f0;<%
			} else {
				%>display: none;<%
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		%>
	}
	
	form.loginForm {
		<%
		try{
		if(session.getAttribute("sessionID") == null) {
			%>display: block;<%
		} else{
			%>display: none;<%
		}
		} catch(Exception e) {
			e.printStackTrace();
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
		<div class="login-success">
			<h5>Welcome!<br />
			<%=userName %></h5><br />
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
