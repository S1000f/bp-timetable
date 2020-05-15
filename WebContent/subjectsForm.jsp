<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="model.data.SubjectDto"%>

<%@include file="initializer.jsp" %>
    
<%
	
	int sid;
	String subjectName;
	String colorTag;
	String teacher;
	String desc;
	int addResult;
	
	if(request.getParameter("sid") != null && session.getAttribute("sessionUser") != null) {
		sid = Integer.valueOf(request.getParameter("sid"));
		subjectName = request.getParameter("subjectNamed");
		colorTag = request.getParameter("colorTag");
		teacher = request.getParameter("teacher");
		desc = request.getParameter("desc");
		
		subjectController = (SubjectController)Optional.ofNullable(session.getAttribute("sessionSubjectController"))
				.orElse(new SubjectController((String)session.getAttribute("sessionUser")));
		session.setAttribute("sessionSubjectController", subjectController);
		
		addResult = subjectController.addSubject(sid, subjectName, colorTag, teacher, desc);

		if(addResult == 1) {
			session.setAttribute("sessionMessage", "[SUCCESS] the subject added (SID: " + sid + " name: " + subjectName +")");
			subjectMap = subjectController.readSubject();
		} else if(addResult >= 10) {
			session.setAttribute("sessionMessage", "[failed] you can save 10 subjects only...");
		} else {
			session.setAttribute("sessionMessage", "[failed] operation failed, retry please...");
		}
		
	} else if(request.getParameter("sid") != null && session.getAttribute("sessionUser") == null) {
		session.setAttribute("sessionMessage", "[failed] please, Log in first!");
	}
	
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subject Form</title>
<style>
	.nameTag {
		display: inline-block;
		font-size: 14px;
		height: 14px;
		width: 100px;
	}
	
	.subjects > form > input {
		display: inline-block;
		width: 100px;
	}
</style>
</head>
<body>
	<div class="menu subjects">
		<form method="get" action="index.jsp">
			<label for="sid" class="nameTag">SID:</label>
			<input type="number" name="sid" placeholder="required, unique" min="1" max="999999" required /><br />
			<label for="subjectNamed" class="nameTag">Subject Name:</label>
			<input type="text" name="subjectNamed" placeholder="required" required/><br />
			<label for="colorTag" class="nameTag">Color Tag:</label>
			<input type="color" name="colorTag" placeholder="colors" value="#1E90FF" /><br />
			<label for="teacher" class="nameTag">Teacher:</label>
			<input type="text" name="teacher" placeholder="optional"/><br />
			<label for="desc" class="nameTag">Description:</label>
			<input type="text" name="desc" placeholder="optional" /><br />
			<input type="submit" value="add subject" />
		</form>
	</div>
</body>
</html>