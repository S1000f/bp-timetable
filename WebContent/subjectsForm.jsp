<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.Optional"%>
<%@page import="model.data.SubjectDto"%>
    
	<%
	SubjectDto subjectOne;
	
	// TODO implement later
	String user = "mock";
	
	int sid;
	String subjectName;
	String colorTag;
	String teacher;
	String desc;
	
	// TODO start here
	if(request.getParameter("sid") != null) {
		sid = Integer.valueOf(request.getParameter("sid"));
		subjectName = request.getParameter("subjectNamed");
		colorTag = request.getParameter("colorTag");
		teacher = Optional.ofNullable(request.getParameter("teacher")).orElse("teacher");
		desc = Optional.ofNullable(request.getParameter("desc")).orElse(subjectName);
		
		subjectOne = new SubjectDto(user, sid, subjectName, colorTag, teacher, desc);
		
	}
	
	
	
	String strTurnOn = Optional.ofNullable(request.getParameter("turnOn")).orElse("-1");
	int turn = Integer.valueOf(strTurnOn);
	session.setAttribute("turnOn", turn);
	
	String strSubjectName = Optional.ofNullable(request.getParameter("subjectNamed")).orElse("");
	session.setAttribute("sessionSubjectName", strSubjectName);
	
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.nameTag {
		display: inline-block;
		font-size: 14px;
		height: 14px;
		width: 100px;
	}
	input {
		display: inline-block;
	}
</style>
</head>
<body>
	<div class="menu subjects">
		<form method="get" action="index.jsp">
			<label for="sid" class="nameTag">SID:</label>
			<input type="number" name="sid" placeholder="required" required /><br />
			<label for="subjectNamed" class="nameTag">Subject Name:</label>
			<input type="text" name="subjectNamed" placeholder="required" required/><br />
			<label for="colorTag" class="nameTag">Color Tag:</label>
			<input type="color" name="colorTag" placeholder="colors" value="#1E90FF" /><br />
			<label for="teacher" class="nameTag">Teacher:</label>
			<input type="text" name="teacher" placeholder="optional"/><br />
			<label for="desc" class="nameTag">Description:</label>
			<input type="text" name="desc" placeholder="optional" /><br />
			<input type="submit" value="set subjects" />
		</form>
	</div>
</body>
</html>